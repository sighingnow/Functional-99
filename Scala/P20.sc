/*
 * Author: He Tao, BUAA
 * Date: 2015-08-24
 *
 * P20 (*) Remove the Kth element from a list.
 * Return the list and the removed element in a Tuple. Elements are numbered from 0.
 * Example:
 *    scala> removeAt(1, List('a, 'b, 'c, 'd))
 *    res0: (List[Symbol], Symbol) = (List('a, 'c, 'd),'b)
 */
 
object P20 {
  def removeAt(k: Int, xs: List[Symbol]): (List[Symbol], Symbol) = {
    (xs.take(k) ::: xs.drop(k+1), xs(k))
  }                                               //> removeAt: (k: Int, xs: List[Symbol])(List[Symbol], Symbol)
  
  def test() = {
    removeAt(1, List('a, 'b, 'c, 'd))
  }                                               //> test: ()(List[Symbol], Symbol)

  test()                                          //> res0: (List[Symbol], Symbol) = (List('a, 'c, 'd),'b)

}