(ns rosalind.core)

(def dna-base-pairs
  {\A \T,
   \C \G,
   \G \C,
   \T \A})

(defn parse-fasta-file
  [fasta-file]
  (let [name-and-sequences
    (drop 1
          (clojure.string/split
            (slurp fasta-file) #">"))]
    (into {}
      (map (fn [name-and-sequence]
           (let [sequence-array (clojure.string/split name-and-sequence #"\n")]
             { (first sequence-array) (apply str (rest sequence-array))}))
         name-and-sequences))))


(defn count-nucleotides
  [dna-sequence]
  (let [frequency-map (frequencies dna-sequence)]
    (map
      (fn [nucleotide]
        (get frequency-map nucleotide))
      [\A \C \G \T])))


(defn dna-to-rna
  [dna-sequence]
  (clojure.string/replace dna-sequence #"T" "U"))


(defn reverse-complement
  [sequence]
  (apply str
         (reverse
           (map
             (fn [nucleotide]
               (get dna-base-pairs nucleotide))
             sequence))))


(defn highest-gc-content-from-fasta-file
  [fasta-file]
  (parse-fasta-file "resources/gc_content.txt"))



  (parse-fasta-file "resources/gc_content.txt")
