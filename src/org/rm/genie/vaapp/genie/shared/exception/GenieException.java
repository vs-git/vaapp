package org.rm.genie.vaapp.genie.shared.exception;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.HashMap;

public class GenieException extends Exception
{
  public static final int ID_INTERNAL_ERROR = 0;
  public static final int ID_HTTP_SESSION_NOT_CREATED = 11;
  public static final int ID_TRANSACTION_IS_NOT_ACTIVE = 12;

  public static final int ID_NO_CONTENT = 1000;
  public static final int ID_CANT_ASSIGN_SOC_THROUGH_EMPTY_OBJECTIVE = 10002;
  public static final int ID_NO_CONTENT_IN_GS = 1001;
  public static final int ID_CONTENT_BECAME_AVAILABLE = 1002;

  public static final int ID_SF_COMM_ERROR = 2015;

  public static final int ID_BAD_CALENDAR_DATE = 4005;

  public static final int ID_ACTION_CANNOT_BE_LOGGED = 290408;

  public static final int ID_PARENT_EMAIL_DUPLICATE = 4010;

  public static final int ID_CHECKMARK_ITEM_ARCHIVED = 500001;
  public static final int ID_INCORRECT_MODEID = 500002;

  public static final int ID_USER_SESSION_NOT_FOUND = 5003;
  public static final int ID_ANOTHER_LOGIN_DETECTED = 5004;
  public static final int ID_USER_SESSION_INVALIDATED_BY_TEACHER = 5005;
  public static final int ID_INCORRECT_MODE = 5006;
  public static final int ID_USER_IS_ON_ANOTHER_SERVER = 5007;
  public static final int ID_MULTIPLE_TABS_OPENED = 5008;

  public static final int ID_ASSIGNMENT_NOT_FOUND = 8405;

  //  public static final int ID_MAXIMUM_COUNT_SESSION_REACHED = 30000;  // TODO: remove these exceptions after new tutoring stabilized
//  public static final int ID_INVITED_BY_ANOTHER_TUTOR = 30001;
//  public static final int ID_HIGHER_PRIORITY_MODE = 30002;
//  public static final int ID_ALREADY_IN_TUTORING_MODE = 30003;
  public static final int DATASETID_CLONE_NOT_EXIST = 30004;

  public static final int ID_DISTRICT_CANNOT_DELETE_HAS_SCHOOLS = 4702;
  public static final int ID_DISTRICT_CANNOT_DELETE_HAS_DESCENDANTS = 4703;
  public static final int ID_SCHOOL_EXIST_SCHOOLUID = 4346;
  public static final int ID_SCHOOL_CANNOT_DELETE = 4351;
  public static final int ID_USER_EXIST = 4398;
  public static final int ID_USER_EXIST_LOGINNAME = 4400;
  public static final int ID_STUDENTS_IDNUMBER_NON_UNIQUE = 4904;
  public static final int ID_USER_CANNOT_UPDATE = 4404;
  public static final int ID_MENTOR_EXIST_STUDENTID_COURSEID = 4506;
  public static final int ID_SCHOOLCLASS_EXIST = 4583;  // for EJB
  public static final int ID_SCHOOLCLASS_EXIST_SCHOOLID_CLASSUID = 4585;
  public static final int ID_NO_CLASS_CALENDAR = 4004;
  public static final int ID_DISTRICT_PROPERTY_VALUES_CANNOT_INSERT = 4101;
  public static final int ID_DISTRICT_PROPERTY_VALUES_CANNOT_UPDATE = 4102;
  public static final int ID_DISTRICT_PROPERTY_VALUES_CANNOT_DELETE = 4103;
  public static final int ID_CHECKMARK_INTERRUPTED = 9111;
  public static final int ID_CHECKMARK_UNASSIGNED = 9112;
  public static final int ID_NO_ITEMS_IN_MODULE = 9114;

  public static final int ID_G3_NOT_ENOUGH_POINTS = 29400;

  public static final int ID_SBS_ASSIGNMENT_WAS_REASSIGNED = 99100;

  protected int id;
  protected String detail = "";
  protected String message = null;
  protected String userMessage = null;
  protected static final HashMap<Integer, String> mName = new HashMap<>();

