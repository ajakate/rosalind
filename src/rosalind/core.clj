(ns rosalind.core)

(defn map-values [m f]
  (into {} (for [[k v] m] [k (f v)])))

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


(defn gc-content [dna-sequence]
  (let [frequency-map (frequencies dna-sequence)
        num-of-gc (+ (get frequency-map \G)
                      (get frequency-map \C))]
    (* 100
       (double
         (/ num-of-gc (count dna-sequence))))))


(defn highest-gc-content-from-fasta-file [fasta-file]
   (apply max-key val (map-values (parse-fasta-file fasta-file) gc-content)))


(defn hamming-distance [strand1 strand2]
  (count
    (filter #(not %1)
      (map
        (fn [pair]
          (= (first pair) (second pair)))
        (map vector strand1 strand2)))))
