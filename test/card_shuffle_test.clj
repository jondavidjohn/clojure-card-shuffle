(ns card-shuffle-test
  (:require [card-shuffle :refer :all])
  (:require [clojure.test :refer :all]))

(deftest mongean-test
  (is (= (mongean [1 2 3 4 5 6]) (seq [6 4 2 1 3 5]))) ;; even
  (is (= (mongean (seq [1 2 3 4 5])) (seq [4 2 1 3 5]))) ;; odd
  (is (= (mongean '(1 2 3 4 5 6) 3) (seq [3 6 1 5 4 2]))) ;; recur even
  (is (= (mongean [1 2 3 4 5] 3) (seq [1 2 3 4 5]))) ;; recur odd
  (is (= (mongean '(1 2 3 4 5) 2) (seq [3 2 4 1 5])))) ;; recur odd

(deftest pile-test
  (is (= (pile [1 2 3 4 5 6 7 8 9 10]) (seq [10 7 4 1 8 5 2 9 6 3]))) ;; even
  (is (= (pile (seq [1 2 3 4 5 6 7 8 9])) (seq [7 4 1 8 5 2 9 6 3]))) ;; odd
  (is (= (pile '(1 2 3 4 5 6 7 8 9 10) 3 3) (seq [4 7 10 3 6 9 2 5 8 1]))) ;; recur even
  (is (= (pile (seq [1 2 3 4 5 6 7 8 9]) 3 3) (seq [3 6 9 2 5 8 1 4 7]))) ;; recur odd
  (is (= (pile [1 2 3 4 5 6 7 8 9 10] 3 2) (seq [3 2 1 10 9 8 7 6 5 4])))) ;; recur odd
