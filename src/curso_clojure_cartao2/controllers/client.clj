(ns curso-clojure-cartao2.controllers.client
  (:require [curso-clojure-cartao2.components.storage :as storage]
            [curso-clojure-cartao2.models.client :as m-client]
            [curso-clojure-cartao2.db.client :as db-client]
            [curso-clojure-cartao2.mock-data :as md]))

(defn new-client!
  [name email cpf]
  (let [new-client (m-client/new-client name email cpf)]
    (db-client/add-client! new-client (storage/connection))))

(defn client-by-id
  [client-id]
  (->> (db-client/client-by-id client-id (storage/storage))
       ffirst))

;;(map #(let[{:keys [name email cpf]} %](new-client! name email cpf)) md/client-data)