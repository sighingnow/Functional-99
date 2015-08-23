{-- 
 - Problem 5
(*) Reverse a list.

    Example in Haskell:
    Prelude> myReverse "A man, a plan, a canal, panama!"
    "!amanap ,lanac a ,nalp a ,nam A"
    Prelude> myReverse [1,2,3,4]
    [4,3,2,1]
 --}

myReverse = reverse

myReverse' :: [a] -> [a]
myReverse' [] = []
myReverse' (x:xs) = myReverse' xs ++ [x]

myReverse'' = foldl (flip (:)) []

-- flip :: (a -> b -> c) -> b -> a -> c Source
--  flip f takes its (first) two arguments in the reverse order of f.

