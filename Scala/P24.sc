/*
 * Author: He Tao, BUAA
 * Date: 2015-08-25
 *
 * P24 (*) Lotto: Draw N different random numbers from the set 1..M.
 * Example:
 *    scala> lotto(6, 49)
 *    res0: List[Int] = List(23, 1, 17, 33, 21, 37)
 */

import scala.util.Random
 
object P24 {
  def lotto(k: Int, n: Int): List[Int] = (1 to k).map(_ => new Random().nextInt(n)).toList
                                                  //> lotto: (k: Int, n: Int)List[Int]
  
  def test() = {
    lotto(6, 49)
  }                                               //> test: ()List[Int]


  test()                                          //> res0: List[Int] = List(1, 2, 29, 18, 45, 19)
}