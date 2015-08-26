{--
 - Problem 39
(*) A list of prime numbers.
    Given a range of integers by its lower and upper limit, construct a list of all prime numbers in that range.

    Example in Haskell:
    P29> primesR 10 20
    [11,13,17,19]
 --}

isPrime :: Int -> Bool
isPrime 1 = False
isPrime n = 0 `notElem` map (n `mod`) [2, 3 .. m]
    where m = floor . sqrt $ fromIntegral n 

primesR :: Int -> Int -> [Int]
primesR l r = filter isPrime [l .. r]
