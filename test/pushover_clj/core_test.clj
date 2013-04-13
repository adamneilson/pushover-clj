(ns pushover-clj.core-test
  (:use clojure.test
        pushover-clj.core))

(def token "xxxxxtokenxxxxx")
(def user "xxxxxuserxxxxxx")

(deftest basic-test
  (testing "Sending a basic push."
    (is (= 200 (send-message token user "This is a test msg")))
    (is (= 200 (send-message token user "This is a titled test msg" "My Title")))
    (is (= 200 (send-message token user "This is a titled test msg with a URL" "My Title" "Click here" "http://www.junkey.com")))
    ))

(deftest urgent-test
  (testing "Sending a basic push."
    (is (= 200 (send-urgent-message token user "This is an URGENT message test")))
    (is (= 200 (send-urgent-message token user "This is an URGENT message test" "My URGENT Title")))
    (is (= 200 (send-urgent-message token user "This is an URGENT message test" "My URGENT Title" "Click here" "http://www.junkey.com")))
  ))

(deftest error-test
  (testing "Sending bad payloads."
    (is (= 400 (send-message "" user "This is a test bad req")))
    (is (= 400 (send-message token "" "This is a test bad req")))
    (is (= 400 (send-message "\u9898" "#737373" "This is a test bad req")))
  ))