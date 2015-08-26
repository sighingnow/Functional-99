/*
 * Author: He Tao, BUAA
 * Date: 2015-08-25
 *
 * P22 (*) Create a list containing all integers within a given range.
 * Example:
 *    scala> range(4, 9)
 *    res0: List[Int] = List(4, 5, 6, 7, 8, 9)
 */
 
object P22 {
  def range(m: Int, n: Int): List[Int] = (m to n).toList
                                                  //> range: (m: Int, n: Int)List[Int]
  
  def test() = {
    range(4, 9)
  }                                               //> test: ()List[Int]


  test()                                          //> res0: List[Int] = List(4, 5, 6, 7, 8, 9)



}