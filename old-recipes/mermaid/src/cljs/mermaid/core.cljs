(ns mermaid.core
    (:require [reagent.core :as reagent]
              [reagent.dom :as rdom]))

(defn home []
  [:div [:h1 "Welcome to Reagent Cookbook!"]
  [:div.mermaid "sequenceDiagram
    participant Alice
    participant Bob
    Alice->>John: Hello John, how are you?
    loop Healthcheck
        John->>John: Fight against hypochondria
    end
    Note right of John: Rational thoughts <br/>prevail...
    John-->>Alice: Great!
    John->>Bob: How about you?
    Bob-->>John: Jolly good!"]
   ])

(defn home-did-mount []
  (.init js/mermaid))

(defn home-component []
  (reagent/create-class {:reagent-render home
                         :component-did-mount home-did-mount}))

(rdom/render [home-component]
             (.getElementById js/document "app"))
