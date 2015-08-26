{--
 - Problem 32
(**) Determine the greatest common divisor of two positive integer numbers. Use Euclid's algorithm
    (http://en.wikipedia.org/wiki/Euclidean_algorithm) .

    Example:
    * (gcd 36 63)
    9

    Example in Haskell:
    [myGCD 36 63, myGCD (‐3) (‐6), myGCD (‐3) 6]
    [9,3,3]
 --}

myGCD :: Int -> Int -> Int
myGCD a b
    | a `mod` b == 0 = abs b
    | otherwise = myGCD b (a `mod` b)

myGCD' = gcd
