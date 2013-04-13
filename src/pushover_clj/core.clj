(ns pushover-clj.core
   (:require [clj-http.client :as http] )  
  )


(defn send-message [ token user message & [title url-title url device]]  
  
  (try
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
             :throw-entire-message? true
             }
            }
          )
        ]
        (:status result)
      )
    (catch Exception e 
      ;send the status 
      (:status (:object (.getData e))) 
    )
  )
  )

(defn send-urgent-message [token user message & [title url-title url device]]
  
  (try
    (let [result (http/post "https://api.pushover.net/1/messages.json" {
                  ;:debug true
                  ;:debug-body true
                  :content-type "application/x-www-form-urlencoded"
                  :form-params {
                  :token token 
                  :user user 
                  :title title
                  :message message
                  :priority 2
                  :expire 3600
                  :retry 60
                  :url_title url-title
                  :url url
                  :throw-entire-message? true
                  }
             }
             )
        ]
        (:status result) 
      )
    (catch Exception e 
      ;send the status 
      (:status (:object (.getData e))) 
    )
  )
  )
