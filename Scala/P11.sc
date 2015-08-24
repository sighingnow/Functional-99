/*
 * Author: He Tao, BUAA
 * Date: 2015-08-24
 *
 * P11 *) Modified run-length encoding.
 * Modify the result of problem P10 in such a way that if an element has no duplicates
 * it is simply copied into the result list. Only elements with duplicates are
 * transferred as N, E) terms.
 * Example:
 *    scala> encodeModifiedList'a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
 *    res0: List[Any] = List((4,'a), 'b, (2,'c), (2,'a), 'd, (4,'e))
 */
 
object P11 {
  def encodeModified(xs: List[Symbol]): List[Any]  = xs match {
    case Nil => Nil
    case fst :: _ => {
      val sames = xs.takeWhile { a => a == fst }.length
      if(sames == 1) List(fst) ::: encodeModified(xs.drop(sames))
      else List((sames, fst)) ::: encodeModified(xs.drop(sames))
    }
  }                                               //> encodeModified: (xs: List[Symbol])List[Any]
  
  def test() = {
    encodeModified(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
  }                                               //> test: ()List[Any]

  test()                                          //> res0: List[Any] = List((4,'a), 'b, (2,'c), (2,'a), 'd, (4,'e))

}