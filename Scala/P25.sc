/*
 * Author: He Tao, BUAA
 * Date: 2015-08-25
 *
 * P25 (*) Generate a random permutation of the elements of a list.
 * Hint: Use the solution of problem P23.
 * Example:
 *    scala> randomPermute(List('a, 'b, 'c, 'd, 'e, 'f))
 *    res0: List[Symbol] = List('b, 'a, 'd, 'c, 'e, 'f)
 */

import scala.util.Random
 
object P25 {
  def randomPermute(xs: List[Symbol]): List[Symbol] = {
    val n = new Random().nextInt(xs.length)
    List(xs(n)) ::: xs.take(n) ::: xs.drop(n+1)
  }                                               //> randomPermute: (xs: List[Symbol])List[Symbol]
  
  def test() = {
    randomPermute(List('a, 'b, 'c, 'd, 'e, 'f))
  }                                               //> test: ()List[Symbol]


  test()                                          //> res0: List[Symbol] = List('e, 'a, 'b, 'c, 'd, 'f)
}