  static
  {
    mName.put(ID_INTERNAL_ERROR, "Internal Error");
    mName.put(ID_HTTP_SESSION_NOT_CREATED, "HTTP session is not created");
    mName.put(ID_TRANSACTION_IS_NOT_ACTIVE, "Transaction is not active");
    mName.put(ID_USER_SESSION_NOT_FOUND, "User session is not found");
    mName.put(ID_ANOTHER_LOGIN_DETECTED, "Another login detected");
    mName.put(ID_USER_SESSION_INVALIDATED_BY_TEACHER, "User session has invalidated by teacher");
    mName.put(ID_INCORRECT_MODE, "Incorrect mode");
    mName.put(ID_USER_IS_ON_ANOTHER_SERVER, "User is on another server");
    mName.put(ID_MULTIPLE_TABS_OPENED, "You can not work in multiple tabs");
//    mName.put(ID_MAXIMUM_COUNT_SESSION_REACHED, "The invitation cannot be sent, since the maximum number of simultaneous tutorials that can happen in this class has been reached. Please try again later, or select a student from a different class.");
//    mName.put(ID_INVITED_BY_ANOTHER_TUTOR, "The invitation cannot be sent, since this student has already been reserved for a tutorial by another tutor.  Please try again later, or select a different student.");
//    mName.put(ID_HIGHER_PRIORITY_MODE, "The invitation cannot be sent, since the student is currently working on a higher priority task.  Please try again later, or select a different student.");
//    mName.put(ID_ALREADY_IN_TUTORING_MODE, "The invitation cannot be sent, since the student is currently already in a tutorial (or is working on a post-tutorial quiz).  Please try again later, or select a different student.");
    mName.put(DATASETID_CLONE_NOT_EXIST, "This problem cannot be cloned, since no clones exist.");
    mName.put(ID_DISTRICT_CANNOT_DELETE_HAS_SCHOOLS, "District cannot be deleted. There are schools being assigned to it");
    mName.put(ID_DISTRICT_CANNOT_DELETE_HAS_DESCENDANTS, "Districts cannot be deleted. It has descendants");
    mName.put(ID_SCHOOL_EXIST_SCHOOLUID, "School with same UID already exists");
    mName.put(ID_SCHOOL_CANNOT_DELETE, "School cannot be deleted");
    mName.put(ID_USER_EXIST, "User is duplicated");
    mName.put(ID_USER_EXIST_LOGINNAME, "User is duplicated");
    mName.put(ID_USER_CANNOT_UPDATE, "User cannot be updated");
    mName.put(ID_MENTOR_EXIST_STUDENTID_COURSEID, "Student's Mentor is duplicated");
    mName.put(ID_SCHOOLCLASS_EXIST, "School Class is duplicated");
    mName.put(ID_SCHOOLCLASS_EXIST_SCHOOLID_CLASSUID, "School Class with same UID exists in the system");
    mName.put((ID_NO_CLASS_CALENDAR), "UM: calendar is not assigned to class");
    mName.put(ID_DISTRICT_PROPERTY_VALUES_CANNOT_INSERT, "District property value cannot be inserted. The district property value already exists with same UID");
    mName.put(ID_DISTRICT_PROPERTY_VALUES_CANNOT_UPDATE, "District property value cannot be updated. The district property value already exists with same UID");
    mName.put(ID_DISTRICT_PROPERTY_VALUES_CANNOT_DELETE, "District property value cannot be deleted. There are district properties referred to it");
    mName.put(ID_CHECKMARK_UNASSIGNED, "Checkmark game has been unassigned");
    mName.put(ID_CHECKMARK_INTERRUPTED, "You can finish this later. There's a new activity on your to-do list!");
    mName.put(ID_NO_ITEMS_IN_MODULE, "There are no entries in the module");
    mName.put(ID_G3_NOT_ENOUGH_POINTS, "Student does not have enough points");
    mName.put(ID_SBS_ASSIGNMENT_WAS_REASSIGNED, "Assignment was cancelled or reassigned");
  }

  public GenieException(){}

  /**
   * Constructs a new exception with ID
   *
   * @param id exception ID
   */
  public GenieException(int id)
  {
    this.id = id;
  }

