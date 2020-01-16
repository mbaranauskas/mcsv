(ns mcsv.core
  (:require [clojure.tools.cli :refer [parse-opts]]
            [mcsv.delimiters :refer [parse-delimiter]])
  (:gen-class))

(def cli-options
  ;; An option with a required argument
  [["-d" "--delimiter DELIMITER" "Delimiter symbol"
    :default ";"
    :parse-fn #(parse-delimiter %)]
    ;:validate [#(parse-delimiter %) "Must be valid delimiter"]]
   ;; A non-idempotent option (:default is applied first)
   ["-h" "--help"]])

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (let [options (parse-opts args cli-options)]
    (println (get-in options [:options :delimiter]))))
