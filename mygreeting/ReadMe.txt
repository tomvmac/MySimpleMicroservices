# mygreeting service returns a greeting based on the following urls
/greet/name/tom
/greet/name/kobe

----------------------------------------------------------------------------------------------------


Spring Boot Stuff:

Run spring boot app locally:
cd into {project}\target folder
java -jar mygreeting-0.0.1-SNAPSHOT

------------------------------------------------------------------------------------------------
Docker Stuff


Run Docker Image locally:

Build Dockerfile:
cd into {project} folder
docker build -t mygreeting .

Run Docker:
docker run -p 8081:8081 mygreeting

Publish Docker Image:
docker login

Tag Image: 
docker tag mygreeting tomvmac/mygreeting:1

Push to Docker Hub:
docker push tomvmac/mygreeting:1

Pull from Docker Hub:
docker pull tomvmac/mygreeting:1

Run Image from Docker Hub:
docker run -p 8081:8081 tomvmac/mygreeting

------------------------------------------------------------------------------------------------

Run service in Kubernetes:
cd into kubernets folder

kubectl apply -f services.yaml
kubectl apply -f workloads.yaml

Go to browser and view http://192.168.99.101:30081/greet/name/kobe