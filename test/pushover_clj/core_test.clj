(ns pushover-clj.core-test
  (:use clojure.test
        pushover-clj.core))

(deftest basic-test
  (testing "Sending a basic push."
    (is (= 200 (send-message "xxxxxtokenxxxxx" "xxxxxuserxxxxxx" "This is a test msg")))
    (is (= 200 (send-message "xxxxxtokenxxxxx" "xxxxxuserxxxxxx" "This is a titled test msg" "My Title")))
    (is (= 200 (send-message "xxxxxtokenxxxxx" "xxxxxuserxxxxxx" "This is a titled test msg with a URL" "My Title" "Click here" "http://www.junkey.com")))
    ))

(deftest urgent-test
  (testing "Sending a basic push."
    (is (= 200 (send-urgent-message "xxxxxtokenxxxxx" "xxxxxuserxxxxxx" "This is an URGENT message test ")))
  ))
