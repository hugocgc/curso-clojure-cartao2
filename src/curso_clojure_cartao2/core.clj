(ns curso-clojure-cartao2.core
  (:gen-class)
  (:require [curso-clojure-cartao2.components.storage :as comp-s]
            [curso-clojure-cartao2.controllers.client :as c-client]
            [curso-clojure-cartao2.controllers.credit-card :as c-credit-card]
            [curso-clojure-cartao2.controllers.transaction :as c-transaction]))

;;Create database and schema
(comp-s/create-database!)
(comp-s/create-database-schema!)

;;Representação dos dados do cliente (nome, cpf, email)
(c-client/client-by-id #uuid "859a3a40-7fa4-444b-abd5-cc47044baa53")

;;Representação dos dados do cartão (número, cvv, validade, limite)
(c-credit-card/credit-card-by-id #uuid "12eac593-ada1-4bab-9745-45b597d154ca")

;;Listagem de compras realizadas (data, valor, estabelecimento, categoria)
(c-transaction/transactions-by-credit-card #uuid "12eac593-ada1-4bab-9745-45b597d154ca")

;;Valor dos gastos agrupados por categoria
(c-transaction/transactions-grouped-by-category #uuid "12eac593-ada1-4bab-9745-45b597d154ca")

;;Cálculo do valor da fatura do mês (opcional)
(c-transaction/billing-statement-total-value 5 2021 #uuid "12eac593-ada1-4bab-9745-45b597d154ca")

;;Busca de compras pelo valor ou estabelecimento (opcional)
(c-transaction/transactions-by-merchant "Wursteria" #uuid "12eac593-ada1-4bab-9745-45b597d154ca")
(c-transaction/transactions-by-value 100M #uuid "12eac593-ada1-4bab-9745-45b597d154ca")
