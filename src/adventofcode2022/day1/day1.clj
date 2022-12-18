(ns adventofcode2022.day1.day1
  (:require [clojure.string :as str]
            [clojure.java.io :as io]))




;str/replace needed b/c Windows? funky end of lines
(def input (str/replace (slurp "src/adventofcode2022/day1/input.txt") #"\r" ""))
;(def input-s (str/replace (slurp "src/adventofcode2022/day1/input-small.txt") #"\r" ""))
;(def input2 (line-seq (io/reader "src/adventofcode2022/day1/input.txt")))

(defn group-elves [s]
  (map #(str/replace % #"\n" " ") (str/split s #"\n\n")))

(defn str->sum [s]
  (reduce + (map #(Integer/parseInt %) (str/split s #" "))))

(defn biggest-calories [s]
  (->> s
    group-elves
    (map str->sum)
    (apply max)))

(defn three-biggest-calories-sum [s]
  (->> s
       group-elves
       (map str->sum)
       (sort >)
       (take 3)
       (apply +)))

(println "biggests calorie is" (biggest-calories input))
(println "three biggest are=" (three-biggest-calories-sum input))