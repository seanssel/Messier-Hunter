package us.selvig.android.messier_hunter;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import us.selvig.android.messier_hunter.database.MessierCursorWrapper;
import us.selvig.android.messier_hunter.database.MessierDatabaseHelper;

import static us.selvig.android.messier_hunter.database.MessierDbSchema.MessierTable;

/**
 * Singleton to store Messier objects
 */
public class MessierCatalog {
  private static MessierCatalog sMessierCatalog;

  private Context mContext;
  private SQLiteDatabase mDatabase;

  private MessierCatalog(Context context) {
    mContext = context.getApplicationContext();
    mDatabase = new MessierDatabaseHelper(mContext).getReadableDatabase();
  }

  /**
   * Returns an instance of this catalog; creates an instance if one doesn't already exist.
   * @param context the application context
   * @return a MessierCatalog instance
   */
  public static MessierCatalog getInstance(Context context) {
    if (sMessierCatalog == null) {
      sMessierCatalog = new MessierCatalog(context);
    }
    return sMessierCatalog;
  }

  /**
   * Queries the database to generate a list containing MessierObjects.
   * @return the list containing all MessierObjects according to the database
   */
  public List<MessierObject> getCatalog() {
    List<MessierObject> catalog = new ArrayList<>();
    MessierCursorWrapper cursor = queryDatabase(null, null);

    try {
      cursor.moveToFirst();
      while (!cursor.isAfterLast()) {
        catalog.add(cursor.getMessierObject());
        cursor.moveToNext();
      }
    } finally {
      cursor.close();
    }

    return catalog;

  }

  /** * Returns a single MessierObject according to the supplied UUID.
   *
   * @param id a crime's unique identifier
   * @return the crime with mathing id
   */
  public MessierObject getMessierObject (UUID id) {
    MessierCursorWrapper cursor = queryDatabase(
        MessierTable.Cols.UUID + " = ?",
        new String[] { id.toString() }
    );

    try {
      if (cursor.getCount() == 0) {
        return null;
      }

      cursor.moveToFirst();
      return cursor.getMessierObject();
    } finally {
      cursor.close();
    }
  }

  /**
   * Queries the database to generate a MessierCursorWrapper over the result set.
   * @param whereClause SQL WHERE clause, declaring the rows to return; null produces all rows
   * @param whereArgs fills in whereClause ?s
   * @return the MessierCursorWrapper generated over the result set
   */
  private MessierCursorWrapper queryDatabase(String whereClause, String[] whereArgs) {
    Cursor cursor =
        mDatabase.query(MessierTable.NAME, null, // columns parameter - null selects all columns
            whereClause, whereArgs, null, // groupBy
            null, // having
            null  // orderBy
        );
    return new MessierCursorWrapper(cursor);
  }

}
