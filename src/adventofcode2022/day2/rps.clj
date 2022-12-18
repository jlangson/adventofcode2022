(ns adventofcode2022.day2.rps
  (:require [clojure.string :as str]))
;rock paper scissors

(def input (str/split-lines (slurp "src/adventofcode2022/day2/input.txt")))

(def elf-code {"A" "Rock"
               "B" "Paper"
               "C" "Scissors"})

(def my-code {"X" "Rock"                                    ;1
              "Y" "Paper"                                   ;2
              "Z" "Scissors"})                              ;3 pts

(defn rps-result
  "Determines who won RPS. > 0 is me wins, < 0 elf wins. 0 is draw."
  [elf me]
  (cond
    (= elf me) 0
    (and (= elf "Rock") (= me "Paper")) 1
    (and (= elf "Rock") (= me "Scissors")) -1
    (and (= elf "Paper") (= me "Rock")) -1
    (and (= elf "Paper") (= me "Scissors")) 1
    (and (= elf "Scissors") (= me "Rock")) 1
    (and (= elf "Scissors") (= me "Paper")) -1
    :else (throw (Exception. "???? What happened in winner?!"))))

(defn score
  "pos result is I won. 0 result is draw. neg result is I lose"
  [my-choice result]
  (let [choice-score (cond
                    (= "Rock" my-choice)      1
                    (= "Paper" my-choice)     2
                    (= "Scissors" my-choice)  3
                    :else (throw (Exception. (str "rps-score error CHOICE= " my-choice))))
        result-score (cond
                       (pos? result) 6
                       (neg? result) 0
                       :else 3)]
    (+ choice-score result-score)))

(defn row-score
  "Rock Paper Scissors is 1 2 3 pts respectively
  Lose is 0 pts.   Tie is 3.  Win is 6 pts"
  [row]
  (let [e (elf-code (str (first row)))
        m (my-code (str (nth row 2)))                       ;since there is a space " " in the files
        result (rps-result e m)]
    (score m result)))

(defn total-score [str-coll]
  (apply + (map row-score str-coll)))


;;;=====================================================
;;;PART 2
;;

(def strategy {"X" :lose
               "Y" :draw
               "Z" :win})

(def playing-to-win {"Rock" "Paper"
                     "Paper" "Scissors"
                     "Scissors" "Rock"})

(def playing-to-lose {"Rock" "Scissors"
                      "Paper" "Rock"
                      "Scissors" "Paper"})

(defn determine-my-choice
  "Decides that I should play based on my strategy and their move"
  [their-choice my-goal]
  (let [m (strategy my-goal)]
    (cond
      (= m :win)  (playing-to-win their-choice)
      (= m :lose) (playing-to-lose their-choice)
      (= m :draw) their-choice
      :else (throw (Exception. "Something weird happened in determine-my-choice. m= " m)))))


(defn part2-row-score [row]
  (let [their-choice (elf-code (str (first row)))           ;`str` because a character isn't the key in the map
        my-goal (strategy (str (nth row 2)))
        my-choice (determine-my-choice their-choice my-goal)
        result (rps-result their-choice my-choice)]
    (score my-choice result)


    )

  )

(defn calc-part2-score [str-coll]
  (apply + (map part2-row-score str-coll)))

(comment

  (defn total-score [str-coll]
    (apply + (map row-score str-coll)))
  )