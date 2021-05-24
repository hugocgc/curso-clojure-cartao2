(ns curso-clojure-cartao2.db.transaction
  (:require [datomic.api :as d]))

(defn add-transaction!
  [new-transaction connection]
    (d/transact connection [new-transaction]))

(defn transactions-by-credit-card
  [credit-card-id storage]
  (d/q '[:find (pull ?entity [:transaction/id
                              :transaction/value
                              :transaction/category
                              :transaction/date
                              :transaction/merchant])
         :in $ ?credit-card-id
         :where [?credit-card :credit-card/id ?credit-card-id]
                [?entity :transaction/credit-card ?credit-card]]
       storage credit-card-id))

(defn transactions-by-month-and-year
  [month year credit-card-id storage]
  (d/q '[:find (pull ?entity [:transaction/id
                              :transaction/value
                              :transaction/category
                              :transaction/date
                              :transaction/merchant])
         :in $ ?month ?year ?credit-card-id
         :where [?credit-card :credit-card/id ?credit-card-id]
                [?entity :transaction/credit-card ?credit-card]
                [?entity :transaction/date ?transaction-date]
                [(#(= (.getYear %1) %2) ?transaction-date ?year)]
                [(#(= (.getMonth %1) %2) ?transaction-date ?month)]]
       storage (- month 1) (- year 1900) credit-card-id))

(defn transactions-total-value-by-month-and-year
  [month year credit-card-id storage]
  (d/q '[:find (sum ?transaction-value)
         :in $ ?month ?year ?credit-card-id
         :where [?credit-card :credit-card/id ?credit-card-id]
                [?entity :transaction/credit-card ?credit-card]
                [?entity :transaction/date ?transaction-date]
                [(#(= (.getYear %1) %2) ?transaction-date ?year)]
                [(#(= (.getMonth %1) %2) ?transaction-date ?month)]
                [?entity :transaction/value ?transaction-value]]
       storage (- month 1) (- year 1900) credit-card-id))

(defn transactions-by-merchant
  [merchant credit-card-id storage]
  (d/q '[:find (pull ?entity [:transaction/id
                              :transaction/value
                              :transaction/category
                              :transaction/date
                              :transaction/merchant])
         :in $ ?merchant ?credit-card-id
         :where [?credit-card :credit-card/id ?credit-card-id]
                [?entity :transaction/credit-card ?credit-card]
                [?entity :transaction/merchant ?merchant]]
       storage merchant credit-card-id))

(defn transactions-by-value
  [value credit-card-id storage]
  (d/q '[:find (pull ?entity [:transaction/id
                              :transaction/value
                              :transaction/category
                              :transaction/date
                              :transaction/merchant])
         :in $ ?value ?credit-card-id
         :where [?credit-card :credit-card/id ?credit-card-id]
                [?entity :transaction/credit-card ?credit-card]
                [?entity :transaction/value ?value]]
       storage value credit-card-id))