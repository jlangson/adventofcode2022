(ns adventofcode2022.day2.rps-test
  (:require [clojure.test :refer :all]
            [adventofcode2022.day2.rps :as rps]
            [clojure.test.check.clojure-test :refer [defspec]]
            [clojure.test.check.properties :as prop]
            [clojure.test.check.generators :as gen]))


(def choices #{"Rock" "Paper" "Scissors"})
(def goals #{:win :lose :draw})
(def goal-short-hand #{"X" "Y" "Z"})

(defspec determine-my-choice-test
  (prop/for-all [their-choice (gen/elements choices)
                 my-goal      (gen/elements goal-short-hand)]
    (rps/determine-my-choice their-choice my-goal)))