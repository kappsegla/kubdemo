Build this application
docker build --tag spring-boot-kube:v1 .

Deploy application
kubectl apply -f deploymentA.yaml

Show deployed apps in default namespace
kubectl get deployments
Show deployed apps in all namespaces
kubectl get deployments -A

Show pods
kubectl get pods
kubectl get po -A

Show more detailed information about our deployment
kubectl describe deployment spring-app

Using a service to expose our app
kubectl apply -f serviceA.yaml

Show services
kubectl get services
kubectl describe services spring

Open the service in browser
http://localhost:8080/

Scale up to 3 running pods of our stateless server
kubectl scale --replicas=3 deployment/spring-app

Show how many pods are running
kubectl get deployments
kubectl get pods

Test calling the service from two browsers and see that they might get responses from different pods

Scale down
kubectl scale --replicas=2 deployment/spring-app
----
Update our deployments
https://www.baeldung.com/linux/deployment-rollout-kubernetes

Create new version of our code and build
docker build --tag spring-boot-kube:v2 .

Check rollout status
kubectl rollout history deployment spring-app
kubectl rollout status deployments/spring-app

Rolling updates
https://kubernetes.io/docs/tutorials/kubernetes-basics/update/update-intro/

kubectl set image deployments/spring-app spring=spring-boot-kube:v2

Set Change-cause for our update
kubectl annotate deployment/spring-app kubernetes.io/change-cause="update image version from v1 to v2"

Check status
kubectl get pods

Undo rollout
kubectl rollout undo deployments/spring-app
----

Autoscaling, horizontally
We need a metrics service which isn't included in single node kubernetes
Metrics service, use the edited file called components.yaml downloaded from:
https://github.com/kubernetes-sigs/metrics-server/releases/latest/download/components.yaml
and add:
  spec:
    containers:
      - args:
        - --kubelet-insecure-tls

kubectl apply -f components.yaml
Start HorizontalPodAutoscaler
kubectl apply -f hpa.yaml

Watch the status
kubectl get hpa
kubectl get hpa --watch

kubectl top node
https://www.kubecost.com/kubernetes-autoscaling/kubernetes-hpa/
https://kubernetes.io/docs/tasks/run-application/horizontal-pod-autoscale-walkthrough/

Run Load application in src folder.

Clean up our cluster
kubectl delete deployments/spring-app services/spring 





//Ingress on Docker desktop we need to install controller first.
kubectl apply -f https://raw.githubusercontent.com/kubernetes/ingress-nginx/controller-v1.9.4/deploy/static/provider/cloud/deploy.yaml
https://docs.nginx.com/nginx-ingress-controller/intro/how-nginx-ingress-controller-works/

Dashboard
https://kubernetes.io/docs/tasks/access-application-cluster/web-ui-dashboard/
