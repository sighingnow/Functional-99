{--
 - Problem 56
(**) Symmetric binary trees
    Let us call a binary tree symmetric if you can draw a vertical line through the root node and then the
    right subtree is the mirror image of the left subtree. Write a predicate symmetric/1 to check whether a
    given binary tree is symmetric. 

    Hint: Write a predicate mirror/2 first to check whether one tree is the
    mirror image of another. We are only interested in the structure, not in the contents of the nodes.

    Example in Haskell:
    *Main> symmetric (Branch 'x' (Branch 'x' Empty Empty) Empty)
    False
    *Main> symmetric (Branch 'x' (Branch 'x' Empty Empty) (Branch 'x' Empty Empty))
    True
 --}

data Tree a = Empty | Branch a (Tree a) (Tree a) deriving (Show, Eq)

symmetric :: Tree a -> Bool
symmetric Empty = True
symmetric (Branch _ l r) = isMirror l r where
    isMirror Empty Empty = True
    isMirror (Branch _ lx rx) (Branch _ ly ry) = (isMirror lx ry) && (isMirror ly rx)
    isMirror _ _ = False

