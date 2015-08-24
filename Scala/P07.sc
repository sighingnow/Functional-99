/**
 * Author: He Tao, BUAA
 * Date: 2015-08-23
 *
 * P07 (**) Flatten a nested list structure.
 * Example:
 *    scala> flatten(List(List(1, 1), 2, List(3, List(5, 8))))
 *    res0: List[Any] = List(1, 1, 2, 3, 5, 8)
 */

object P07 {
  def flatten(xs: List[Any]): List[Any] = xs match {
    case Nil => Nil
    case (a: Int) :: (rest: List[Any]) => a :: flatten(rest)
    case (a: List[Any]) :: (rest: List[Any]) => flatten(a) ::: flatten(rest)
  }                                               //> flatten: (xs: List[Any])List[Any]
  
  def test() = {
    flatten(List(List(1, 1), 2, List(3, List(5, 8))))
  }                                               //> test: ()List[Any]

  test()                                          //> res0: List[Any] = List(1, 1, 2, 3, 5, 8)

}