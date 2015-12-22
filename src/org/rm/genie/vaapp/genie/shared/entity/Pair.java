package org.rm.genie.vaapp.genie.shared.entity;

import java.io.Serializable;

/**
 * Class is designed to keep pair of values
 *
 * @author teb
 */
public class Pair<L, R> implements Serializable
{

  private L left;
  private R right;

  public Pair(){}

  public R getRight()
  {
    return right;
  }

  public L getLeft()
  {
    return left;
  }

  public void setLeft(L left)
  {
    this.left = left;
  }

  public void setRight(R right)
  {
    this.right = right;
  }

  public Pair(L left, R right)
  {
    this.left = left;
    this.right = right;
  }

  /**
   * Create an instance of Pair
   * @param left left value
   * @param right right value
   * @return instance of class Pair
   */
  public static <A, B> Pair<A, B> create(A left, B right)
  {
    return new Pair<A, B>(left, right);
  }

  public final boolean equals(Object o)
  {
    if (!(o instanceof Pair))
    {
      return false;
    }

    final Pair<?, ?> other = (Pair) o;
    return equal(getLeft(), other.getLeft()) && equal(getRight(), other.getRight());
  }

  private boolean equal(Object o1, Object o2)
  {
    if (o1 == null)
    {
      return o2 == null;
    }
    return o1.equals(o2);
  }

  @Override
  public String toString()
  {
    return "Pair{" +
      "left=" + left +
      ", right=" + right +
      '}';
  }
}
