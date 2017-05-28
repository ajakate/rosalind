(ns rosalind.core)

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
