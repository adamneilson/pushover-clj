(ns pushover-clj.core
   (:require [clj-http.client :as http] )  
  )


(defn send-message [ token user message & [title url-title url device]]  
  
  ;; Send form params as a urlencoded body (POST or PUT)
     (let [result (http/post "https://api.pushover.net/1/messages.json" 
          {
             ;:debug true
             ;:debug-body true
             :content-type "application/x-www-form-urlencoded"
             :form-params {
                           :token token 
                           :user user 
                           :title title
                           :message message
                           :device device
                           :url_title url-title
                           :url url
                           }
            }
          )
        ]
        (:status result) 
      )
  )

(defn send-urgent-message [token user message]
  
  ;; Send form params as a urlencoded body (POST or PUT)
    (let [result (http/post "https://api.pushover.net/1/messages.json" {
             ;:debug true
             ;:debug-body true
             :content-type "application/x-www-form-urlencoded"
             :form-params {
                          :token token 
                          :user user 
                          :message message
                          :priority 2
                          :expire 3600
                          :retry 60
                          }
             }
             )
        ]
        (:status result) 
      )
  )

