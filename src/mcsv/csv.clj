(ns mcsv.csv
  (:require 
   [clojure-csv.core :as csv]
   [clojure.java.io :as io]))

(defn csv-data->maps [csv-data]
  (map zipmap
       (repeat (first csv-data))
       (rest csv-data)))

(defn csv-file->maps [file-name delimiter]
  (with-open
   [reader (io/reader file-name)]
    (csv-data->maps
     (doall
      (csv/parse-csv reader :delimiter delimiter)))))