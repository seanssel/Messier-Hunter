package us.selvig.android.messier_hunter;

import java.util.UUID;

/**
 * Created by moya on 3/22/16.
 */
public class MessierObject {
  private UUID mId;
  private String mName;
  private String mType;
  private String mConstellation;
  private int mNum;
  private int mNgc;
  private float mDistance;
  private boolean mObserved;

  public UUID getId() {
    return mId;
  }

  public String getName() {
    return mName;
  }

  public int getNum() {
    return mNum;
  }

  public String getConstellation() {
    return mConstellation;
  }

  public float getDistance() {
    return mDistance;
  }

  public int getNgc() {
    return mNgc;
  }

  public String getType() {
    return mType;
  }

  public boolean isObserved() {
    return mObserved;
  }

  public void setObserved(boolean observed) {
    mObserved = observed;
  }

}
