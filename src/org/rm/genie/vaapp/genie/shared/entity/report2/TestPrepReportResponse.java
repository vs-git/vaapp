package org.rm.genie.vaapp.genie.shared.entity.report2;

import org.rm.genie.vaapp.genie.shared.content.TPStandard;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class TestPrepReportResponse implements Serializable
{
  List<TestReportStudent> students = new ArrayList<TestReportStudent>();
  float[] total = new float[0];
  private long reportID = -1;

  private Map<Integer, String> categories = new LinkedHashMap<Integer, String>();
  private List<TPStandard> tpStandards = new ArrayList<TPStandard>();

  public List<TestReportStudent> getStudents()
  {
    return students;
  }

  public void setStudents(List<TestReportStudent> students)
  {
    this.students = students;
  }

  public float[] getTotal()
  {
    return total;
  }

  public void setTotal(float[] total)
  {
    this.total = total;
  }

  public long getReportID()
  {
    return reportID;
  }

  public void setReportID(long reportID)
  {
    this.reportID = reportID;
  }

  public Map<Integer, String> getCategories()
  {
    return categories;
  }

  public void setCategories(Map<Integer, String> categories)
  {
    this.categories = categories;
  }

  public List<TPStandard> getTpStandards()
  {
    return tpStandards;
  }

  public void setTpStandards(List<TPStandard> tpStandards)
  {
    this.tpStandards = tpStandards;
  }
}
