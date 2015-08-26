/*
 * Author: He Tao, BUAA
 * Date: 2015-08-25
 *
 * P33 (*) Determine whether two positive integer numbers are coprime.
 * Two numbers are coprime if their greatest common divisor equals 1.
 *    scala> isCoprimeTo(35, 64)
 *    res0: Boolean = true
 */

import scala.math.abs;

object P33 {
  def isCoprimeTo(a: Int, b: Int): Boolean = {
    def gcd(a: Int, b: Int): Int = {
      if (a % b == 0) abs(b)
      else gcd(b, a % b)
    }
    gcd(a, b) == 1
  }                                               //> isCoprimeTo: (a: Int, b: Int)Boolean
  def test() = {
    isCoprimeTo(35, 64)
  }                                               //> test: ()Boolean

  test()                                          //> res0: Boolean = true
}