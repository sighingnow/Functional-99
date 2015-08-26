{--
 - Problem 37
(**) Calculate Euler's totient function phi(m) (improved).
    See problem 34 for the definition of Euler's totient function. If the list of the prime factors of a number
    m is known in the form of problem 36 then the function phi(m) can be efficiently calculated as follows:
    Let ((p1 m1) (p2 m2) (p3 m3) ...) be the list of prime factors (and their multiplicities) of a given number
    m. Then phi(m) can be calculated with the following formula:

    phi(m) = (p1 ‐ 1) * p1 ** (m1 ‐ 1) *
    (p2 ‐ 1) * p2 ** (m2 ‐ 1) *
    (p3 ‐ 1) * p3 ** (m3 ‐ 1) * ...

    Note that a ** b stands for the b'th power of a.
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

pow :: Int -> Int -> Int
pow a k = product $ map (const a) [1, 2 .. k]

phi :: Int -> Int
phi n = product $ map (\a -> (fst a -1) * pow (fst a) (snd a - 1)) $ primeFactorsMult n
