(ns ping-check-clj.handler
  (:require [compojure.core :refer [routes wrap-routes]]
            [ping-check-clj.layout :refer [error-page]]
            [ping-check-clj.routes.home :refer [home-routes]]
            [ping-check-clj.routes.services :refer [service-routes]]
            [compojure.route :as route]
            [ping-check-clj.env :refer [defaults]]
            [mount.core :as mount]
            [ping-check-clj.middleware :as middleware]))

(mount/defstate init-app
  :start ((or (:init defaults) identity))
  :stop  ((or (:stop defaults) identity)))

(mount/defstate app
  :start
  (middleware/wrap-base
    (routes
      (-> #'home-routes
          (wrap-routes middleware/wrap-csrf)
          (wrap-routes middleware/wrap-formats))
          #'service-routes
      (route/not-found
        (:body
          (error-page {:status 404
                       :title "page not found"}))))))
