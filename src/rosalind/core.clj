(ns rosalind.core)

(defn count-nucleotides
  [dna-sequence]
  (let [frequency-map (frequencies dna-sequence)]
    [ (get frequency-map \A)
      (get frequency-map \C)
      (get frequency-map \G)
      (get frequency-map \T)]))
