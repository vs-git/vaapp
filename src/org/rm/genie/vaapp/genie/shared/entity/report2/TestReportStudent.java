package org.rm.genie.vaapp.genie.shared.entity.report2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TestReportStudent implements Serializable
{
  private String firstName;
  private String lastName;
  private long studentID;
  private List<TestReportCell> cells = new ArrayList<TestReportCell>();
  private long cmgAsnmtID;
  private long testAsnmtID;
  private long testPrepAsnmID;
  private List<TestPrepAssignment> amts = new ArrayList<>();

  public String getFirstName()
  {
    return firstName;
  }

  public void setFirstName(String firstName)
  {
    this.firstName = firstName;
  }

  public String getLastName()
  {
    return lastName;
  }

  public void setLastName(String lastName)
  {
    this.lastName = lastName;
  }

  public long getStudentID()
  {
    return studentID;
  }

  public void setStudentID(long studentID)
  {
    this.studentID = studentID;
  }

  public List<TestReportCell> getCells()
  {
    return cells;
  }

  public void setCells(List<TestReportCell> cells)
  {
    this.cells = cells;
  }

  public long getCmgAsnmtID()
  {
    return cmgAsnmtID;
  }

  public void setCmgAsnmtID(long cmgAsnmtID)
  {
    this.cmgAsnmtID = cmgAsnmtID;
  }

  public long getTestAsnmtID()
  {
    return testAsnmtID;
  }

  public void setTestAsnmtID(long testAsnmtID)
  {
    this.testAsnmtID = testAsnmtID;
  }

  public long getTestPrepAsnmID()
  {
    return testPrepAsnmID;
  }

  public void setTestPrepAsnmID(long testPrepAsnmID)
  {
    this.testPrepAsnmID = testPrepAsnmID;
  }

  public List<TestPrepAssignment> getAmts()
  {
    return amts;
  }

  public void setAmts(List<TestPrepAssignment> amts)
  {
    this.amts = amts;
  }

  @Override
  public String toString()
  {
    return "s{" +
      "firstName='" + firstName + '\'' +
      ", lastName='" + lastName + '\'' +
      ", studentID=" + studentID +
      ", cells=" + cells +
      '}';
  }
}

