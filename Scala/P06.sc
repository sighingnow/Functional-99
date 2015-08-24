/**
 * Author: He Tao, BUAA
 * Date: 2015-07-31
 *
 * P06 (*) Find out whether a list is a palindrome.
 * Example:
 *    scala> isPalindrome(List(1, 2, 3, 2, 1))
 *    res0: Boolean = true
 */

object P06 {
  def isPalindrome(xs: List[Int]): Boolean = xs match {
    case Nil => true
    case a :: Nil => true
    case _ => xs.head == xs.last && isPalindrome(xs.drop(1).dropRight(1))
  }                                               //> isPalindrome: (xs: List[Int])Boolean

  def test() = {
    isPalindrome(List(1, 2, 3, 2, 1))
  }                                               //> test: ()Boolean

  test()                                          //> res0: Boolean = true

}