{--
 - Problem 46
(**) Define predicates and/2, or/2, nand/2, nor/2, xor/2, impl/2 and equ/2 (for logical equivalence) which
    succeed or fail according to the result of their respective operations; e.g. and(A,B) will succeed, if and
    only if both A and B succeed.
    A logical expression in two variables can then be written as in the following example:
    and(or(A,B),nand(A,B)).
    Now, write a predicate table/3 which prints the truth table of a given logical expression in two variables.
    
    Example:
    (table A B (and A (or A B)))
    true true true
    true fail true
    fail true fail
    fail fail fail
    
    Example in Haskell:
    > table (\a b -> (and' a (or' a b)))
    True True True
    True False True
    False True False
    False False False
 --}

import Data.Bool

and' :: Bool -> Bool -> Bool
and' a b = a && b

or' :: Bool -> Bool -> Bool
or' a b = a || b

table :: (Bool -> Bool -> Bool) -> [(Bool, Bool, Bool)]
table f = map (\x -> (fst x, snd x, uncurry f x)) [(a, b) | a <- [True, False], b <- [True, False]]
