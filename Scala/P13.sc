/*
 * Author: He Tao, BUAA
 * Date: 2015-08-24
 *
 * P13 (**) Run-length encoding of a list (direct solution).
 * Implement the so-called run-length encoding data compression method directly. I.e.
 * don't use other methods you've written (like P09's pack); do all the work directly.
 * Example:
 *    scala> encodeDirect(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
 *    res0: List[(Int, Symbol)] = List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e))
 */
 
object P13 {
  def encodeDirect(xs: List[Symbol]): List[(Int, Symbol)] = xs match {
    case Nil => Nil
    case fst :: _ => {
      val sames = xs.takeWhile { a => a == fst }.length
      (sames, fst) :: encodeDirect(xs.drop(sames))
    }
  }                                               //> encodeDirect: (xs: List[Symbol])List[(Int, Symbol)]
  
  def test() = {
    encodeDirect(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
  }                                               //> test: ()List[(Int, Symbol)]

  test()                                          //> res0: List[(Int, Symbol)] = List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,
                                                  //| 'e))

}