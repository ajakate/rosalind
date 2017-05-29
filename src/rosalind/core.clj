(ns rosalind.core)

(def dna-base-pairs
  {\A \T,
   \C \G,
   \G \C,
   \T \A})


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
