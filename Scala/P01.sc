/**
 * Author: He Tao, BUAA
 * Date: 2015-07-31
 *
 * P01 (*) Find the last element of a list.
 * Example:
 *    scala> last(List(1, 1, 2, 3, 5, 8))
 *    res0: Int = 8
 */

object P01 {
  def last(l: List[Int]): Int = l match {
    case Nil => throw new NoSuchElementException("no last element.")
    case head :: Nil => head
    case head :: rest => last(rest)
  }

  last(List(1, 1, 2, 3, 5, 8))
  last(List())
}

