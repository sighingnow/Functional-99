{--
 - Problem 21
Insert an element at a given position into a list.

    Example:
    * (insert‐at 'alfa '(a b c d) 2)
    (A ALFA B C D)

    Example in Haskell:
    P21> insertAt 'X' "abcd" 2
    "aXbcd"
 --}

insertAt :: a -> [a] -> Int -> [a]
insertAt x xs k = take (k-1) xs ++ [x] ++ drop (k-1) xs
