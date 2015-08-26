/*
 * Author: He Tao, BUAA
 * Date: 2015-08-25
 *
 * P21 (*) Insert an element at a given position into a list.
 * Example:
 *    scala> insertAt('new, 1, List('a, 'b, 'c, 'd))
 *    res0: List[Symbol] = List('a, 'new, 'b, 'c, 'd)
 */
 
object P21 {
  def insertAt(x: Symbol, k: Int, xs: List[Symbol]): List[Symbol] = xs.take(k) ::: List(x) ::: xs.drop(k)
                                                  //> insertAt: (x: Symbol, k: Int, xs: List[Symbol])List[Symbol]
  
  def test() = {
    insertAt('new, 1, List('a, 'b, 'c, 'd))
  }                                               //> test: ()List[Symbol]


  test()                                          //> res0: List[Symbol] = List('a, 'new, 'b, 'c, 'd)



}