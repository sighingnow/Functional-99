/*
 * Author: He Tao, BUAA
 * Date: 2015-08-24
 *
 * P17 (*) Split a list into two parts.
 * The length of the first part is given. Use a Tuple for your result.
 * Example:
 *    scala> split(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
 *    res0: (List[Symbol], List[Symbol]) = (List('a, 'b, 'c),List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
 */
 
object P17 {
  def split(n: Int, xs: List[Symbol]): (List[Symbol], List[Symbol]) = {
    (xs.take(n), xs.drop(n))
  }                                               //> split: (n: Int, xs: List[Symbol])(List[Symbol], List[Symbol])
  
  def test() = {
    split(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
  }                                               //> test: ()(List[Symbol], List[Symbol])

  test()                                          //> res0: (List[Symbol], List[Symbol]) = (List('a, 'b, 'c),List('d, 'e, 'f, 'g, 
                                                  //| 'h, 'i, 'j, 'k))

}