{--
 - Problem 58
(**) Generate-and-test paradigm
    Apply the generate-and-test paradigm to construct all symmetric, completely balanced binary trees with
    a given number of nodes.
    
    Example:
    * sym‐cbal‐trees(5,Ts).
    symCbalTrees -> Int 
    Ts = [t(x, t(x, nil, t(x, nil, nil)), t(x, t(x, nil, nil), nil)), t(x, t(x, t(x, nil, nil), nil), t(x, nil, t(x, nil, nil)))]
    
    Example in Haskell:
    *Main> symCbalTrees 5
    [Branch 'x' (Branch 'x' Empty (Branch 'x' Empty Empty)) (Branch 'x' (Branch 'x' Empty Empty) Empty), 
     Branch 'x' (Branch 'x' (Branch 'x' Empty Empty) Empty) (Branch 'x' Empty (Branch 'x' Empty Empty))]
 --}

data Tree a = Empty | Branch a (Tree a) (Tree a) deriving (Show, Eq)

cbalTree :: Int -> [Tree Char]
cbalTree 0 = [Empty]
cbalTree 1 = [Branch 'x' Empty Empty]
cbalTree n = [Branch 'x' l r | k <- kk, l <- cbalTree k, r <- cbalTree (n-1-k)] where
    kk = case ((n-1) `rem` 2) of 1 -> [(n-1) `quot` 2, (n-1) `quot` 2 + 1]
                                 0 -> [(n-1) `quot` 2]

symmetric :: Tree a -> Bool
symmetric Empty = True
symmetric (Branch _ l r) = isMirror l r where
    isMirror Empty Empty = True
    isMirror (Branch _ lx rx) (Branch _ ly ry) = (isMirror lx ry) && (isMirror ly rx)
    isMirror _ _ = False

symCbalTrees :: Int -> [Tree Char]
symCbalTrees = filter symmetric . cbalTree