  /**
   * Constructs a new exception with ID and detail description
   *
   * @param id     exception ID
   * @param detail detail description
   */
  public GenieException(int id, String detail)
  {
    this.id = id;
    this.detail = detail;
  }

  public GenieException(int id, String detail, String message)
  {
    this(id, detail);
    this.message = message;
  }

  public GenieException(int id, String detail, String message, String userMessage)
  {
    this(id, detail, message);
    this.userMessage = userMessage;
  }

  /**
   * Constructs a new exception with ID and throwable cause
   *
   * @param id    exception ID
   * @param cause cause of this exception
   */
  public GenieException(int id, Throwable cause)
  {
    super(cause);
    this.message = cause.getMessage();
    if (cause.getMessage() != null && cause.getMessage().toLowerCase().startsWith("transaction is not active"))
      this.id = ID_TRANSACTION_IS_NOT_ACTIVE;
    else
      this.id = id;
  }

  /**
   * Constructs a new exception with ID, detail description and throwable cause
   *
   * @param id     exception ID
   * @param detail detail description
   * @param cause  cause of this exception
   */
  public GenieException(int id, String detail, Throwable cause)
  {
    super(cause);
    this.id = id;
    this.detail = detail;
  }

  public GenieException(int id, String detail, String message, Throwable cause)
  {
    this(id, detail, cause);
    this.id = id;
    if (message != null && message.length() > 0)
      this.message = message;
    else
      this.message = cause.getMessage();
  }

  public GenieException(int id, String detail, String message, String userMessage, Throwable cause)
  {
    this(id, detail, message, cause);
    this.id = id;
    this.userMessage = userMessage;
  }

  /**
   * Returns the exception ID
   *
   * @return exception ID
   */
  public int getID()
  {
    return id;
  }

  public int getId()
  {
    return id;
  }

  public void setId(int id)
  {
    this.id = id;
  }

  public String getUserMessage()
  {
    return userMessage;
  }

  public void setUserMessage(String userMessage)
  {
    this.userMessage = userMessage;
  }

  /**
   * Returns the error message string
   *
   * @return error message
   */
  public String getMessage()
  {
    StringBuilder msg = new StringBuilder();

    if (message != null)
    {
      msg.append(message);
    }
    else
    {
      if (mName.containsKey(id))
        msg.append(mName.get(id)).append( ": ");
      else if (id != -1)
        msg.append("exception id=").append(id).append( ": ");

      if (detail != null && !detail.equals(""))
        msg.append(detail);
    }
    return msg.toString();
  }

  public String getExactMessage()
  {
    return message;
  }

  /**
   * Returns the detail error message string
   *
   * @return detail error message
   */
  public String getDetail()
  {
    return getMessage();
  }

  @Override
  public StackTraceElement[] getStackTrace()
  {
    if (getCause() == null) return super.getStackTrace();
    else return getCause().getStackTrace();
  }

  @Override
  public void printStackTrace()
  {
    if (getCause() == null) super.printStackTrace();
    else getCause().printStackTrace();
  }

  @Override
  public void printStackTrace(PrintStream s)
  {
    if (getCause() == null) super.printStackTrace(s);
    else super.printStackTrace(s);
  }

  @Override
  public void printStackTrace(PrintWriter s)
  {
    if (getCause() == null) super.printStackTrace(s);
    else getCause().printStackTrace(s);
  }

  public static boolean isNormal(Throwable e)
  {
    if (e instanceof GenieException)
    {
      int id = ((GenieException) e).getID();
      return id == GenieException.ID_HTTP_SESSION_NOT_CREATED ||
        id == ID_USER_SESSION_NOT_FOUND ||
        id == ID_ANOTHER_LOGIN_DETECTED ||
        id == ID_USER_IS_ON_ANOTHER_SERVER ||
        id == ID_USER_SESSION_INVALIDATED_BY_TEACHER ||
        id == ID_MULTIPLE_TABS_OPENED ||
        id == ID_NO_CLASS_CALENDAR ||
        id == ID_SCHOOLCLASS_EXIST ||
        id == ID_USER_EXIST ||
        id == ID_USER_EXIST_LOGINNAME;

    }

    return false;
  }
}
