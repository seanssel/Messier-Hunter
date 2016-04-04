package us.selvig.android.messier_hunter.database;

import android.content.Context;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

/**
 * This class uses the SQLiteAssetHelper class to faciliate
 * the creation of the application database using the pre-populated
 * database in assets.
 *
 * For more info regarding SQLiteAssetHelper:
 * https://github.com/jgilfelt/android-sqlite-asset-helper
 */
public class MessierDatabaseHelper extends SQLiteAssetHelper {

  private static final String DB_NAME = "messier-catalog.db";
  private static final int DB_VERSION = 1;

  public MessierDatabaseHelper(Context context) {
    super(context, DB_NAME, null, DB_VERSION);
  }
}
