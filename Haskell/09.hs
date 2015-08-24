{--
 - Problem 9
(**) Pack consecutive duplicates of list elements into sublists. If a list 
    contains repeated elements they should be placed in separate sublists.

    Example:
    * (pack '(a a a a b c c a a d e e e e))
    ((A A A A) (B) (C C) (A A) (D) (E E E E))

    Example in Haskell:
    *Main> pack ['a', 'a', 'a', 'a', 'b', 'c', 'c', 'a', 'a', 'd', 'e', 'e', 'e', 'e']
    ["aaaa","b","cc","aa","d","eeee"]
 --}

import Data.List

pack :: Eq a => [a] -> [[a]]
pack [] = []
pack (x:xs) = (x : takeWhile (== x) xs) : pack (dropWhile (==x) xs)

pack' :: Eq a => [a] -> [[a]]
pack' [] = []
pack' (x:xs) = let (fst, rest) = span (== x) xs
               in (x : fst) : pack' rest

-- use `group` in `Data.List`
pack'' :: Eq a => [a] -> [[a]]
pack'' = group

-- group :: Eq a => [a] -> [[a]] Source
-- The group function takes a list and returns a list of lists such that the 
-- concatenation of the result is equal to the argument. Moreover, each sublist 
-- in the result contains only equal elements. For example,
--
-- group "Mississippi" = ["M","i","ss","i","ss","i","pp","i"]

