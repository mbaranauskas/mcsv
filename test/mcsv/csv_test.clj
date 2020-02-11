(ns mcsv.csv-test
  (:require [clojure.test :refer :all]
            [mcsv.csv :refer :all]))

(defn full-path [file-name]
  (str "./dev-resources/" file-name))

(deftest parse-csv-file
  (testing "Parse csv file to map"
    (is
     (= (csv-file->maps (full-path "sample-test.csv") \;)
        '({"Name" "Petras"
           "Surname" "Petraitis"
           "Birth year" "2000"}
          {"Name" "Jonas"
           "Surname" "Jonaitis"
           "Birth year" "2003"})))))

(deftest csv-missing-fields
  (testing "parse file with some records shorter than header"
    (is
     (= (csv-file->maps (full-path "incomplete-records.csv") \;)
        '({"Name" "Petras"
           "Surname" ""}
          {"Name" "Jonas"
           "Surname" "Jonaitis"
           "Birth year" ""})))))

(deftest csv-unexpected-fields
  (testing "handle records with more fields than header"
    (is
     (= (csv-file->maps (full-path "unexpected-fields.csv") \;)
        '({"Name" "Petras"
           "Surname" "Petraitis"
           "Birth year" "2000"}
          {"Name" "Jonas"
           "Surname" "Jonaitis"
           "Birth year" "2003"
           "Gen_field_1" "oops"
           "Gen_field_2" "it is unexpected"})))))