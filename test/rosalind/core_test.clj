(ns rosalind.core-test
  (:require [clojure.test :refer :all]
            [rosalind.core :refer :all]))

;; Problem 1
(deftest problem-1
  (testing "Counting the number of A, C, G and T strings"
    (is
      (=
        '(20 12 17 21)
        (count-nucleotides
         "AGCTTTTCATTCTGACTGCAACGGGCAATATGTCTCTGTGTGGATTAAAAAAAGAGTGTCTGATAGCAGC")))))
