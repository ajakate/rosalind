(ns rosalind.population)

(defn rabbit-pairs
  [n k]
  (cond
    (< n 2) 1
    (= n 2) 1
    (= n 3) (+ k 1)
    :else
      (+
        (*
          (rabbit-pairs (- n 2) k) k)
        (rabbit-pairs (- n 1) k))))

