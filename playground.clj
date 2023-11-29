(ns playground
  (:require [utilities :as help]))

(defn make-kvp [l r] {:left l :right r})

(let [input [(make-kvp \c \d) (make-kvp \b \c) (make-kvp \a \b)]
      merge-pairs (fn [a p] (assoc a (:left p) (:right p)))
      sourceToDestination (reduce merge-pairs {} input)
      sources (keys sourceToDestination)
      destinations (into #{} (vals sourceToDestination))
      start (help/seek #(not (contains? destinations %)) sources)
      indexes (range 0 (count sourceToDestination))
      sorted-set (reduce (fn [a _]
                           (let [new-key (get sourceToDestination (:k a))]
                             {:k new-key :c (conj (:c a) new-key)}))
                         {:k start :c [start]}
                         indexes)
      answer-as-arrows (reduce #(str %1 " -> " %2) (str (first (:c sorted-set))) (rest (:c sorted-set)))
      answer answer-as-arrows] ; goal: a -> b -> d
  answer)

