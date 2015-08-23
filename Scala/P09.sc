/**
 * Author: He Tao, BUAA
 * Date: 2015-08-23
 *
 * P09 (**) Pack consecutive duplicates of list elements into sublists.
 * If a list contains repeated elements they should be placed in separate sublists.
 * Example:
 *    scala> pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
 *    res0: List[List[Symbol]] = List(List('a, 'a, 'a, 'a), List('b), List('c, 'c), List('a, 'a), List('d), List('e, 'e, 'e, 'e))
 */
object P09 {
  def pack(l: List[Symbol]): List[List[Symbol]] = l match {
    case Nil => Nil
    case fst :: Nil => List(List(fst))
    case fst :: snd :: rest => {
      val r = pack(snd :: rest)
      if(fst == snd) (fst :: r.head) :: r.tail
      else List(fst) :: r
    }
  }
  pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
}
