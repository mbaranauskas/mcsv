(ns mcsv.core
  (:require [clojure.tools.cli :refer [parse-opts]]
            [mcsv.delimiters :refer [parse-delimiter]]
            [mcsv.csv :refer [csv-file->maps]])
  (:gen-class))

(def cli-options
  ;; An option with a required argument
  [["-d" "--delimiter DELIMITER" "Delimiter symbol"
    :default ";"
    :parse-fn #(parse-delimiter %)
    :validate [#(parse-delimiter %) "Must be valid delimiter"]]
   ["-t" "--target-delimiter" "Delimiter symbol for target file"
    :parse-fn #(parse-delimiter %)
    :validate [#(parse-delimiter %) "Must be valid delimiter"]]
   ;; A non-idempotent option (:default is applied first)
   ["-h" "--help"]])

(defn read-csv [options]
  (csv-file->maps
   (first (get-in options [:arguments]))
   (first (get-in options [:options :delimiter]))))

(defn -main
  [& args]
  (if (< 0 (count args))
      (let [options (parse-opts args cli-options)]
        (doseq 
            [x (read-csv options)]
          (println x)))
      (println "No options provided")))
