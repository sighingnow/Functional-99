{--
 - Problem 59
    (**) Construct height-balanced binary trees
    In a height-balanced binary tree, the following property holds for every node: 
    The height of its left subtree and the height of its right subtree are almost equal, 
    which means their difference is not greater than one.
    Construct a list of all height-balanced binary trees with the given element and the given maximum height.
    
    Example:
    ?‐ hbal_tree(3,T).
    T = t(x, t(x, t(x, nil, nil), t(x, nil, nil)), t(x, t(x, nil, nil), t(x, nil, nil))) ;
    T = t(x, t(x, t(x, nil, nil), t(x, nil, nil)), t(x, t(x, nil, nil), nil)) ;
    etc......No
    
    Example in Haskell:
    *Main> take 4 $ hbalTree 'x' 3
    [Branch 'x' (Branch 'x' Empty Empty) (Branch 'x' Empty (Branch 'x' Empty Empty)),
     Branch 'x' (Branch 'x' Empty Empty) (Branch 'x' (Branch 'x' Empty Empty) Empty),
     Branch 'x' (Branch 'x' Empty Empty) (Branch 'x' (Branch 'x' Empty Empty) (Branch 'x' Empty Empty)),
     Branch 'x' (Branch 'x' Empty (Branch 'x' Empty Empty)) (Branch 'x' Empty Empty)]
 --}

data Tree a = Empty | Branch a (Tree a) (Tree a) deriving (Show, Eq)

hbalTree :: Char -> Int -> [Tree Char]
hbalTree _ 0 = [Empty]
hbalTree c 1 = [Branch c Empty Empty]
hbalTree c n = [Branch c l r | k <- kk, l <- hbalTree c (fst k), r <- hbalTree c (snd k)] where
    kk = [(n-2, n-1), (n-1, n-2), (n-1, n-1)]
