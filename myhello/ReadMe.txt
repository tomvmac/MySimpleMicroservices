# The following will call mygreeting service to provide a greeting back to myhello service
/hello/tom
/hello/kobe  

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
docker build -t myhello .

Run Docker:
docker run -e "SPRING_PROFILES_ACTIVE=dev" -p 8080:8080 myhello

Publish Docker Image:
docker login

Tag Image: 
docker tag myhello tomvmac/myhello:1

Push to Docker Hub:
docker push tomvmac/myhello:1

Pull from Docker Hub:
docker pull tomvmac/myhello:1

Run Image from Docker Hub:
docker run -e "SPRING_PROFILES_ACTIVE=dev" -p 8080:8080 tomvmac/myhello


------------------------------------------------------------------------------------------------
Run service in Kubernetes:
cd into kubernets folder

kubectl apply -f services.yaml
kubectl apply -f workloads.yaml

Go to browser and view http://192.168.99.101:30080/hello/name/kobe