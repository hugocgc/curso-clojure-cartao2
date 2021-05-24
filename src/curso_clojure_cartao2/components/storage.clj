(ns curso-clojure-cartao2.components.storage
  (:require [datomic.api :as d])
  (:require [curso-clojure-cartao2.config :as config])
  (:require [curso-clojure-cartao2.components.db-schema :as comp-dbs]))

(defn create-database!
  []
  (d/create-database config/db-uri))

(defn connection
  []
  (d/connect config/db-uri))

(defn create-database-schema!
  []
  (-> (connection)
      (d/transact comp-dbs/schema)))

(defn storage
  []
  (d/db (connection)))
