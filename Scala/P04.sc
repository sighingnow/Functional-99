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
  def length(xs: List[Int]): Int = xs match {
    case Nil => 0
    case _ => 1 + length(xs.tail)
  }                                               //> length: (xs: List[Int])Int

  def test() = {
    length(List(1, 1, 2, 3, 5, 8))
  }                                               //> test: ()Int

  test()                                          //> res0: Int = 6

}