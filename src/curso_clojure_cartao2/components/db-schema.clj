(ns curso-clojure-cartao2.components.db-schema)

(def schema [;;Client schema
             {:db/ident :client/id
              :db/valueType :db.type/uuid
              :db/cardinality :db.cardinality/one
              :db/unique :db.unique/identity
              :db/doc "Client's identifier"}
             {:db/ident :client/name
              :db/valueType :db.type/string
              :db/cardinality :db.cardinality/one
              :db/doc "Client's full name"}
             {:db/ident :client/email
              :db/valueType :db.type/string
              :db/cardinality :db.cardinality/one
              :db/unique :db.unique/value
              :db/doc "Client's email"}
             {:db/ident :client/cpf
              :db/valueType :db.type/string
              :db/cardinality :db.cardinality/one
              :db/unique :db.unique/value
              :db/doc "Client's CPF number"}

             ;;Credit card schema
             {:db/ident :credit-card/id
              :db/valueType :db.type/uuid
              :db/cardinality :db.cardinality/one
              :db/unique :db.unique/identity
              :db/doc "Credit card's identifier"}
             {:db/ident :credit-card/number
              :db/valueType :db.type/string
              :db/cardinality :db.cardinality/one
              :db/unique :db.unique/value
              :db/doc "Credit card's number"}
             {:db/ident :credit-card/cvv
              :db/valueType :db.type/string
              :db/cardinality :db.cardinality/one
              :db/doc "Credit card's CVV"}
             {:db/ident :credit-card/expiry-date
              :db/valueType :db.type/instant
              :db/cardinality :db.cardinality/one
              :db/doc "Credit card's expiry date"}
             {:db/ident :credit-card/available-limit
              :db/valueType :db.type/bigdec
              :db/cardinality :db.cardinality/one
              :db/doc "Credit card's current available limit value"}
             {:db/ident :credit-card/total-limit
              :db/valueType :db.type/bigdec
              :db/cardinality :db.cardinality/one
              :db/doc "Credit card's total limit value"}
             {:db/ident :credit-card/client
              :db/valueType :db.type/ref
              :db/cardinality :db.cardinality/one
              :db/doc "Owner of the credit Card"}

             ;;transactions schema
             {:db/ident :transaction/id
              :db/valueType :db.type/uuid
              :db/cardinality :db.cardinality/one
              :db/unique :db.unique/identity
              :db/doc "Transaction's identifier"}
             {:db/ident :transaction/value
              :db/valueType :db.type/bigdec
              :db/cardinality :db.cardinality/one
              :db/doc "Transaction's value"}
             {:db/ident :transaction/category
              :db/valueType :db.type/keyword
              :db/cardinality :db.cardinality/one
              :db/doc "Category of the transaction"}
             {:db/ident :transaction/date
              :db/valueType :db.type/instant
              :db/cardinality :db.cardinality/one
              :db/doc "Date of the transaction"}
             {:db/ident :transaction/merchant
              :db/valueType :db.type/string
              :db/cardinality :db.cardinality/one
              :db/doc "Merchant responsible for the transaction"}
             {:db/ident :transaction/credit-card
              :db/valueType :db.type/ref
              :db/cardinality :db.cardinality/one
              :db/doc "Credit card used in the transaction"}])

