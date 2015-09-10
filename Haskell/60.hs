{--
 - Problem 60
(**) Construct height-balanced binary trees with a given number of nodes
    Consider a height-balanced binary tree of height H. What is the maximum number of nodes it can
    contain?
    Clearly, MaxN = 2**H - 1.
    However, what is the minimum number MinN? This question is more difficult. Try to find a recursive 
    statement and turn it into a function minNodes that returns the minimum number of nodes in a height-balanced
    binary tree of height H. 
    On the other hand, we might ask: what is the maximum height H a height-balanced
    binary tree with N nodes can have? Write a function maxHeight that computes this.
    
    Now, we can attack the main problem: construct all the height-balanced binary trees with a given
    number of nodes. Find out how many height-balanced trees exist for N = 15.
    
    Example in Prolog:
    ?‐ count_hbal_trees(15,C).
    C = 1553
    
    Example in Haskell:
    *Main> length $ hbalTreeNodes 'x' 15
    1553
    *Main> map (hbalTreeNodes 'x') [0..3]
    [[Empty],
    [Branch 'x' Empty Empty],
    [Branch 'x' Empty (Branch 'x' Empty Empty),Branch 'x' (Branch 'x' Empty Empty) Empty],
    [Branch 'x' (Branch 'x' Empty Empty) (Branch 'x' Empty Empty)]]
 --}

import Data.List
import Data.Maybe

data Tree a = Empty | Branch a (Tree a) (Tree a) deriving (Show, Eq)

maxN :: Int -> Int
maxN h = round $ 2 ** fromIntegral h

minN :: Int -> Int
minN 0 = 0
minN 1 = 1
minN h = 1 + minN (h-1) + minN (h-2)

minHeight :: Int -> Int
minHeight n = ceiling $ logBase 2 (fromIntegral n)

maxHeight :: Int -> Int
maxHeight n = fromJust (findIndex (> n) $ map minN [0..]) - 1

hbalTree :: Char -> Int -> Int -> [Tree Char]
hbalTree _ 0 0 = [Empty]
hbalTree c 1 1 = [Branch c Empty Empty]
hbalTree c h n
    | (h > maxHeight n) || (h < minHeight n) = []
    | otherwise = [Branch c l r | p <- pp, q <- [0 .. n-1], l <- hbalTree c (fst p) q, r <- hbalTree c (snd p) (n-1-q)] where
        pp = [(h-2, h-1), (h-1, h-2), (h-1, h-1)]

hbalTreeNodes :: Char -> Int -> [Tree Char]
hbalTreeNodes c n = concatMap (\h -> hbalTree c h n) [(minHeight n) .. (maxHeight n)]
