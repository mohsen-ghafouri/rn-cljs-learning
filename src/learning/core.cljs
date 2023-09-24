(ns learning.core
  (:require
    ["react-native" :as rn]
    [reagent.core :as reagent]))

(def text (reagent/adapt-react-class (.-Text rn)))
(def safe-area-view (reagent/adapt-react-class (.-SafeAreaView rn)))
(defn main []
  (fn []
    [safe-area-view
     [text "Hello, World!"]]))
