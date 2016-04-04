package us.selvig.android.messier_hunter.database;

import android.database.Cursor;
import android.database.CursorWrapper;
import java.util.UUID;
import us.selvig.android.messier_hunter.MessierObject;
import us.selvig.android.messier_hunter.database.MessierDbSchema.MessierTable;

/**
 * Created by moya on 3/23/16.
 */

public class MessierCursorWrapper extends CursorWrapper {

  public MessierCursorWrapper(Cursor cursor) {
    super(cursor);
  }

  public MessierObject getMessierObject() {
    String uuid = getString(getColumnIndex(MessierTable.Cols.UUID));
    String name = getString(getColumnIndex(MessierTable.Cols.OBJECT));
    int number = getInt(getColumnIndex(MessierTable.Cols.NUMBER));
    String ngc = getString(getColumnIndex(MessierTable.Cols.NGC));
    String constellation = getString(getColumnIndex(MessierTable.Cols.CONSTELLATION));
    String type = getString(getColumnIndex(MessierTable.Cols.TYPE));
    float distance = getFloat(getColumnIndex(MessierTable.Cols.DISTANCE));

    MessierObject messierObject = new MessierObject(UUID.fromString(uuid));

    messierObject.setName(name);
    messierObject.setNum(number);
    messierObject.setNgc(ngc);
    messierObject.setConstellation(constellation);
    messierObject.setType(type);
    messierObject.setDistance(distance);

    return messierObject;
  }

}