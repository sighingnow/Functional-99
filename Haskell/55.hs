{--
 - Problem 55
(**) Construct completely balanced binary trees
    In a completely balanced binary tree, the following property holds for every node: The number of nodes
    in its left subtree and the number of nodes in its right subtree are almost equal, which means their
    difference is not greater than one.
    Write a function cbaltree
    to construct completely balanced binary trees for a given number of nodes.
    The predicate should generate all solutions via backtracking. Put the letter 'x' as information into all
    nodes of the tree.
    
    Example:
    * cbal‐tree(4,T).
    T = t(x, t(x, nil, nil), t(x, nil, t(x, nil, nil))) ;
    etc......No
    
    Example in Haskell, whitespace and "comment diagrams" added for clarity and exposition:
    *Main> cbalTree 4
    [‐
    ‐ permutation 1
    ‐‐  x
    ‐‐ / \
    ‐‐ x  x
    ‐‐     \
    ‐‐      x
    Branch 'x' (Branch 'x' Empty Empty)
               (Branch 'x' Empty
                           (Branch 'x' Empty Empty)),
    ‐‐ permutation 2
    ‐‐  x
    ‐‐ / \
    ‐‐ x  x
    ‐‐   /
    ‐‐  x
    Branch 'x' (Branch 'x' Empty Empty)
               (Branch 'x' (Branch 'x' Empty Empty)
                           Empty),
    ‐‐ permutation 3
    ‐‐  x
    ‐‐ / \
    ‐‐ x  x
    ‐‐  \
    ‐‐   x
    Branch 'x' (Branch 'x' Empty
               (Branch 'x' Empty Empty))
                           (Branch 'x' Empty Empty),
    ‐‐ permutation 4
    ‐‐     x
    ‐‐    / \
    ‐‐   x   x
    ‐‐  /
    ‐‐ x
    Branch 'x' (Branch 'x' (Branch 'x' Empty Empty)
                           Empty)
               (Branch 'x' Empty Empty)
    ]
 --}

data Tree a = Empty | Branch a (Tree a) (Tree a) deriving (Show, Eq)

cbalTree :: Int -> [Tree Char]
cbalTree 0 = [Empty]
cbalTree 1 = [Branch 'x' Empty Empty]
cbalTree n = [Branch 'x' l r | k <- kk, l <- cbalTree k, r <- cbalTree (n-1-k)] where
    kk = case ((n-1) `rem` 2) of 1 -> [(n-1) `quot` 2, (n-1) `quot` 2 + 1]
                                 0 -> [(n-1) `quot` 2]
