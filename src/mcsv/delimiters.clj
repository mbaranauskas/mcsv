(ns mcsv.delimiters)

(def delimiters (hash-map ";" ";"
                          "," ","
                          "\\t" "\t"))

(defn parse-delimiter
  [delimiter]
  (get delimiters delimiter))