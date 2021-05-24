(ns curso-clojure-cartao2.controllers.transaction
  (:require [curso-clojure-cartao2.components.storage :as storage]
            [curso-clojure-cartao2.logic :as logic]
            [curso-clojure-cartao2.models.transaction :as m-transaction]
            [curso-clojure-cartao2.db.transaction :as db-transaction]
            [curso-clojure-cartao2.db.credit-card :as db-credit-card]))

(defn new-transaction!
  [value category date merchant credit-card-id]
  (let [available-limit (ffirst (db-credit-card/available-limit credit-card-id (storage/storage)))
        new-transaction (m-transaction/new-transaction value category date merchant credit-card-id)]
    (if (logic/limit-available? new-transaction available-limit)
      (do
        (db-credit-card/update-available-limit! (- available-limit value) credit-card-id (storage/connection))
        (db-transaction/add-transaction! new-transaction (storage/connection)))
      (throw (AssertionError. "Limit not available for this transaction")))))

(defn transactions-by-credit-card
  [credit-card-id]
  (->> (db-transaction/transactions-by-credit-card credit-card-id (storage/storage))
       (map first)))

(defn transactions-grouped-by-category
  [credit-card-id]
  (group-by :transaction/category (transactions-by-credit-card credit-card-id)))

(defn billing-statement
  [month year credit-card-id]
  (->> (db-transaction/transactions-by-month-and-year month year credit-card-id (storage/storage))
       (map first)))

(defn billing-statement-total-value
  [month year credit-card-id]
  (-> (db-transaction/transactions-total-value-by-month-and-year month year credit-card-id (storage/storage))
      ffirst))

(defn transactions-by-merchant
  [merchant credit-card-id]
  (->> (db-transaction/transactions-by-merchant merchant credit-card-id (storage/storage))
       (map first)))

(defn transactions-by-value
  [value credit-card-id]
  (->> (db-transaction/transactions-by-value value credit-card-id (storage/storage))
       (map first)))

(transactions-by-value 10M #uuid "32978aff-b568-47ba-b56f-bf2a0f480f59")
