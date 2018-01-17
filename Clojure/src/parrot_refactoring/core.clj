(ns parrot-refactoring.core)

(def ^:private load-factor 9.0)

(def ^:private base-speed 12.0)

(defn- compute-base-speed-for-voltage [voltage]
  (min 24.0 (* voltage base-speed)))

(defrecord EuropeanParrot [])
(defrecord AfricanParrot [num-coconuts])
(defrecord NorwegianBlueParrot [voltage nailed])

(defmulti speed class)

(defmethod speed EuropeanParrot [parrot]
  base-speed)

(defmethod speed AfricanParrot [parrot]
  (max 0.0 (- base-speed (* load-factor (:num-coconuts parrot)))))

(defmethod speed NorwegianBlueParrot [parrot]
(if (:nailed parrot)
     0.0
     (compute-base-speed-for-voltage (:voltage parrot))))

(defmethod speed :default [parrot]
  (throw (Exception. "Should be unreachable!")))
