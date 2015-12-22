package org.rm.genie.vaapp.genie.shared.content;

import java.io.Serializable;

public class TPStandard implements Serializable
{
  private long objectiveID;
  private int oindex;
  private String std;
  private int categoryID;
  private String shortDescription;
  private String type;

  public void setObjectiveID(long objectiveID)
  {
    this.objectiveID = objectiveID;
  }

  public void setOindex(int oindex)
  {
    this.oindex = oindex;
  }

  public void setStd(String std)
  {
    this.std = std;
  }


  public void setCategoryID(int categoryID)
  {
    this.categoryID = categoryID;
  }

  public long getObjectiveID()
  {
    return objectiveID;
  }

  public int getOindex()
  {
    return oindex;
  }

  public String getStd()
  {
    return std;
  }

  public int getCategoryID()
  {
    return categoryID;
  }

  public String getShortDescription()
  {
    return shortDescription;
  }

  public void setShortDescription(String shortDescription)
  {
    this.shortDescription = shortDescription;
  }

  public String getType()
  {
    return type;
  }

  public void setType(String type)
  {
    this.type = type;
  }
}
