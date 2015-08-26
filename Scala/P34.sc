/*
 * Author: He Tao, BUAA
 * Date: 2015-08-25
 *
 * P34 (**) Calculate Euler's totient function phi(m).
 * Euler's socalled
 * totient function phi(m) is defined as the number of positive integers r (1 <= r <= m) that are coprime to m.
 *    scala> totient(10)
 *    res0: Int = 4
 */

import scala.math.abs;

object P34 {
  def totient(n: Int): Int = {
    def isCoprimeTo(a: Int, b: Int): Boolean = {
      def gcd(a: Int, b: Int): Int = {
        if (a % b == 0) abs(b)
        else gcd(b, a % b)
      }
      gcd(a, b) == 1
    }
    (1 to n).filter { a => isCoprimeTo(a, n) }.length
  }                                               //> totient: (n: Int)Int
  def test() = {
    totient(10)
  }                                               //> test: ()Int

  test()                                          //> res0: Int = 4
}