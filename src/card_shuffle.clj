(ns card-shuffle)

(defn riffle
  ([cards] (riffle cards 1))
  ([cards times]
    (let [card_count (count cards)
          marg (if (> card_count 20) (int (* 0.1 card_count)) 2)
          middleish (+ (int (/ card_count 2)) (rand-nth (range (- marg) marg)))
          decks (split-at middleish cards)
          deck1 (->> (nth decks 0) (partition-by (fn [i] (= 0 (rand-int 2)))))
          deck2 (->> (nth decks 1) (partition-by (fn [i] (= 0 (rand-int 2)))))]
      (->> (interleave deck1 deck2) flatten))))

(defn overhand
  ([cards] (overhand cards 1))
  ([cards times]
    (let [card_count (count cards)
          shuffled_deck (->> cards
            (partition-by (fn [c] (= 0 (rand-int 2) )))
            reverse
            flatten)]
    (if (> times 1)
        (overhand shuffled_deck (dec times))
        shuffled_deck))))

(defn mongean
  ([cards] (mongean cards 1))
  ([cards times]
    (let [vec_cards (vec cards)
          num-cards (count vec_cards)
          final-order (concat (reverse (range 1 num-cards 2))
                              (range 0 num-cards 2))]
      (if (> times 1)
        (mongean (replace vec_cards final-order) (dec times))
        (seq (replace vec_cards final-order))))))

(defn pile
  ([cards] (pile cards 3 1))
  ([cards num_piles] (pile cards num_piles 1))
  ([cards num_piles times]
    (let [shuffled_cards (->>
            (range (dec num_piles) -1 -1)
            (mapcat #(take-nth num_piles (drop % cards)))
            reverse)]
      (if (> times 1)
        (pile shuffled_cards num_piles (dec times))
        shuffled_cards))))
