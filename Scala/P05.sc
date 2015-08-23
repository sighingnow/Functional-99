/**
 * Author: He Tao, BUAA
 * Date: 2015-07-31
 *
 * P05 (*) Reverse a list.
 * Example:
 *    scala> reverse(List(1, 1, 2, 3, 5, 8))
 *    res0: List[Int] = List(8, 5, 3, 2, 1, 1)
 */

object P05 {
  def reverse(l: List[Int]): List[Int] = l match {
    case Nil => Nil
    case head :: rest => reverse(rest) :+ head
  }

  reverse(List(1, 1, 2, 3, 5, 8))
  reverse(List(1))
  reverse(List())
}
