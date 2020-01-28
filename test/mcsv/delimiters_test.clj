(ns mcsv.delimiters-test
  (:require [clojure.test :refer :all]
            [mcsv.delimiters :refer [parse-delimiter]]))

(deftest delimiter-from-command-should-map-to-symbol-test
  (testing "Delimiters"
    (is (= (parse-delimiter ",") ","))
    (is (= (parse-delimiter "\\t") "\t"))
    (is (= (parse-delimiter ";") ";"))))