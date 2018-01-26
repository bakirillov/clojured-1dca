;; gorilla-repl.fileformat = 1

;; @@
(defproject clojured-1dca "0.1.0-SNAPSHOT"
  :description "Simulator of 1D cellular automata in Clojure"
  :dependencies [
    [org.clojure/clojure "1.8.0"]
    [org.clojure/tools.cli "0.3.5"]
  ]
  :main ^:skip-aot clojured-1dca.core
  :target-path "target/%s"
  :uberjar-name "clojured-1dca"
  :plugins [[lein-gorilla "0.4.0"]]
  :profiles {:uberjar {:aot :all}})

;; @@
