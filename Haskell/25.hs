{--
 - Problem 25
Generate a random permutation of the elements of a list.

    Example:
    * (rnd‐permu '(a b c d e f))
    (B A D C E F)
    
    Example in Haskell:
    Prelude System.Random>rndPermu "abcdef"
    Prelude System.Random>"badcef"
 --}

import  System.Random

rndPermu :: [a] -> IO [a]
rndPermu xs = do
    gen <- getStdGen
    let n = head $ randomRs (0, length xs) gen
    return $ (xs!!n) : take (n-1) xs ++ drop n xs
