/*
 * Author: He Tao, BUAA
 * Date: 2015-08-25
 *
 * P23 (**) Extract a given number of randomly selected elements from a list.
 * Example:
 *    scala> randomSelect(3, List('a, 'b, 'c, 'd, 'f, 'g, 'h))
 *    res0: List[Symbol] = List('e, 'd, 'a)
 */

import scala.util.Random

object P23 {
  def randomSelect(k: Int, xs: List[Symbol]): List[Symbol] = {
    def genIdx(k: Int, n: Int, acc: List[Int]): List[Int] = {
      val x = new Random().nextInt(n)
      if(k == 0) acc
      else if(acc.contains(x)) genIdx(k, n, acc)
      else genIdx(k-1, n, acc :+ x)
    }
    genIdx(k, xs.length, List()).map(a => xs(a)).toList
  }                                               //> randomSelect: (k: Int, xs: List[Symbol])List[Symbol]
  
  def test() = {
    randomSelect(3, List('a, 'b, 'c, 'd, 'f, 'g, 'h))
  }                                               //> test: ()List[Symbol]


  test()                                          //> res0: List[Symbol] = List('f, 'd, 'c)
}