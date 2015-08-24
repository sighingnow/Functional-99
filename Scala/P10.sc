/**
 * Author: He Tao, BUAA
 * Date: 2015-08-23
 *
 * P10 (*) Run-length encoding of a list.
 * Use the result of problem P09 to implement the so-called run-length encoding data
 * compression method. Consecutive duplicates of elements are encoded as tuples (N, E)
 * where N is the number of duplicates of the element E.
 * Example:
 *    scala> encode(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
 *    res0: List[(Int, Symbol)] = List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e))
 */
object P10 {
  def encode(xs: List[Symbol]): List[(Int, Symbol)] = xs match {
    case Nil => Nil
    case fst :: Nil => List((1, fst))
    case fst :: snd :: rest => {
      val r = encode(snd :: rest)
      if(fst == snd) (r.head._1 + 1, fst) :: r.tail
      else (1, fst) :: r
    }
  }                                               //> encode: (xs: List[Symbol])List[(Int, Symbol)]
  
  def test() = {
    encode(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
  }                                               //> test: ()List[(Int, Symbol)]

  test()                                          //> res0: List[(Int, Symbol)] = List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,
                                                  //| 'e))

}