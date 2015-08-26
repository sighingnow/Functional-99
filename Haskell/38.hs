{--
 - Problem 38
(*) Compare the two methods of calculating Euler's totient function.
    Use the solutions of problems 34 and 37 to compare the algorithms. Take the number of reductions as a
    measure for efficiency. Try to calculate phi(10090) as an example.
    (no solution required)
 --}

import Control.Exception
import Data.Time.Clock

totient :: Int -> Int
totient n = length $ filter (== 1) $ map (gcd n) [1 .. n-1]

primeFactors :: Int -> [Int]
primeFactors 1 = []
primeFactors n = k : primeFactors (n `quot` k) where
    k = head $ filter (\a -> n `mod` a == 0) [2, 3 .. n] 

encode :: [Int] -> [(Int, Int)]
encode [] = []
encode (x:xs) = (x, (+1) $ length $ takeWhile (== x) xs) : encode (dropWhile (== x) xs)

primeFactorsMult :: Int -> [(Int, Int)]
primeFactorsMult n = encode $ primeFactors n

pow :: Int -> Int -> Int
pow a k = product $ map (const a) [1, 2 .. k]

phi :: Int -> Int
phi n = product $ map (\a -> (fst a -1) * pow (fst a) (snd a - 1)) $ primeFactorsMult n


benchmark :: Int -> a -> IO (a, NominalDiffTime)
benchmark n f = do
    startTime <- getCurrentTime
    res <- evaluate $ last $ replicate n f
    finishTime <- getCurrentTime
    return (res, diffUTCTime finishTime startTime)

main :: IO ()
main = do
    let times = 100000000
  
    putStrLn "Benchmark totient implementation"
    (_, timeSlow) <- benchmark times (totient 1009001)
    putStrLn $ "It taked " ++ show timeSlow
  
    putStrLn "Benchmark phi implementation"
    (_, timeFast) <- benchmark times (phi 1009001)
    putStrLn $ "It taked " ++ show timeFast
