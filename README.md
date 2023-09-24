
## Setup

#### Initiate React native by [`@react-native-community/cli`](https://github.com/react-native-community/cli)

```bash
npx react-native init RNCljsLearning
```

#### Install [`shadow-cljs`](https://github.com/thheller/shadow-cljs)

```bash
cd RNCljsLearning
```

```bash
npm i -D shadow-cljs
```

#### Create `deps.edn` in the root of project with these content

```bash
{:deps  {org.clojure/clojure       {:mvn/version "1.11.1"}
         org.clojure/clojurescript {:mvn/version "1.11.54"}
         reagent/reagent           {:mvn/version "1.2.0"}}
 :paths ["src"]}
```

#### Create `shadow-cljs.edn` in the root of project with this content
```bash
{:source-paths ["src"]
 :dependencies [[reagent "1.2.0"]
                [re-frame "1.3.0"]]
 :builds       {:app
                {:target     :react-native
                 :init-fn    learning.root/init
                 :output-dir "app"
                 }}}
```

#### Create `core.cljs` file inside `src/learning` and add this content
```bash
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

```

#### Create `root.cljs` file inside `src/learning` and add this content

```bash
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
```

#### Now replace the `index.js` content with this
```bash
import './app/index';
```

#### Run app
Yeah almost done just need to run these commands in separate terminals

```bash
shadow-cljs watch app
```

and run the app for ios or android
```bash
npm run ios
```
#### Screenshot
<img src="https://github.com/mohsen-ghafouri/rn-cljs-learning/assets/71308738/1cc9aec4-1af6-4b64-b5f3-3035a0c7dc80" width="375px"/>
