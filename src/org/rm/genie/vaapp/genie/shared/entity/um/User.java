package org.rm.genie.vaapp.genie.shared.entity.um;

//import org.rm.genie.shared.LoggerFactory;
//import org.rm.genie.shared.constant.Roles;

import org.rm.genie.vaapp.genie.shared.constant.Roles;

import java.io.Serializable;
import java.lang.reflect.Field;

/**
 * Class represents User entity (hand code addition).
 */
public class User implements Serializable, Cloneable
{
  public final static int STANDARD = 0;
  public final static int EXPERIMENTAL = 1;
  public final static int BOTH = 2;

  public final static String G3_NO_NAME = "No name";

  protected long userID;
  protected String loginName;
  protected String md5hash;
  protected String firstName;
  protected String middleInitial;
  protected String lastName;
  protected String nickName;
  protected String prefix;
  protected String description;
  protected int roleId;
  protected boolean active = false;
  protected String timeZone = "America/Chicago";
  protected boolean isGuest = false;
  protected int system = STANDARD;
  private boolean staar = false;
  private boolean sbrc = false;
  private byte testContentCatalog = 0; //0 -nothing, 1 - staar, 2 - sbrc, 3 - both
  protected String idNumber;
  protected boolean debug;
  protected String email;
  protected boolean isDemo;
  //protected boolean disabled; check whether the user is disabled via field "active", see UMController.getUserBy(...)

  private boolean isRealClassesAccessiblele = false;
  private boolean sse = true;
  private boolean isIndividual = false;

  public User()
  {
  }

  public boolean equals(Object obj)
  {
    if (obj == this)
    {
      return true;
    }
    else if (!(obj instanceof User))
    {
      return false;
    }
    User data = (User) obj;
    return (userID == data.userID);
  }

  /**
   * Gets User ID
   *
   * @return User ID
   */
  public long getUserID()
  {
    return userID;
  }

  /**
   * Sets User ID
   *
   * @param userID User ID
   */
  public void setUserID(long userID)
  {
    this.userID = userID;
  }

  /**
   * Gets Login Name
   *
   * @return Login Name
   */
  public String getLoginName()
  {
    return loginName;
  }

  /**
   * Sets Login Name
   *
   * @param loginName Login Name
   */
  public void setLoginName(String loginName)
  {
    this.loginName = loginName;
  }

  /**
   * Gets First Name
   *
   * @return First Name
   */
  public String getFirstName()
  {
    return firstName;
  }

  /**
   * Sets First Name
   *
   * @param firstName First Name
   */
  public void setFirstName(String firstName)
  {
    this.firstName = firstName;
    if (firstName == null)
    {
      this.firstName = "";
    }
  }

  /**
   * Gets Middle Initial
   *
   * @return Middle Initial
   */
  public String getMiddleInitial()
  {
    return middleInitial;
  }

  /**
   * Sets Middle Initial
   *
   * @param middleInitial Middle Initial
   */
  public void setMiddleInitial(String middleInitial)
  {
    this.middleInitial = middleInitial;
    if (middleInitial == null)
    {
      this.middleInitial = "";
    }
  }

  /**
   * Gets Last Name
   *
   * @return Last Name
   */
  public String getLastName()
  {
    return lastName;
  }

  /**
   * Sets Last Name
   *
   * @param lastName Last Name
   */
  public void setLastName(String lastName)
  {
    this.lastName = lastName;
    if (lastName == null)
    {
      this.lastName = "";
    }
  }

  /**
   * Gets Nickname
   *
   * @return Nickname
   */
  public String getNickName()
  {
    return nickName;
  }

  /**
   * Sets Nickname
   *
   * @param nickName Nickname
   */
  public void setNickName(String nickName)
  {
    this.nickName = nickName;
  }

  /**
   * Gets Prefix
   *
   * @return Prefix
   */
  public String getPrefix()
  {
    return prefix;
  }

  /**
   * Sets Prefix
   *
   * @param prefix Prefix
   */
  public void setPrefix(String prefix)
  {
    this.prefix = prefix;
    if (prefix == null)
    {
      this.prefix = "";
    }
  }

  public String getDescription()
  {
    return description;
  }

  public void setDescription(String description)
  {
    this.description = description;
    if (description == null)
    {
      this.description = "";
    }
  }

  public int getRoleId()
  {
    return roleId;
  }

  public void setRoleId(int roleId)
  {
    this.roleId = roleId;
  }

