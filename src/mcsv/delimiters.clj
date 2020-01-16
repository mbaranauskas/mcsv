(ns mcsv.delimiters)

(def delimiters (hash-map ";" :semicolon
                          "," :comma
                          "\\t" :tab))

(defn parse-delimiter
  [delimiter]
  (get delimiters delimiter))