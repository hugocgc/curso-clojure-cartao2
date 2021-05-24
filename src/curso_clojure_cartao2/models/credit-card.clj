(ns curso-clojure-cartao2.models.credit-card
  (:require [curso-clojure-cartao2.logic :as logic]))

(defn new-credit-card
  [number cvv expiry-date limit client-id]
  {:credit-card/id (logic/new-uuid)
   :credit-card/number number
   :credit-card/cvv cvv
   :credit-card/expiry-date expiry-date
   :credit-card/available-limit limit
   :credit-card/total-limit limit
   :credit-card/client [:client/id client-id]})