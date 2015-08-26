/*
 * Author: He Tao, BUAA
 * Date: 2015-08-25
 *
 * P36 (**) Determine the prime factors of a given positive integer (2).
 * Construct a list containing the prime factors and their multiplicity.
 *    scala> primeFactorMultiplicity(315)
 *    res0: List[(Int, Int)] = List((3,2), (5,1), (7,1))
 * Alternately, use a Map for the result.
 *    scala> primeFactorMultiplicity(315)
 *    res0: Map[Int,Int] = Map(3 ‐> 2, 5 ‐> 1, 7 ‐> 1)
 */

import scala.math.abs;

object P36 {

  def primeFactorMultiplicity(n: Int): Map[Int, Int] = {
    def primeFactors(n: Int): List[Int] = n match {
      case 1 => List()
      case n => {
        val k = (2 to n).toStream.filter(a => n % a == 0).head
        k :: primeFactors(n / k)
      }
    }

    primeFactors(n).groupBy { x => x }.map(a => (a._1, a._2.length))
  }                                               //> primeFactorMultiplicity: (n: Int)Map[Int,Int]
  def test() = {
    primeFactorMultiplicity(315)
  }                                               //> test: ()Map[Int,Int]

  test()                                          //> res0: Map[Int,Int] = Map(5 -> 1, 7 -> 1, 3 -> 2)
}