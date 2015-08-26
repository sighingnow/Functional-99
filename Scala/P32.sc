/*
 * Author: He Tao, BUAA
 * Date: 2015-08-25
 *
 * P32 (**) Determine the greatest common divisor of two positive integer numbers.
 * Use Euclid's algorithm.
 *    scala> gcd(36, 63)
 *    res0: Int = 9
 */

import scala.math.abs;
 
object P32 {
  def gcd(a: Int, b: Int): Int = {
    if(a % b == 0) abs(b)
    else gcd(b, a%b)
  }                                               //> gcd: (a: Int, b: Int)Int
  def test() = {
    gcd(36, 63)
  }                                               //> test: ()Int


  test()                                          //> res0: Int = 9
}