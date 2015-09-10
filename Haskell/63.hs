{--
 - Problem 63
    Construct a complete binary tree
    A complete binary tree with height H is defined as follows:
    
    The levels 1,2,3,...,H-1 contain the maximum number of nodes (i.e 2**(i-1) at the level i)
    In level H, which may contain less than the maximum possible number of nodes, all the nodes are
    "leftadjusted".

    This means that in a levelorder tree traversal all internal nodes come first, the
    leaves come second, and empty successors (the nil's which are not really nodes!) come last.
    Particularly, complete binary trees are used as data structures (or addressing schemes) for heaps.
    We can assign an address number to each node in a complete binary tree by enumerating the nodes in
    levelorder,
    
    starting at the root with number 1. For every node X with address A the following property
    holds: The address of X's left and right successors are 2*A and 2*A+1, respectively, if they exist. This
    fact can be used to elegantly construct a complete binary tree structure.
    Write a predicate complete_binary_tree/2.
    
    Example:
    % complete_binary_tree(N,T) :‐ T is a complete binary tree with N nodes.
    
    Example in Haskell:
    Main> completeBinaryTree 4
    Branch 'x' (Branch 'x' (Branch 'x' Empty Empty) Empty) (Branch 'x' Empty Empty)
    Main> isCompleteBinaryTree $ Branch 'x' (Branch 'x' Empty Empty) (Branch 'x' Empty Empty)
    True
 --}

data Tree a = Empty | Branch a (Tree a) (Tree a) deriving (Show, Eq)

tree4 = Branch 1 (Branch 2 Empty (Branch 4 Empty Empty)) (Branch 2 Empty Empty)

completeBinaryTree :: Int -> Tree Char
completeBinaryTree = makeTree 'x' 1 where
    makeTree c k n
        | k > n = Empty
        | otherwise = Branch c (makeTree c (2*k) n) (makeTree c (2*k+1) n)

isCompleteBinaryTree :: Tree a -> Bool
isCompleteBinaryTree tree = detectTree tree 1 (count tree) where
    detectTree Empty k n = k > n
    detectTree (Branch _ l r) k n = detectTree l (2*k) n && detectTree r (2*k+1) n
    count Empty = 0
    count (Branch _ l r) = count l + count r

