{--
 - Problem 24
Lotto: Draw N different random numbers from the set 1..M.
    
    Example:
    * (rnd‐select 6 49)
    (23 1 17 33 21 37)
    
    Example in Haskell:
    Prelude System.Random>diffSelect 6 49
    Prelude System.Random>[23,1,17,33,21,37]
 --}

import System.Random

diffSelect :: Int -> Int -> IO [Int]
diffSelect n m = do
    gen <- getStdGen
    return $ takeN n [] gen
    where
        takeN 0 xs gen = xs
        takeN n xs gen
            | x `elem` xs = takeN n xs nextGen
            | otherwise = takeN (n-1) (x:xs) nextGen
            where (x, nextGen) = randomR (1, m) gen

