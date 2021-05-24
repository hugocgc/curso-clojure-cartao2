(ns curso-clojure-cartao2.db.credit-card
  (:require [datomic.api :as d]))

(defn add-credit-card!
  [new-credit-card connection]
  (d/transact connection [new-credit-card]))

(defn update-available-limit!
  [new-available-limit credit-card-id connection]
  (d/transact connection [[:db/add
                           [:credit-card/id credit-card-id]
                           :credit-card/available-limit new-available-limit]]))

(defn credit-card-by-id
  [credit-card-id storage]
  (d/q '[:find (pull ?entity [:credit-card/id
                              :credit-card/number
                              :credit-card/cvv
                              :credit-card/expiry-date
                              :credit-card/available-limit
                              :credit-card/total-limit
                              {:credit-card/client [:client/id]}])
         :in $ ?credit-card-id
         :where [?entity :credit-card/id ?credit-card-id]]
       storage credit-card-id))

(defn credit-cards-by-client
  [client-id storage]
  (d/q '[:find (pull ?entity [:credit-card/id
                              :credit-card/number
                              :credit-card/available-limit])
         :in $ ?client-id
         :where [?client :client/id ?client-id]
                [?entity :credit-card/client ?client]]
       storage client-id))

(defn available-limit
  [credit-card-id storage]
  (d/q '[:find ?available-limit
         :in $ ?credit-card-id
         :where [?entity :credit-card/id ?credit-card-id]
                [?entity :credit-card/available-limit ?available-limit]]
         storage credit-card-id))