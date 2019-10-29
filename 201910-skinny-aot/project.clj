(defproject skinny-jar "1.0.0.rc1"
  ;; :dependencies [[clojurewerkz/propertied "1.3.0"]
  ;;                [com.taoensso/timbre "4.10.0" ]
  ;;                [org.clojure/clojure "1.10.1"]]

  :plugins [[lein-tools-deps "0.4.5"]
            [lein-aot-filter "0.1.0"]]
  :middleware [lein-tools-deps.plugin/resolve-dependencies-with-deps-edn]
  :lein-tools-deps/config {:config-files [:install :project]}
  :aot-include [#"rgm.*"]

  :jar-name "skinny-lein.jar"
  :source-paths ["src"]
  :aot :all
  :omit-source true
  :clean-targets ^{:protect false} ["target"]
  :main rgm.core)
