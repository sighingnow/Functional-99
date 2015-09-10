{--
 - Problem 27
Group the elements of a set into disjoint subsets.
a) In how many ways can a group of 9 people work in 3 disjoint subgroups of 2, 3 and 4 persons? Write
a function that generates all the possibilities and returns them in a list.

    Example:
    * (group3 '(aldo beat carla david evi flip gary hugo ida))
    ( ( (ALDO BEAT) (CARLA DAVID EVI) (FLIP GARY HUGO IDA) )
    ... )

b) Generalize the above predicate in a way that we can specify a list of group sizes and the predicate will
return a list of groups.

    Example:
    * (group '(aldo beat carla david evi flip gary hugo ida) '(2 2 5))
    ( ( (ALDO BEAT) (CARLA DAVID) (EVI FLIP GARY HUGO IDA) )
    ... )

Note that we do not want permutations of the group members; i.e. ((ALDO BEAT) ...) is the same
solution as ((BEAT ALDO) ...). However, we make a difference between ((ALDO BEAT) (CARLA
DAVID) ...) and ((CARLA DAVID) (ALDO BEAT) ...).

You may find more about this combinatorial problem in a good book on discrete mathematics under the
term "multinomial coefficients".

    Example in Haskell:
    P27> groups [2,3,4] ["aldo","beat","carla","david","evi","flip","gary","hugo","ida"]
    [[["aldo","beat"],["carla","david","evi"],["flip","gary","hugo","ida"]],...]
    (altogether 1260 solutions)
    P27> groups [2,2,5] ["aldo","beat","carla","david","evi","flip","gary","hugo","ida"]
    [[["aldo","beat"],["carla","david"],["evi","flip","gary","hugo","ida"]],...]
    (altogether 756 solutions)
 --}

combination :: Int -> [a] -> [([a], [a])]
combination 0 xs = [([], xs)]
combination n [] = []
combination n (x:xs) = ts ++ ds where
    ts = [(x:ys, zs) | (ys, zs) <- combination (n-1) xs]
    ds = [(ys, x:zs) | (ys, zs) <- combination n xs]

groups :: [Int] -> [a] -> [[[a]]]
groups [] _ = [[]]
groups (n:ns) xs = [g:gs | (g, rs) <- combination n xs, gs <- groups ns rs]


