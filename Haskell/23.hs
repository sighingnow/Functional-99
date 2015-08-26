{--
 - Problem 23
Extract a given number of randomly selected elements from a list.

    Example:
    * (rnd‐select '(a b c d e f g h) 3)
    (E D A)

    Example in Haskell:
    Prelude System.Random>rndSelect "abcdefgh" 3 >>= putStrLn
    eda
 --}

import  System.Random

rndSelect :: [a] -> Int -> IO [a]
rndSelect xs n = do
    gen <- getStdGen
    return $ take n $ map (xs !!) $ randomRs (0, length xs -1) gen

