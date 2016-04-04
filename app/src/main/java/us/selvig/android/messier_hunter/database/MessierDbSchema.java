package us.selvig.android.messier_hunter.database;

/**
 * Database schema for SQLite Crime database.
 */
public class MessierDbSchema {
  public static final class MessierTable{
    public static final String NAME = "data";

    public static final class Cols {
      public static final String UUID = "m_uuid";
      public static final String OBJECT = "m_name";
      public static final String NUMBER = "m_num";
      public static final String NGC = "m_ngc";
      public static final String CONSTELLATION = "m_con";
      public static final String TYPE= "m_type";
      public static final String DISTANCE = "m_dist";

    }

  }
}
