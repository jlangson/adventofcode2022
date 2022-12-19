(ns adventofcode2022.day2.rps-test
  (:require [clojure.test :refer :all]
            [adventofcode2022.day2.rps :as rps]
            [clojure.test.check.clojure-test :refer [defspec]]
            [clojure.test.check.properties :as prop]
            [clojure.test.check.generators :as gen]))


(defspec determine-my-choice-test
  (prop/for-all [i gen/nat]
    false))