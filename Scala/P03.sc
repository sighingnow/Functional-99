/**
 * Author: He Tao, BUAA
 * Date: 2015-07-31
 *
 * P03 (*) Find the Kth element of a list.
 * By convention, the first element in the list is element 0.
 * Example:
 *    scala> nth(2, List(1, 1, 2, 3, 5, 8))
 *    res0: Int = 2
 */

object P03 {
  def nth(idx: Int, xs: List[Int]): Int = xs(idx) //> nth: (idx: Int, xs: List[Int])Int

  def test() = {
    nth(2, List(1, 1, 2, 3, 5, 8))
  }                                               //> test: ()Int

  test()                                          //> res0: Int = 2

}