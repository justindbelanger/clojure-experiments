(ns rgm.core
  (:gen-class)
  (:require [clojure.java.io :as io]
            ;; [clojurewerkz.propertied.properties :as p]
            [reitit.core :as rc]
            [taoensso.timbre :as timbre]))

(def router
  (rc/router
   [["/api/ping" ::ping]
    ["/api/orders/:id" ::order]]))

(defn -main
  []
  (timbre/info "yep, we booted right, from a skinny jar")
  (timbre/info (rc/match-by-name router "/api/ping"))
  #_(timbre/info "Here's the system.properties file:"
                 (-> "system.properties"
                     io/file
                     p/load-from
                     p/properties->map)))
