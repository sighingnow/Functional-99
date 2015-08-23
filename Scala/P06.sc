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
  def isPalindrome(l: List[Int]): Boolean = l match {
    case Nil => true
    case a :: Nil => true
    case _ => l.head == l.last && isPalindrome(l.drop(1).dropRight(1))
  }
  isPalindrome(List(1, 1, 2, 3, 5, 8))
  isPalindrome(List(1, 2, 3, 2, 1))
  isPalindrome(List(1, 2, 2, 1))
  isPalindrome(List(1))
  isPalindrome(List())
}
