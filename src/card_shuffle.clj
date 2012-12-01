(ns card-shuffle)

;; Helper to Chunk coll into random groups
(defn- partition-by-rand [coll]
  (partition-by (fn [i] (= 0 (rand-int 2))) coll))

(defn riffle
  ([cards] (riffle cards 1))
  ([cards times]
    (let [card-count (count cards)
          marg (if (> card-count 20) (int (* 0.1 card-count)) 2)
          middleish (+ (int (/ card-count 2)) (rand-nth (range (- marg) marg)))
          [deck1 deck2] (split-at middleish cards)
          deck1 (partition-by-rand deck1)
          deck2 (partition-by-rand deck2)]
      (->> (interleave deck1 deck2) flatten))))


(defn overhand
  ([cards] (overhand cards 1))
  ([cards times]
    (let [shuffled-deck (->> cards
            partition-by-rand
            reverse
            flatten)]
      (if (> times 1)
        (recur shuffled-deck (dec times))
        shuffled-deck))))

(defn mongean
  ([cards] (mongean cards 1))
  ([cards times]
    (let [vec-cards (vec cards)
          num-cards (count vec-cards)
          final-order (concat (reverse (range 1 num-cards 2))
                              (range 0 num-cards 2))]
      (if (> times 1)
        (recur (replace vec-cards final-order) (dec times))
        (seq (replace vec-cards final-order))))))

(defn pile
  ([cards] (pile cards 3 1))
  ([cards num-piles] (pile cards num-piles 1))
  ([cards num-piles times]
    (let [shuffled-cards (->>
            (range (dec num-piles) -1 -1)
            (mapcat #(take-nth num-piles (drop % cards)))
            reverse)]
      (if (> times 1)
        (recur shuffled-cards num-piles (dec times))
        shuffled-cards))))
