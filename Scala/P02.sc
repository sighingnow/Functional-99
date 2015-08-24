/**
 * Author: He Tao, BUAA
 * Date: 2015-07-31
 *
 * P02 (*) Find the last but one element of a list.
 * Example:
 *    scala> penultimate(List(1, 1, 2, 3, 5, 8))
 *    res0: Int = 5
 */

object P02 {
  def penultimate(xs: List[Int]): Int = xs match {
    case f :: p :: Nil => f
    case f :: p :: rest => penultimate(p :: rest)
    case _ => throw new NoSuchElementException("no last but one element.")
  }                                               //> penultimate: (xs: List[Int])Int

  def test() = {
    penultimate(List(1, 1, 2, 3, 5, 8))
  }                                               //> test: ()Int

  test()                                          //> res0: Int = 5

}