(ns curso-clojure-cartao2.db.client
  (:require [datomic.api :as d]))

(defn add-client!
  [new-client connection]
  (d/transact connection [new-client]))

(defn client-by-id
  [client-id storage]
  (d/q '[:find (pull ?entity [:client/id
                              :client/name
                              :client/email
                              :client/cpf])
         :in $ ?client-id
         :where [?entity :client/id ?client-id]]
       storage client-id))