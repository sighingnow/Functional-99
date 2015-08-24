/*
 * Author: He Tao, BUAA
 * Date: 2015-08-24
 *
 * P19 (**) Rotate a list N places to the left.
 * Examples:
 *    scala> rotate(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
 *    res0: List[Symbol] = List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k, 'a, 'b, 'c)
 *    scala> rotate(-2, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
 *    res1: List[Symbol] = List('j, 'k, 'a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i)
 */
 
object P19 {
  def rotate(n: Int, xs: List[Symbol]): List[Symbol] = {
    val cnt = if(n > 0) n else xs.length + n
    xs.drop(cnt) ::: xs.take(cnt)
  }                                               //> rotate: (n: Int, xs: List[Symbol])List[Symbol]
  
  def test() = {
    rotate(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
    rotate(-2, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
  }                                               //> test: ()List[Symbol]

  test()                                          //> res0: List[Symbol] = List('j, 'k, 'a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i)

}