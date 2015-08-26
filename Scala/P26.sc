/*
 * Author: He Tao, BUAA
 * Date: 2015-08-25
 *
 * P26 (**) Generate the combinations of K distinct objects chosen from the N elements of a list.
 * In how many ways can a committee of 3 be chosen from a group of 12 people? We all know that there
 * are C(12,3) = 220 possibilities (C(N,K) denotes the well-known binomial coefficient). For pure
 * mathematicians, this result may be great. But we want to really generate all the possibilities.
 * Example:
 *    scala> combinations(3, List('a, 'b, 'c, 'd, 'e, 'f))
 *    res0: List[List[Symbol]] = List(List('a, 'b, 'c), List('a, 'b, 'd), List('a, 'b, 'e), ...
 */
 
object P26 {
  def combinations(n: Int, xs: List[Symbol]): List[List[Symbol]] = {
    if(n == 0) List(List())
    else {
      for {
        y::xss <- xs.tails.toList
        ys <- combinations(n-1, xss)
      } yield (y::ys)
    }
  }                                               //> combinations: (n: Int, xs: List[Symbol])List[List[Symbol]]
  
  def test() = {
    combinations(3, List('a, 'b, 'c, 'd, 'e, 'f))
  }                                               //> test: ()List[List[Symbol]]


  test()                                          //> res0: List[List[Symbol]] = List(List('a, 'b, 'c), List('a, 'b, 'd), List('a,
                                                  //|  'b, 'e), List('a, 'b, 'f), List('a, 'c, 'd), List('a, 'c, 'e), List('a, 'c,
                                                  //|  'f), List('a, 'd, 'e), List('a, 'd, 'f), List('a, 'e, 'f), List('b, 'c, 'd)
                                                  //| , List('b, 'c, 'e), List('b, 'c, 'f), List('b, 'd, 'e), List('b, 'd, 'f), Li
                                                  //| st('b, 'e, 'f), List('c, 'd, 'e), List('c, 'd, 'f), List('c, 'e, 'f), List('
                                                  //| d, 'e, 'f))
}