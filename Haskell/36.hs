{--
 - Problem 36
(**) Determine the prime factors of a given positive integer.
    Construct a list containing the prime factors and their multiplicity.

    Example:
    * (prime‐factors‐mult 315)
    ((3 2) (5 1) (7 1))

    Example in Haskell:
    *Main> primeFactorsMult 315
    [(3,2),(5,1),(7,1)]
 --}

primeFactors :: Int -> [Int]
primeFactors 1 = []
primeFactors n = k : primeFactors (n `quot` k) where
    k = head $ filter (\a -> n `mod` a == 0) [2, 3 .. n] 

encode :: [Int] -> [(Int, Int)]
encode [] = []
encode (x:xs) = (x, (+1) $ length $ takeWhile (== x) xs) : encode (dropWhile (== x) xs)

primeFactorsMult :: Int -> [(Int, Int)]
primeFactorsMult n = encode $ primeFactors n
