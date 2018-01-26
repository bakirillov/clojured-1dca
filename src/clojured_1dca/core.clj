;; gorilla-repl.fileformat = 1

;; @@
(ns clojured-1dca.core
  (:require [clojure.tools.cli :refer [parse-opts]]) ;; For parsing the CLI
  (:require [clojure.string :as str]) ;; For operations with strings
  (:require [clojure.set :refer [union]])
  (:gen-class))

(def cli-options
  [["-n" "--number-of-1dca value" "Number of 1dca rule (between 0 and 255)"
    :id :number
    :parse-fn #(Integer/parseInt %)
    :default 110] ;; I like this 1D cellular automaton because it is Turing-complete
   ["-e" "--epochs value" "Number of epochs"
    :id :epochs
    :parse-fn #(Integer/parseInt %)
    :default 50]
   ["-s" "--seed value" "Seed"
    :id :seed
    :parse-fn #(Integer/parseInt %)
    :default 100500]
   ["-w" "--width value" "Width of a stage"
    :id :width
    :parse-fn #(Integer/parseInt %)
    :default 160]])

(defn build-vector-of-ones-and-zeroes [number]
  (let
    [binary-representation (map read-string (str/split (Integer/toBinaryString number) #""))]
  	(into [] (union (repeat (- 8 (count binary-representation)) 0) binary-representation))
    )
  )

(defn make-tile [x width]
  (into [] (take width (apply concat (repeat (+ 1 (/ width (count x))) x))))
)

(defn next-generation [current-generation rule]
  (let [rules
 {
    [0 0 0] (rule 0)
    [0 0 1] (rule 1)
    [0 1 0] (rule 2)
    [0 1 1] (rule 3)
    [1 0 0] (rule 4)
    [1 0 1] (rule 5)
    [1 1 0] (rule 6)
    [1 1 1] (rule 7)
  }]
    (concat [0] (into [] (map (fn [x] (rules x)) (partition 3 1 current-generation))) [0])
    )
  )

(defn evolve [epochs start rule]
  (let
    [generations (atom [start])]
    (last (repeatedly 
      epochs #(reset! generations (into [] (concat @generations [(into [] (next-generation (last @generations) rule))]))))
    ))
  )

(defn make-frame [x height]
  (
    cond 
     (>= (count x) height) (take-last height x)
     (< (count x) height) (concat (into [] (repeat (- height (count x)) (into [] (repeat (count (x 0)) 0)))) x)
    )
  )

(defn make-line [line]
  (println (str/join (map (fn [x] (if (= x 0) "." "+")) line)))
  )

(defn -main
  "Main function"
  [& args]
  (let [argmap (parse-opts args cli-options)
        start-generation (make-tile (build-vector-of-ones-and-zeroes ((argmap :options) :seed)) ((argmap :options) :width))
        rule (build-vector-of-ones-and-zeroes ((argmap :options) :number))
        ]
    (doall (map make-line (evolve ((argmap :options) :epochs) start-generation rule)))
  )
)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;clojured-1dca.core/-main</span>","value":"#'clojured-1dca.core/-main"}
;; <=

;; @@


;; @@
