(ns parrot-refactoring.core)

(def ^:private load-factor 9.0)

(def ^:private base-speed 12.0)

(defn- compute-base-speed-for-voltage [voltage]
  (min 24.0 (* voltage base-speed)))

(defn speedx [parrot]
  (case (:type parrot)
    :european-parrot base-speed
    :african-parrot (max 0.0 (- base-speed (* load-factor (:num-coconuts parrot))))
    :norwegian-blue-parrot (if (:nailed parrot)
                             0.0
                             (compute-base-speed-for-voltage (:voltage parrot)))
    (throw (Exception. "Should be unreachable!"))))

(defrecord EuropeanParrot [])
(defrecord AfricanParrot [num-coconuts])
(defrecord NorwegianBlueParrot [voltage nailed])

(defmulti speed class)

(defmethod speed EuropeanParrot [parrot]
  (speedx {:type :european-parrot}))

(defmethod speed AfricanParrot [parrot]
  (speedx {:type :african-parrot
          :num-coconuts (:num-coconuts parrot)}))

(defmethod speed NorwegianBlueParrot [parrot]
  (speedx {:type :norwegian-blue-parrot
                :voltage (:voltage parrot)
                :nailed (:nailed parrot)}))

(defmethod speed :default [parrot]
  (speedx {:type :unknown}))
