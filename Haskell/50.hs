{--
 - Problem 50
(***) Huffman codes.
    We suppose a set of symbols with their frequencies, given as a list of fr(S,F) terms. Example:
    [fr(a,45),fr(b,13),fr(c,12),fr(d,16),fr(e,9),fr(f,5)]. Our objective is to construct a list hc(S,C) terms, where
    C is the Huffman code word for the symbol S. In our example, the result could be Hs = [hc(a,'0'),
    hc(b,'101'), hc(c,'100'), hc(d,'111'), hc(e,'1101'), hc(f,'1100')] [hc(a,'01'),...etc.]. The task shall be
    performed by the predicate huffman/2 defined as follows:
    % huffman(Fs,Hs) :‐ Hs is the Huffman code table for the frequency table Fs
   
    Example in Haskell:
    *Exercises> huffman [('a',45),('b',13),('c',12),('d',16),('e',9),('f',5)]
    [('a',"0"),('b',"101"),('c',"100"),('d',"111"),('e',"1101"),('f',"1100")]
 --}

import Data.List
import Data.Function

data Node = Single { val::Char, weight::Int } | Branch { weight::Int, left::Node, right::Node } deriving (Show)

instance Eq Node where
     a == b = (weight a) == (weight b)

instance Ord Node where
    compare a b = compare (weight a) (weight b)

huffmanBuild :: [Node] -> Node
huffmanBuild [x] = x
huffmanBuild (a:b:xs) = huffmanBuild $ sortBy (compare `on` weight) ([Branch ((weight a) + (weight b)) a b] ++ xs)

huffmanEncode :: String -> Node -> [(Char, String)]
huffmanEncode acc (Single v w) = [(v, acc)]
huffmanEncode acc (Branch w l r) = (huffmanEncode (acc++"0") l) ++ (huffmanEncode (acc++"1") r)

huffman :: [(Char, Int)] -> [(Char, String)]
huffman xs = sortBy (compare `on` fst) $ huffmanEncode [] $ huffmanBuild (map (uncurry Single) (sortBy (compare `on` snd) xs))
