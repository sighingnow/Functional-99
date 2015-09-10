{--
 - Problem 62B
    Collect the nodes at a given level in a list
    A node of a binary tree is at level N if the path from the root to the node has length N-1.
    The root node is at level 1. Write a predicate atlevel/3 to collect all nodes at a given level in a list.
    
    Example:
    % atlevel(T,L,S) :‐ S is the list of nodes of the binary tree T at level L
    
    Example in Haskell:
    Prelude>atLevel tree4 2
    Prelude>[2,2]
 --}

data Tree a = Empty | Branch a (Tree a) (Tree a) deriving (Show, Eq)

tree4 = Branch 1 (Branch 2 Empty (Branch 4 Empty Empty)) (Branch 2 Empty Empty)

atLevel :: Tree a -> Int -> [a]
atLevel Empty _ = []
atLevel (Branch v _ _) 1 = [v]
atLevel (Branch _ l r) n = atLevel l (n-1) ++ atLevel r (n-1)
