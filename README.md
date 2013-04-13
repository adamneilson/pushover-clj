Pushover-Clj
============

A simple wrapper for sending messages to the Pushover API


## Usage

Simplest is to include this as a project dependency in project.clj

`[pushover-clj "0.1.0-SNAPSHOT"]`

Then in your project source 


    (:require [pushover-clj.core :as pushover] ) 
    
And...

    (pushover/send-message "your_api_token" "pushover_user_token" "A lovely message")
    
You can also add a title, URL etc.

    (send-message "your_api_token" "pushover_user_token" "This is a titled test msg with a URL" "My Title" "Click here" "http://www.junkey.com")

Not all API calls are covered yet but I'll hopefully get around to it soon.

## License

Copyright © 2013 Adam Neilson

Distributed under the Eclipse Public License, the same as Clojure.
