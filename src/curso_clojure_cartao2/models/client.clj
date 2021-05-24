(ns curso-clojure-cartao2.models.client
  (:require [curso-clojure-cartao2.logic :as logic]))

(defn new-client
  [name email cpf]
  {:client/id (logic/new-uuid)
   :client/name name
   :client/email email
   :client/cpf cpf})