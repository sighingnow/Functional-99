{--
 - Problem 1
(*) Find the last element of a list.
    (Note that the Lisp transcription of this problem is incorrect.)

    Example in Haskell:
    Prelude> myLast [1,2,3,4]
    4
    Prelude> myLast ['x','y','z']
    'z'
 --}

myLast = last

myLast' = head . reverse

myLast'' :: [a] -> a
myLast'' [] = error "empty list"
myLast'' [x] = x
myLast'' (_:xs) = myLast'' xs

