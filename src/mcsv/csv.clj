(ns mcsv.csv
  (:require 
   [clojure-csv.core :as csv]
   [clojure.java.io :as io]))

(defn gen-fields []
  (map #(str "Gen_field_" %) (drop 1 (range))))

(defn header [csv-data]
  (concat 
   (first csv-data)
   (gen-fields)))

(defn csv-data->maps [csv-data]
  (map zipmap
       (repeat (header csv-data))
       (rest csv-data)))

(defn csv-file->maps [file-name delimiter]
  (with-open
   [reader (io/reader file-name)]
    (csv-data->maps
     (doall
      (csv/parse-csv reader :delimiter delimiter)))))