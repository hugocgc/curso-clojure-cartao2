(ns curso-clojure-cartao2.controllers.credit-card
  (:require [curso-clojure-cartao2.components.storage :as storage]
            [curso-clojure-cartao2.models.credit-card :as m-credit-card]
            [curso-clojure-cartao2.db.credit-card :as db-credit-card]
            [curso-clojure-cartao2.mock-data :as md]))

(defn new-credit-card!
  [number cvv expiry-date limit client-id]
    (let [new-credit-card (m-credit-card/new-credit-card number cvv expiry-date limit client-id)]
    (db-credit-card/add-credit-card! new-credit-card (storage/connection))))

(defn credit-card-by-id
  [credit-card-id]
  (-> (db-credit-card/credit-card-by-id credit-card-id (storage/storage))
      ffirst))

(defn credit-cards-by-client
  [client-id]
  (->> (db-credit-card/credit-cards-by-client client-id (storage/storage))
       (map first)))