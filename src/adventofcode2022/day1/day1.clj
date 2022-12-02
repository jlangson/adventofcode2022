(ns adventofcode2022.day1.day1
  (:require [clojure.string :as str]
            [clojure.java.io :as io]))




;str/replace needed b/c Windows? funky end of lines
(def input (str/replace (slurp "src/adventofcode2022/day1/input.txt") #"\r" ""))
(def input-s (str/replace (slurp "src/adventofcode2022/day1/input-small.txt") #"\r" ""))
;(def input2 (line-seq (io/reader "src/adventofcode2022/day1/input.txt")))

(defn group-elves [s]
  (map #(str/replace % #"\n" " ") (str/split s #"\n\n"))


  ;(let [s2 (str/split s #"\n\n")]
  ;
  ;  (map #(str/replace % "" " ") s2)
  )

(defn group-on-empty-strings [s]
  ; ""
  ; "39972"
  ; ""
  ; "10785"
  ; "17115"
  ; "22811"
  ; ""
  ;
  ;"=>"

  ;[39972 [10785 17115 22811]]

  ()

  )
(str/split input-s #"\n\n")


; ""
; "39972"
; ""
; "10785"
; "17115"
; "22811"
; ""
; "7214"
; "7178"
; "5198"
; "2157"
; "6985"
; "1686"
; "8037"
; "7559"
; "2410"
; "5211"
; "6477"
; ""
; "1496"
; "3607"
; "2326"
; "5342"
; "5777"
; "6182"
; "5528"
; "6324"
; "2023"
; "2944"
; "2175"
; "5035"
; "1424"
; "2154"
; ""
; "5224"
; "4172"
; "1295"
; "7929"
; "4386"
; "2421"
; "6034"
; "2895"
; "3881"
; "2464"