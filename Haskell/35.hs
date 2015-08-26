{--
 - Problem 35
(**) Determine the prime factors of a given positive integer. Construct a flat list containing the prime
    factors in ascending order.

    Example:
    * (prime‐factors 315)
    (3 3 5 7)

    Example in Haskell:
    > primeFactors 315
    [3, 3, 5, 7]
 --}

primeFactors :: Int -> [Int]
primeFactors 1 = []
primeFactors n = k : primeFactors (n `quot` k) where
    k = head $ filter (\a -> n `mod` a == 0) [2, 3 .. n] 
