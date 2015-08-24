/**
 * Author: He Tao, BUAA
 * Date: 2015-08-23
 *
 * P08 (**) Eliminate consecutive duplicates of list elements.
 * If a list contains repeated elements they should be replaced with a single copy of
 * the element. The order of the elements should not be changed.
 * Example:
 *    scala> compress(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
 *    res0: List[Symbol] = List('a, 'b, 'c, 'a, 'd, 'e)
 */
object P08 {
  def compress(xs: List[Symbol]): List[Symbol] = xs match {
    case Nil => Nil
    case fst :: Nil => List(fst)
    case fst :: snd :: rest => {
      if(fst == snd) compress(snd :: rest)
      else fst :: compress(snd :: rest)
    }
  }                                               //> compress: (xs: List[Symbol])List[Symbol]

  def test() = {
    compress(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
  }                                               //> test: ()List[Symbol]

  test()                                          //> res0: List[Symbol] = List('a, 'b, 'c, 'a, 'd, 'e)

}