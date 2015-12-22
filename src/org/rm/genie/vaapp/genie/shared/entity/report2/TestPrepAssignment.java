package org.rm.genie.vaapp.genie.shared.entity.report2;

import java.io.Serializable;

public class TestPrepAssignment implements Serializable
{
  private short assignmentType;
  private long assignmentID;
  private short remainedLessons; //only for smarter solving lessons assignment type: CurriculumTypes.SBRC

  public short getAssignmentType()
  {
    return assignmentType;
  }

  public void setAssignmentType(short assignmentType)
  {
    this.assignmentType = assignmentType;
  }

  public long getAssignmentID()
  {
    return assignmentID;
  }

  public void setAssignmentID(long assignmentID)
  {
    this.assignmentID = assignmentID;
  }

  public short getRemainedLessons()
  {
    return remainedLessons;
  }

  public void setRemainedLessons(short remainedLessons)
  {
    this.remainedLessons = remainedLessons;
  }
}

