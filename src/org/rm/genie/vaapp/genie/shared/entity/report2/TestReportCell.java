package org.rm.genie.vaapp.genie.shared.entity.report2;

import java.io.Serializable;


/**
 * Date: 10/9/13
 * Time: 5:57 PM
 *
 * @author etseytlin
 */
public class TestReportCell implements Serializable
{
  public final static int NOT_ASSIGNED = 0;
  public final static int ASSIGNED = 1;
  public final static int IN_PROGRESS = 2;

  public static final int UNKNOWN = -1;
  public static final int DIAGNOSED = 0;
  public static final int PASSED = 1;
  public static final int ADVANCED = 2;

  private int solved = 0;
  private int given = 0;
  private float ratio = -1;
  private short status = -1; // -1 - unknown (hasn't yet been studied), 0 - diagnosed, 1 - passed, 2 - advanced
  private int assigned = 0; // 0 - nothing, 1 - assigned, 2 - in progress
  private long objectiveID = 0;

  public int getSolved()
  {
    return solved;
  }

  public void setSolved(int solved)
  {
    this.solved = solved;
  }

  public int getGiven()
  {
    return given;
  }

  public void setGiven(int given)
  {
    this.given = given;
  }

  public float getRatio()
  {
    return ratio;
  }

  public void setRatio(float ratio)
  {
    this.ratio = ratio;
  }

  public int getAssigned()
  {
    return assigned;
  }

  public void setAssigned(int assigned)
  {
    this.assigned = assigned;
  }

  public long getObjectiveID()
  {
    return objectiveID;
  }

  public void setObjectiveID(long objectiveID)
  {
    this.objectiveID = objectiveID;
  }

  public short getStatus()
  {
    return status;
  }

  public void setStatus(short status)
  {
    this.status = status;
  }

  @Override
  public String toString()
  {
    return "c{" +
      "solved=" + solved +
      ", given=" + given +
      ", ratio=" + ratio +
      ", status=" + status +
      ", assigned=" + assigned +
      ", objectiveID=" + objectiveID +
      '}';
  }
}

