(ns adventofcode2022.day2.rps)
;rock paper scissors

(def elf-code {"A" "Rock"
               "B" "Paper"
               "C" "Scissors"})

(def my-code {"X" "Rock"
              "Y" "Paper"
              "Z" "Scissors"})

(defn calc-winner
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



(comment


  )