  /**
   * Gets full name
   *
   * @return name
   */
  public String getFullName()
  {
    StringBuilder s = new StringBuilder();
    if (roleId != Roles.STUDENT && prefix != null)
    {
      s.append(prefix);
    }
    if (firstName != null)
    {
      if (s.length() > 0)
      {
        s.append(" ");
      }
      s.append(firstName);
    }
    if (middleInitial != null)
    {
      if (s.length() > 0)
      {
        s.append(" ");
      }
      s.append(middleInitial);
    }
    if (lastName != null)
    {
      if (s.length() > 0)
      {
        s.append(" ");
      }
      s.append(lastName);
    }
    return s.toString();
  }

  public String getScreenName()
  {
    return nickName + "_" + Long.toString(userID);
  }

  public static String showScreenName(String nickName, long userID)
  {
    return nickName + "_" + userID;
  }

  public boolean isActive()
  {
    return active;
  }

  public void setActive(boolean active)
  {
    this.active = active;
  }

  public String getMd5hash()
  {
    return md5hash;
  }

  public void setMd5hash(String md5hash)
  {
    this.md5hash = md5hash;
  }

  public String getTimeZone()
  {
    return timeZone;
  }

  public void setTimeZone(String timeZone)
  {
    this.timeZone = timeZone;
    if (timeZone == null)
    {
      this.timeZone = "America/Chicago";
    }
  }

  public boolean isGuest()
  {
    return isGuest;
  }

  public void setGuest(boolean guest)
  {
    isGuest = guest;
  }

  public int getSystem()
  {
    return system;
  }

  public void setSystem(int system)
  {
    this.system = system;
  }

  public void setDebug(boolean debug)
  {
    this.debug = debug;
  }

  public boolean isDebug()
  {
    return debug;
  }

  public String getIdNumber()
  {
    return idNumber;
  }

  public void setIdNumber(String idNumber)
  {
    this.idNumber = idNumber;
  }

  public boolean isStaar()
  {
    return staar;
  }

  public void setStaar(boolean staar)
  {
    this.staar = staar;
  }

  public boolean isSbrc()
  {
    return sbrc;
  }

  public void setSbrc(boolean sbrc)
  {
    this.sbrc = sbrc;
  }

  public boolean isRealClassesAccessible()
  {
    return isRealClassesAccessiblele;
  }

  public void setRealClassesAccessible(boolean isRealClassesAccessible)
  {
    this.isRealClassesAccessiblele = isRealClassesAccessible;
  }

  public byte getTestContentCatalog()
  {
    return testContentCatalog;
  }

  public void setTestContentCatalog(byte testContentCatalog)
  {
    this.testContentCatalog = testContentCatalog;
  }

  public String getEmail()
  {
    return email;
  }

  public void setEmail(String email)
  {
    this.email = email;
  }

  public boolean isDemo()
  {
    return isDemo;
  }

  public void setDemo(boolean isDemo)
  {
    this.isDemo = isDemo;
  }

  public static String compareUsers(User user1, User user2)
  {
    StringBuilder changedFields = new StringBuilder();
    for (Field field : User.class.getDeclaredFields())
    {
      try
      {
        Object val1 = field.get(user1);
        Object val2 = field.get(user2);
        if ((val1 != null && !val1.equals(val2)) || (val1 == null && val2 != null))
          changedFields.append(field.getName()).append("=").append(val1).append(";");
      }
      catch (IllegalAccessException e)
      {
        System.out.println(e);
        //LoggerFactory.getLogger().warn(e);
      }
    }
    return changedFields.toString();
  }

  public boolean isIndividual()
  {
    return isIndividual;
  }

  public void setIndividual(boolean isIndividual)
  {
    this.isIndividual = isIndividual;
  }

  @Override
  public String toString()
  {
    return "User{" +
      "ID=" + userID +
      ", login=" + loginName +
      ", roleId=" + roleId +
      ", md5hash=" + md5hash +
      ", firstName=" + firstName +
      ", middleInitial=" + middleInitial +
      ", lastName=" + lastName +
      ", nickName=" + nickName +
      ", prefix=" + prefix +
      ", description=" + description +
      ", active=" + active +
      ", timeZone=" + timeZone +
      ", isGuest=" + isGuest +
      ", system=" + system +
      ", staar=" + staar +
      ", sbrc=" + sbrc +
      ", testContentCatalog=" + testContentCatalog +
      ", idNumber=" + idNumber +
      ", email=" + email +
      ", debug=" + debug +
      ", access=" + isRealClassesAccessiblele +
      ", demo=" + isDemo +
      ", sse=" + sse +
      ", isIndividual=" + isIndividual +
      '}';
  }

  public boolean isSse()
  {
    return sse;
  }

  public void setSse(boolean sse)
  {
    this.sse = sse;
  }
}

