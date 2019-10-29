(ns rgm.core
  (:gen-class)
  (:require [clojure.java.io :as io]
            [clojurewerkz.propertied.properties :as p]
            [taoensso.timbre :as timbre]))

(defn -main
  []
  (timbre/info "yep, we booted right, from a skinny jar")
  (timbre/info "Here's the system.properties file:"
               (-> "system.properties"
                   io/file
                   p/load-from
                   p/properties->map)))
