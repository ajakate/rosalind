(ns rosalind.population-test
  (:require [clojure.test :refer :all]
            [rosalind.population :refer :all]))

;; Problem 4?
(deftest fibonacci-rabbit-population
  (testing "The number of rabbit pairs alive after n months given they can make k pairs each month"
    (is
      (=
        19
        (rabbit-pairs 34 5)))))

