# ping-check-clj

ping-check-clj is an open source study material that makes it easy to test for deploying kubenetes.


### Download and Install

0. lein new luminus ping-check-clj +http-kit +mongodb +auth +swagger

1. lein run 

2. you can connect swagger url -> localhost:3000/swagger-ui


### Distributions

0. lein uberjar

1. sudo docker build -t ping-image .

2. ted@air ~/b/p/ping-check-clj> sudo docker run -it --rm -p 3000:3000 --name ping-container ping-image
