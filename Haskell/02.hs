{--
 - Problem 2
(*) Find the last but one element of a list.
    (Note that the Lisp transcription of this problem is incorrect.)

    Example in Haskell:
    Prelude> myButLast [1,2,3,4]
    3
    Prelude> myButLast ['a'..'z']
    'y'
 --}

myButLast = last . init

-- init :: Vector a -> Vector a Source
-- O(1) Yield all but the last element without copying. The vector may not be empty.

myButLast' = head . drop 1 .reverse

myButLast'' [x, _] = x
myButLast'' (_:xs) = myButLast'' xs

