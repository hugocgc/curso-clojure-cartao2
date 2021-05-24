(ns curso-clojure-cartao2.config)

;;config feia assim mas é o que tem pra hoje
(def db-name "exercicio-cartao2")
(def db-uri (str "datomic:dev://localhost:4334/" db-name))