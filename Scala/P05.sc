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
  def reverse(xs: List[Int]): List[Int] = xs match {
    case Nil => Nil
    case head :: rest => reverse(rest) :+ head
  }                                               //> reverse: (xs: List[Int])List[Int]

  def test() = {
    reverse(List(1, 1, 2, 3, 5, 8))
  }                                               //> test: ()List[Int]

  test()                                          //> res0: List[Int] = List(8, 5, 3, 2, 1, 1)

}