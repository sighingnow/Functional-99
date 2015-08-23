/**
 * Author: He Tao, BUAA
 * Date: 2015-07-31
 *
 * P04 (*) Find the number of elements of a list.
 * Example:
 *    scala> length(List(1, 1, 2, 3, 5, 8))
 *    res0: Int = 6
 */

object P04 {
  def length(l: List[Int]): Int = l match {
    case Nil => 0
    case _ => 1 + length(l.tail)
  }
  length(List(1, 1, 2, 3, 5, 8))
  length(List(1))
  length(List())
}
