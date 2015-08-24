/*
 * Author: He Tao, BUAA
 * Date: 2015-08-24
 *
 * P18 (**) Extract a slice from a list.
 * Given two indices, I and K, the slice is the list containing the elements from
 * and including the Ith element up to but not including the Kth element of the
 * original list. Start counting the elements with 0.
 * Example:
 *    scala> slice(3, 7, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
 *    res0: List[Symbol] = List('d, 'e, 'f, 'g)
 */
 
object P18 {
  def slice(i: Int, k: Int, xs: List[Symbol]): List[Symbol] = {
    xs.slice(i, k)
  }                                               //> slice: (i: Int, k: Int, xs: List[Symbol])List[Symbol]
  
  def test() = {
    slice(3, 7, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
  }                                               //> test: ()List[Symbol]

  test()                                          //> res0: List[Symbol] = List('d, 'e, 'f, 'g)

}