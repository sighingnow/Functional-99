/*
 * Author: He Tao, BUAA
 * Date: 2015-08-25
 *
 * P27 (**) Group the elements of a set into disjoint subsets.
 * a) In how many ways can a group of 9 people work in 3 disjoint subgroups of 2, 3
 * and 4 persons? Write a function that generates all the possibilities.
 * Example:
 *    scala> group3(List("Aldo", "Beat", "Carla", "David", "Evi", "Flip", "Gary", "Hugo", "Ida"))
 *    res0: List[List[List[String]]] = List(List(List(Aldo, Beat), List(Carla, David, Evi), List(Flip, Gary, Hugo, Ida)), ...
 * b) Generalize the above predicate in a way that we can specify a list of group sizes and the predicate will return a list of groups.
 * Example:
 *    scala> group(List(2, 2, 5), List("Aldo", "Beat", "Carla", "David", "Evi", "Flip", "Gary", "Hugo", "Ida"))
 *    res0: List[List[List[String]]] = List(List(List(Aldo, Beat), List(Carla, David), List(Evi, Flip, Gary, Hugo, Ida)), ...
 *
 * Note that we do not want permutations of the group members; i.e. ((Aldo, Beat), ...) is the same solution as ((Beat, Aldo), ...).
 * However, we make a difference between ((Aldo, Beat), (Carla, David), ...) and ((Carla, David), (Aldo, Beat), ...).
 * You may find more about this combinatorial problem in a good book on discrete mathematics under the term "multinomial coefficients".
 */

object P27 {

  def group(ns: List[Int], xs: List[String]): List[List[List[String]]] = {

    def combine(n: Int, xs: List[String]): List[(List[String], List[String])] = {
      if (n == 0) List((List(), xs))
      else if (xs == Nil) List()
      else {
        val ts = for {
          (ys, zs) <- combine(n - 1, xs.tail)
        } yield (xs.head :: ys, zs)
        val ds = for {
          (ys, zs) <- combine(n, xs.tail)
        } yield (ys, xs.head :: zs)

        ts ::: ds
      }
    }

    if (ns == Nil) List(List())
    else for {
      (g, rs) <- combine(ns.head, xs)
      gs <- group(ns.tail, rs)
    } yield (g :: gs)
  }                                               //> group: (ns: List[Int], xs: List[String])List[List[List[String]]]

  def group3(xs: List[String]): List[List[List[String]]] = {
    group(List(2, 3, 4), xs)
  }                                               //> group3: (xs: List[String])List[List[List[String]]]

  def test() = {
    group(List(2, 2, 5), List("Aldo", "Beat", "Carla", "David", "Evi", "Flip", "Gary", "Hugo", "Ida")).length
    group3(List("Aldo", "Beat", "Carla", "David", "Evi", "Flip", "Gary", "Hugo", "Ida")).length
  }                                               //> test: ()Int

  test()                                          //> res0: Int = 1260
}