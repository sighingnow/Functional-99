/*
 * Author: He Tao, BUAA
 * Date: 2015-08-25
 *
 * P41 (**) A list of Goldbach compositions.
 * Given a range of integers by its lower and upper limit, print a list of all even numbers and their Goldbach composition.
 *    scala> printGoldbachList(9 to 20)
 *    10 = 3 + 7
 *    12 = 5 + 7
 *    14 = 3 + 11
 *    16 = 3 + 13
 *    18 = 5 + 13
 *    20 = 3 + 17
 * In most cases, if an even number is written as the sum of two prime numbers, one of them is very small. Very rarely, the primes are both bigger than, say, 50.
 * Try to find out how many such cases there are in the range 2..3000.
 * Example (minimum value of 50 for the primes):
 *    scala> printGoldbachListLimited(1 to 2000, 50)
 *    992 = 73 + 919
 *    1382 = 61 + 1321
 *    1856 = 67 + 1789
 *    1928 = 61 + 1867
 * The file containing the full class for this section is arithmetic.scala.
 */

import scala.math.sqrt

object P41 {

  def goldbach(n: Int): List[(Int, Int)] = {
    def isPrime(n: Int): Boolean = {
      (2 to sqrt(n).toInt).filter { a => n % a == 0 }.isEmpty
    }
    (2 to n/2).toStream.filter(a => isPrime(a) && isPrime(n-a)).map(k => (k, n-k)).toList
  }                                               //> goldbach: (n: Int)List[(Int, Int)]

  def printGoldbachList(r: Range.Inclusive): List[(Int, Int)] = {
    r.filter(_%2==0).map(a => goldbach(a).head).toList
  }                                               //> printGoldbachList: (r: Range.Inclusive)List[(Int, Int)]

  def printGoldbachListLimited(r: Range.Inclusive, limit: Int): List[(Int, Int)] = {
    r.filter(_%2==0).map(goldbach).map(_.filter(k => k._1 >= limit)).filter(!_.isEmpty).map(_.head).toList
  }                                               //> printGoldbachListLimited: (r: Range.Inclusive, limit: Int)List[(Int, Int)]
                                                  //| 

  def test() = {
    printGoldbachList(9 to 20)
    // printGoldbachListLimited(1 to 2000, 50)
  }                                               //> test: ()List[(Int, Int)]

  test()                                          //> res0: List[(Int, Int)] = List((3,7), (5,7), (3,11), (3,13), (5,13), (3,17))
                                                  //| 
}