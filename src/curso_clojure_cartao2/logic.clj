(ns curso-clojure-cartao2.logic)

(defn new-uuid
  []
  (java.util.UUID/randomUUID))

(defn parse-int
  [s]
  (Integer/parseInt (re-find #"\A-?\d+" s)))

(defn day
  [inst]
  (-> (java.text.SimpleDateFormat. "dd")
      (.format inst)
      parse-int))

(defn month
  [inst]
  (-> (java.text.SimpleDateFormat. "MM")
      (.format inst)
      parse-int))

(defn year
  [inst]
  (-> (java.text.SimpleDateFormat. "YYYY")
      (.format inst)
      parse-int))

(defn limit-available?
  [transaction limit-available]
  (<= (:transaction/value transaction) limit-available))
