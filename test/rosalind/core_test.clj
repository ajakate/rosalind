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


;; Problem 2
(deftest problem-2
  (testing "Transcribing DNA to RNA"
    (is
      (=
        "GAUGGAACUUGACUACGUAAAUU"
        (dna-to-rna
         "GATGGAACTTGACTACGTAAATT")))))


;; Problem 3
(deftest problem-3
  (testing "Reverse complement of DNA"
    (is
      (=
        "ACCGGGTTTT"
        (reverse-complement
         "AAAACCCGGT")))))


;; GC Content Problem
(deftest gc_content
  (testing "GC Content from FASTA file"
    (is
      (=
        ["Rosalind_0808" 60.91954022988506]
        ( highest-gc-content-from-fasta-file
         "resources/gc_content.txt")))))
