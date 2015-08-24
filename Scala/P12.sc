/*
 * Author: He Tao, BUAA
 * Date: 2015-08-24
 *
 * P12 (**) Decode a run-length encoded list.
 * Given a run-length code list generated as specified in problem P10, construct its uncompressed version.
 * Example:
 *    scala> decode(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e)))
 *    res0: List[Symbol] = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
 */
 
object P12 {
  def decode(xs: List[(Int, Symbol)]): List[Symbol] = {
    def repeat(s: Symbol, n: Int): List[Symbol] = n match {
      case 1 => List(s)
      case n => s :: repeat(s, n-1)
    }
    xs.flatMap(item => repeat(item._2, item._1))
  }                                               //> decode: (xs: List[(Int, Symbol)])List[Symbol]
  
  def test() = {
    decode(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e)))
  }                                               //> test: ()List[Symbol]

  test()                                          //> res0: List[Symbol] = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e
                                                  //| , 'e)

}