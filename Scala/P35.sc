/*
 * Author: He Tao, BUAA
 * Date: 2015-08-25
 *
 * P35 (**) Determine the prime factors of a given positive integer.
 * Construct a flat list containing the prime factors in ascending order.
 *    scala> primeFactors(315)
 *    res0: List[Int] = List(3, 3, 5, 7)
 */

import scala.math.abs;

object P35 {
  def primeFactors(n: Int): List[Int] = n match {
    case 1 => List()
    case n => {
      val k = (2 to n).toStream.filter(a => n % a == 0).head
      k :: primeFactors(n / k)
    }
  }                                               //> primeFactors: (n: Int)List[Int]
  def test() = {
    primeFactors(315)
  }                                               //> test: ()List[Int]

  test()                                          //> res0: List[Int] = List(3, 3, 5, 7)
}