/*
 * Author: He Tao, BUAA
 * Date: 2015-08-25
 *
 * P31 (**) Determine whether a given integer number is prime.
 *    scala> isPrime(7)
 *    res0: Boolean = true
 */

import scala.math.sqrt;
 
object P31 {
  def isPrime(n: Int): Boolean = {
    (2 to sqrt(n).toInt).filter{a => n % a == 0}.isEmpty
  }                                               //> isPrime: (n: Int)Boolean
  
  def test() = {
    isPrime(7)
  }                                               //> test: ()Boolean


  test()                                          //> res0: Boolean = true
}