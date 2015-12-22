package org.rm.genie.vaapp.genie.shared.constant;

/**
 * Constants for Role.
 *
 * @author genie
 */
public class Roles
{
  /**
   * Role: Student
   */
  public static final int STUDENT = 1;
  /**
   * Role: Tutor
   */
  public static final int TUTOR = 2;
  /**
   * Role: Teacher
   */
  public static final int TEACHER = 3;
  /**
   * Role: Genie
   */
  public static final int GENIE = 4;
  /**
   * Role: Parent
   */
  public static final int PARENT = 5;
  /**
   * Role: System Administrator
   */
  public static final int SYSTEM_ADMIN = 6;
  /**
   * Role: Educational Administrator
   */
  public static final int EDUCATIONAL_ADMIN = 7;
  /**
   * Role: Content Administrator
   */
  public static final int CONTENT_ADMIN = 8;
  /**
   * Role: RM Administrator
   */
  public static final int RM_ADMIN = 9;
  /**
   * Role: Account Administrator
   */
  public static final int ACCOUNT_ADMIN = 10;
  /**
   * Role: Test Student
   */
  public static final int TEST_STUDENT = 11;
  /**
   * Role: Test Tutor
   */
  public static final int TEST_TUTOR = 12;
  /**
   * Role: Test Teacher
   */
  public static final int TEST_TEACHER = 13;
  /**
   * Role: Developer
   */
  public static final int DEVELOPER = 99;

  private Roles()
  {
  }

  public static boolean isAdult(int roleID)
  {
    return ! isStudent(roleID);
  }


  public static boolean isStudent(int roleID)
  {
    return roleID == STUDENT || roleID == TEST_STUDENT;
  }
}

