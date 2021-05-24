(ns curso-clojure-cartao2.models.transaction
  (:require [curso-clojure-cartao2.logic :as logic]))

(defn new-transaction
  [value category date merchant credit-card-id]
  {:transaction/id (logic/new-uuid)
   :transaction/value value
   :transaction/category category
   :transaction/date date
   :transaction/merchant merchant
   :transaction/credit-card [:credit-card/id credit-card-id]})
