package us.selvig.android.messier_hunter;

import java.util.UUID;

/**
 * Created by moya on 3/22/16.
 */
public class MessierObject {
  private UUID mUUID;
  private String mName;
  private String mType;
  private String mConstellation;
  private int mNum;
  private String mNgc;
  private float mDistance;
  private boolean mObserved;

  public MessierObject() {
    this(UUID.randomUUID());
  }

  public MessierObject(UUID uuid) {
    mUUID= uuid;
  }

  public UUID getUUID() {
    return mUUID;
  }

  public String getConstellation() {
    return mConstellation;
  }

  public void setConstellation(String constellation) {
    mConstellation = constellation;
  }

  public float getDistance() {
    return mDistance;
  }

  public void setDistance(float distance) {
    mDistance = distance;
  }

  public String getName() {
    return mName;
  }

  public void setName(String name) {
    mName = name;
  }

  public String getNgc() {
    return mNgc;
  }

  public void setNgc(String ngc) {
    mNgc = ngc;
  }

  public int getNum() {
    return mNum;
  }

  public void setNum(int num) {
    mNum = num;
  }

  public boolean isObserved() {
    return mObserved;
  }

  public void setObserved(boolean observed) {
    mObserved = observed;
  }

  public String getType() {
    return mType;
  }

  public void setType(String type) {
    mType = type;
  }
}
