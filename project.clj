(defproject org.clojure/core.match "0.3.0-alpha4-SNAPSHOT"
  :description "Optimized pattern matching for Clojure"

  :jvm-opts ^:replace ["-Xmx512m" "-server"]

  :test-paths ["src/test/clojure"]
  :source-paths ["src/main/clojure"]

  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/tools.analyzer.jvm "0.6.5"]
                 [org.clojure/clojurescript "0.0-2496" :scope "provided"]
                 [org.clojure/core.match "0.3.0-alpha4"]]

  :plugins [[lein-cljsbuild "1.0.4-SNAPSHOT"]
            [cider/cider-nrepl "0.14.0"]]

  :cljsbuild
  {:builds
   [{:id "test"
     :source-paths ["src/test/cljs"]
     :compiler {:output-to "out/test.js"
                :static-fns true
                :optimizations :simple}}
    {:id "test-adv"
     :source-paths ["src/test/cljs"]
     :compiler {:output-to "out/test.js"
                :optimizations :advanced}}]})
