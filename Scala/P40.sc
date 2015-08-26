/*
 * Author: He Tao, BUAA
 * Date: 2015-08-25
 *
 * P40 (**) Goldbach's conjecture.
 * Goldbach's conjecture says that every positive even number greater than 2 is the sum of two prime numbers. E.g. 28 = 5 + 23. It is one of the most famous
 * facts in number theory that has not been proved to be correct in the general case. It has been numerically confirmed up to very large numbers (much larger
 * than Scala's Int can represent). Write a function to find the two prime numbers that sum up to a given even integer.
 *    scala> goldbach(28)
 *    res0: (Int, Int) = (5,23)
 */

import scala.math.sqrt

object P40 {

  def goldbach(n: Int): (Int, Int) = {
    def isPrime(n: Int): Boolean = {
      (2 to sqrt(n).toInt).filter { a => n % a == 0 }.isEmpty
    }
    val k = (2 to n).toStream.filter(a => isPrime(a) && isPrime(n-a)).head
    (k, n-k)
  }                                               //> goldbach: (n: Int)(Int, Int)

  def test() = {
    goldbach(28)
  }                                               //> test: ()(Int, Int)

  test()                                          //> res0: (Int, Int) = (5,23)
}