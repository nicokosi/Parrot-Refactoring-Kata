(ns parrot-refactoring.core)

(def ^:private base-speed 12.0)
(def ^:private load-factor 9.0)
(def ^:private max-speed 24.0)

(defn- slowdown-due-coconuts [num-coconuts]
  (- base-speed (* load-factor num-coconuts)))

(defn- speed-for-voltage [voltage]
  (min max-speed (* voltage base-speed)))

(defrecord EuropeanParrot [])
(defrecord AfricanParrot [num-coconuts])
(defrecord NorwegianBlueParrot [voltage nailed])

(defmulti speed class)

(defmethod speed EuropeanParrot [parrot]
  base-speed)

(defmethod speed AfricanParrot [parrot]
  (max 0.0 (slowdown-due-coconuts (:num-coconuts parrot))))

(defmethod speed NorwegianBlueParrot [parrot]
  (if (:nailed parrot)
    0.0
    (speed-for-voltage (:voltage parrot))))

(defmethod speed :default [parrot]
  (throw (Exception. "Should be unreachable!")))
