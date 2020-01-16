(ns mcsv.core
  (:require [clojure.tools.cli :refer [parse-opts]])
  (:gen-class))

(def delimiters (hash-map ";" :semicolon
                          "," :comma
                          "\\t" :tab))

(defn parse-delimiter 
  [delimiter]
  (get delimiters delimiter))

(def cli-options
  ;; An option with a required argument
  [["-d" "--delimiter DELIMITER" "Delimiter symbol"
    :default ";"
    :parse-fn #(parse-delimiter %)
    :validate [#(parse-delimiter %) "Must be valid delimiter"]]
   ;; A non-idempotent option (:default is applied first)
   ["-h" "--help"]])

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
