package org.rm.genie.vaapp.genie.shared.entity.report2;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import org.rm.genie.vaapp.genie.shared.entity.RMDate;

import java.io.Serializable;

/**
 * Date: 10/8/13
 * Time: 4:10 PM
 *
 * @author etseytlin
 */
public class TestPrepReportRequest implements Serializable
{
  private long classID = 30442;
  private RMDate startDate;// = new RMDate(2015, 9, 20, 0, 0); //2015-09-20
  private RMDate endDate;// = new RMDate(2015, 12, 20, 0, 0); //2015-12-20
  private int grade = 4;
  private int material = 0;
  private boolean isPrint = false;
  private int localSortColumn = 0;
  private boolean localSortAsc = false;
  private int lastNDays = 0;
  private int lastSolvedProblemsNumber;

  public long getClassID()
  {
    return classID;
  }

  public void setClassID(long classID)
  {
    this.classID = classID;
  }

  public RMDate getStartDate()
  {
    return startDate;
  }

  public void setStartDate(RMDate startDate)
  {
    this.startDate = startDate;
  }

  public RMDate getEndDate()
  {
    return endDate;
  }

  public void setEndDate(RMDate endDate)
  {
    this.endDate = endDate;
  }

  public int getGrade()
  {
    return grade;
  }

  public void setGrade(int grade)
  {
    this.grade = grade;
  }

  public int getMaterial()
  {
    return material;
  }

  public void setMaterial(int material)
  {
    this.material = material;
  }

  @JsonGetter("isPrint")
  public boolean isPrint()
  {
    return isPrint;
  }

  @JsonSetter("isPrint")
  public void setPrint(boolean print)
  {
    isPrint = print;
  }

  public int getLocalSortColumn()
  {
    return localSortColumn;
  }

  public void setLocalSortColumn(int localSortColumn)
  {
    this.localSortColumn = localSortColumn;
  }

  public boolean isLocalSortAsc()
  {
    return localSortAsc;
  }

  public void setLocalSortAsc(boolean localSortAsc)
  {
    this.localSortAsc = localSortAsc;
  }

  public int getLastNDays()
  {
    return lastNDays;
  }

  public void setLastNDays(int lastNDays)
  {
    this.lastNDays = lastNDays;
  }

  public int getLastSolvedProblemsNumber()
  {
    return lastSolvedProblemsNumber;
  }

  public void setLastSolvedProblemsNumber(int lastSolvedProblemsNumber)
  {
    this.lastSolvedProblemsNumber = lastSolvedProblemsNumber;
  }

  @Override
  public String toString()
  {
    return "TestPrepReportRequest{" +
      "classID=" + classID +
      ", startDate=" + startDate +
      ", endDate=" + endDate +
      ", grade=" + grade +
      ", material=" + material +
      ", isPrint=" + isPrint +
      ", localSortColumn=" + localSortColumn +
      ", localSortAsc=" + localSortAsc +
      ", lastNDays=" + lastNDays +
      ", lastSolvedProblemsNumber=" + lastSolvedProblemsNumber +
      '}';
  }
}
