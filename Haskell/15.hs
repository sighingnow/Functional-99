{--
 - Problem 15
(**) Replicate the elements of a list a given number of times.

    Example:
    * (repli '(a b c) 3)
    (A A A B B B C C C)
    Example in Haskell:
    > repli "abc" 3
    "aaabbbccc"
 --}

repli :: [a] -> Int -> [a]
repli xs n = concatMap (replicate n) xs
