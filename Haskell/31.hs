{--
 - Problem 31
(**) Determine whether a given integer number is prime.

    Example:
    * (is‐prime 7)
    T

    Example in Haskell:
    P31> isPrime 7
    True
 --}

isPrime :: Int -> Bool
isPrime 1 = False
isPrime n = 0 `notElem` map (n `mod`) [2, 3 .. m]
    where m = floor . sqrt $ fromIntegral n 
