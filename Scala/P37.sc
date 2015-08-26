/*
 * Author: He Tao, BUAA
 * Date: 2015-08-25
 *
 * P37 (**) Calculate Euler's totient function phi(m) (improved).
 * See problem P34 for the definition of Euler's totient function. If the list of the prime factors of a number m is known in the form of problem P36 then the
 * function phi(m>) can be efficiently calculated as follows: Let [[p1, m1], [p2, m2], [p3, m3], ...] be the list of prime factors (and their multiplicities) of a given
 * number m. Then phi(m) can be calculated with the following formula:

    phi(m) = (p1-1)*p1^(m1-1) * (p2-1)*p2^(m2-1) * (p3-1)*p3^(m3-1) * ...
  
 * Note that a^b stands for the bth power of a.
 */

object P37 {
  def phi(n: Int): Int = {

    def primeFactors(n: Int): List[Int] = n match {
      case 1 => List()
      case n => {
        val k = (2 to n).toStream.filter(a => n % a == 0).head
        k :: primeFactors(n / k)
      }
    }
    
    def primeFactorMultiplicity(n: Int): Map[Int, Int] = {
      primeFactors(n).groupBy { x => x }.map(a => (a._1, a._2.length))
    }

    def pow(a: Int, k: Int): Int = {
      (1 to k).map(_ => a).product
    }

    primeFactorMultiplicity(n).map(a => (a._1 - 1) * pow(a._1, a._2 - 1)).product
  }                                               //> phi: (n: Int)Int


  def test() = {
    phi(100)
  }                                               //> test: ()Int

  test()                                          //> res0: Int = 40
}