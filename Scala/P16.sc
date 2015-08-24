/*
 * Author: He Tao, BUAA
 * Date: 2015-08-24
 *
 * P16 (**) Drop every Nth element from a list.
 * Example:
 *    scala> drop(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
 *    res0: List[Symbol] = List('a, 'b, 'd, 'e, 'g, 'h, 'j, 'k)
 */
 
object P16 {
  def drop(n: Int, xs: List[Symbol]): List[Symbol] = {
    xs.zip(Stream.from(1).take(xs.length).toList).filter(a => a._2 % n != 0).map(_._1)
  }                                               //> drop: (n: Int, xs: List[Symbol])List[Symbol]
  
  def test() = {
    drop(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
  }                                               //> test: ()List[Symbol]

  test()                                          //> res0: List[Symbol] = List('a, 'b, 'd, 'e, 'g, 'h, 'j, 'k)

}