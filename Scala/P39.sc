/*
 * Author: He Tao, BUAA
 * Date: 2015-08-25
 *
 * P39 (*) A list of prime numbers.
 * Given a range of integers by its lower and upper limit, construct a list of all prime numbers in that range.
 *    scala> listPrimesinRange(7 to 31)
 *    res0: List[Int] = List(7, 11, 13, 17, 19, 23, 29, 31)
 */

import scala.math.sqrt

object P39 {

  def listPrimesinRange(r: Range.Inclusive): List[Int] = {
    def isPrime(n: Int): Boolean = {
      (2 to sqrt(n).toInt).filter {n % _ == 0 }.isEmpty
    }
    r.toList.filter(isPrime)
  }                                               //> listPrimesinRange: (r: Range.Inclusive)List[Int]

  def test() = {
    listPrimesinRange(7 to 31)
  }                                               //> test: ()List[Int]

  test()                                          //> res0: List[Int] = List(7, 11, 13, 17, 19, 23, 29, 31)
}