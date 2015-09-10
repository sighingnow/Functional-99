{--
 - Problem 49
    (**) Gray codes.
    An n-bit Gray code is a sequence of n-bit strings constructed according to certain rules. For example,
    
    n = 1: C(1) = ['0','1'].
    n = 2: C(2) = ['00','01','11','10'].
    n = 3: C(3) = ['000','001','011','010',´110´,´111´,´101´,´100´].
    
    Find out the construction rules and write a predicate with the following specification:
    % gray(N,C) :‐ C is the N‐bit Gray code
    
    Can you apply the method of "result caching" in order to make the predicate more efficient, when it is to
    be used repeatedly?
    
    Example in Haskell:
    P49> gray 3
    ["000","001","011","010","110","111","101","100"]
 --}

-- Gray Code algorithm:
--  Suppose n > 1 and the reflected Gray code of order n - 1 has been constructed.
--  To construct the reflected Gray code of order n, we first list the (n - I)-tuples
--  of Os and Is in the order given by the reflected Gray code of order n - 1, and
--  attach a 0 at the beginning (i.e. on the left) of each (n - I)-tuple. We then list
--  the (n - I)-tuples in the order which is the reverse of that given by the reflected
--  Gray code of order n - 1, and attach a 1 at the beginning.

grayEncode :: Int -> [[Int]]
grayEncode 0 = []
grayEncode 1 = [[0], [1]]
grayEncode n = map ([0] ++) k ++ map ([1] ++) (reverse k) where k = grayEncode (n-1)

gray :: Int -> [String]
gray n = map (concatMap show) (grayEncode n)
