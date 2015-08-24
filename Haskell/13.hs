{--
 - Problem 13
(**) Run-length encoding of a list (direct solution).
    Implement the so-called run-length encoding data compression method directly. I.e. don't explicitly
    create the sublists containing the duplicates, as in problem 9, but only count them. As in problem P11,
    simplify the result list by replacing the singleton lists (1 X) by X.

    Example:
    * (encode‐direct '(a a a a b c c a a d e e e e))
    ((4 A) B (2 C) (2 A) D (4 E))

    Example in Haskell:
    P13> encodeDirect "aaaabccaadeeee"
    [Multiple 4 'a',Single 'b',Multiple 2 'c', Multiple 2 'a',Single 'd',Multiple 4 'e']
 --}

import Data.List

data Encoded a = Single a | Multiple Int a deriving (Eq, Show)

encodeDirect :: (Eq a) => [a] -> [Encoded a]
encodeDirect [] = []
encodeDirect (x:xs) = header x xs : encodeDirect rest
    where
        header x xs
            | len == 1 = Single x
            | otherwise = Multiple len x
            where len = (+1) $ length $ takeWhile (== x) xs
        rest = dropWhile (== x) xs

encodeDirect' :: (Eq a) => [a] -> [Encoded a]
encodeDirect' [] = []
encodeDirect' (x:xs) = header : encodeDirect' rest
    where
        header = if len == 1 then Single x else Multiple len x
            where len = (+1) $ length $ takeWhile (== x) xs
        rest = dropWhile (== x) xs