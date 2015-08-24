/*
 * Author: He Tao, BUAA
 * Date: 2015-08-24
 *
 * P14 (*) Duplicate the elements of a list.
 * Example:
 *    scala> duplicate(List('a, 'b, 'c, 'c, 'd))
 *    res0: List[Symbol] = List('a, 'a, 'b, 'b, 'c, 'c, 'c, 'c, 'd, 'd)
 */
 
object P14 {
  def duplicate(xs: List[Symbol]): List[Symbol] = {
    xs.flatMap(a => List(a, a))
  }                                               //> duplicate: (xs: List[Symbol])List[Symbol]
  
  def test() = {
    duplicate(List('a, 'b, 'c, 'c, 'd))
  }                                               //> test: ()List[Symbol]

  test()                                          //> res0: List[Symbol] = List('a, 'a, 'b, 'b, 'c, 'c, 'c, 'c, 'd, 'd)

}