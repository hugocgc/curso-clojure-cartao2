(ns curso-clojure-cartao2.mock-data)

(def client-data [{:name  "Fulano de Tal"
                   :cpf   "12345600000"
                   :email "fulano@gmail.com"}
                  {:name  "Maria de Tal"
                   :cpf   "55345600000"
                   :email "maria@lala.com"}
                  {:name  "José Silva"
                   :cpf   "99345600000"
                   :email "jose@uol.com"}])

;;change to client-id to valid idd
(def credit-card-data [{:number "0000000000000001"
                        :cvv         "123"
                        :expiry-date #inst "2027-03-31"
                        :limit       3000M
                        :client-id   #uuid "18cf5d42-70e5-4f24-bfa1-a60140ebc6c3"}
                       {:number "0000000000000002"
                        :cvv         "234"
                        :expiry-date #inst "2024-01-31"
                        :limit       1000M
                        :client-id   #uuid "50bcc040-48ae-4b7e-b75e-985399935806"}
                       {:number "0000000000000003"
                        :cvv         "235"
                        :expiry-date #inst "2025-03-31"
                        :limit       2000M
                        :client-id   #uuid "50bcc040-48ae-4b7e-b75e-985399935806"}
                       {:number "0000000000000004"
                        :cvv         "999"
                        :expiry-date #inst "2027-04-30"
                        :limit       4000M
                        :client-id   #uuid "18cf5d42-70e5-4f24-bfa1-a60140ebc6c3"}
                       {:number "0000000000000005"
                        :cvv         "432"
                        :expiry-date #inst "2027-03-30"
                        :limit       3000M
                        :client-id   #uuid "859a3a40-7fa4-444b-abd5-cc47044baa53"}
                       {:number "0000000000000006"
                        :cvv         "123"
                        :expiry-date #inst "2030-09-30"
                        :limit       10000M
                        :client-id   #uuid "18cf5d42-70e5-4f24-bfa1-a60140ebc6c3"}])

(def transaction-data[{:date #inst "2021-05-03"
                       :value 30M
                       :merchant "Wursteria"
                       :category :food
                       :credit-card-id #uuid "12eac593-ada1-4bab-9745-45b597d154ca"}
                      {:date #inst "2021-05-03"
                       :value 100M
                       :merchant "Drogarias Pacheco"
                       :category :health
                       :credit-card-id #uuid "12eac593-ada1-4bab-9745-45b597d154ca"}
                      {:date #inst "2021-05-04"
                       :value 1M
                       :merchant "Casa do Biscoito"
                       :category :grocery
                       :credit-card-id #uuid "1e224650-96e3-474e-911e-293c4f65236b"}
                      {:date #inst "2021-05-04"
                       :value 73M
                       :merchant "Supermercado Guanabara"
                       :category :grocery
                       :credit-card-id #uuid "c47ed7cc-3811-436d-beb6-9b112371e389"}
                      {:date #inst "2021-05-05"
                       :value 99M
                       :merchant "Supermercado Guanabara"
                       :category :grocery
                       :credit-card-id #uuid "deee94c6-ddcf-4e59-b566-4ebbae9f3b4e"}
                      {:date #inst "2021-05-06"
                       :value 300M
                       :merchant "Dominos"
                       :category :food
                       :credit-card-id #uuid "deee94c6-ddcf-4e59-b566-4ebbae9f3b4e"}
                      {:date #inst "2021-05-06"
                       :value 12M
                       :merchant "DragaRaia"
                       :category :health
                       :credit-card-id #uuid "32978aff-b568-47ba-b56f-bf2a0f480f59"}
                      {:date #inst "2021-05-10"
                       :value 10M
                       :merchant "China in Box"
                       :category :food
                       :credit-card-id #uuid "32978aff-b568-47ba-b56f-bf2a0f480f59"}
                      {:date #inst "2021-05-10"
                       :value 15M
                       :merchant "Casa do Biscoito"
                       :category :grocery
                       :credit-card-id #uuid "12eac593-ada1-4bab-9745-45b597d154ca"}])
