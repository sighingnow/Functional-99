/*
 * Author: He Tao, BUAA
 * Date: 2015-08-24
 *
 * P15 (**) Duplicate the elements of a list a given number of times.
 * Example:
 *    scala> duplicateN(3, List('a, 'b, 'c, 'c, 'd))
 *    res0: List[Symbol] = List('a, 'a, 'a, 'b, 'b, 'b, 'c, 'c, 'c, 'c, 'c, 'c, 'd, 'd, 'd)
 */
 
object P15 {
  def duplicateN(n: Int, xs: List[Symbol]): List[Symbol] = {
    def repeat(s: Symbol, n: Int): List[Symbol] = n match {
      case 1 => List(s)
      case n => s :: repeat(s, n-1)
    }
    xs.flatMap(a => repeat(a, n))
  }                                               //> duplicateN: (n: Int, xs: List[Symbol])List[Symbol]
  
  def test() = {
    duplicateN(3, List('a, 'b, 'c, 'c, 'd))
  }                                               //> test: ()List[Symbol]

  test()                                          //> res0: List[Symbol] = List('a, 'a, 'a, 'b, 'b, 'b, 'c, 'c, 'c, 'c, 'c, 'c, 'd
                                                  //| , 'd, 'd)

}