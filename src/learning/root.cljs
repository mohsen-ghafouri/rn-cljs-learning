(ns learning.root
  (:require
    ["react-native" :as rn]
    [reagent.core :as reagent]
    [learning.core :as core]))

(def app-registry rn/AppRegistry)
(defn react-component [value]
  (reagent/reactify-component value))
(defn register-component [name app-root]
  (.registerComponent
    app-registry
    name
    #(react-component app-root)))

(defn init []
  (register-component "RNCljsLearning" core/main))
