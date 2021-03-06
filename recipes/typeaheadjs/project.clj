(defproject autocomplete "0.1.0-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [org.clojure/clojurescript "1.10.773"]
                 [reagent "1.0.0"]
                 [cljsjs/jquery "3.4.0-0"]
                 [cljsjs/typeahead-bundle "0.11.1-2"]]

  :source-paths ["src/clj"]

  :plugins [[lein-cljsbuild "1.1.8"]]

  :clean-targets ^{:protect false} ["resources/public/js/compiled" "target" "test/js"]

  :cljsbuild {:builds [{:id "dev"
                        :source-paths ["src/cljs"]
                        :compiler {:main "typeahead.core"
                                   :output-to "resources/public/js/compiled/app.js"
                                   :optimizations :none
                                   :pretty-print true}}
                       {:id "prod"
                        :source-paths ["src/cljs"]
                        :compiler {:output-to "resources/public/js/compiled/app.js"
                                   :optimizations :advanced
                                   :pretty-print false}}]})
