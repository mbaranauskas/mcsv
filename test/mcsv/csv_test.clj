(ns mcsv.csv-test
  (:require [clojure.test :refer :all]
            [mcsv.csv :refer :all]))

(deftest parse-csv-file
  (testing "Parse csv file to map"
    (is 
     (= 
      (csv-file->maps "./dev-resources/sample-test.csv" \;) 
      '({"Name" "Petras", "Surname" "Petraitis", "Birth year" "2000"} 
       {"Name" "Jonas", "Surname" "Jonaitis", "Birth year" "2003"})))))