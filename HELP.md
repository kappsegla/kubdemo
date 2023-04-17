Build this application
docker build --tag spring-boot-kube .

Deploy application, make sure to comment out HorizontalPodAutoscaler
kubectl apply -f deployment.yaml

Readiness and Liveness Probe
https://medium.com/codeops/kubernetes-readiness-and-liveness-probe-in-spring-boot-application-6214274b0dfd

Show that service pod is running
kubectl get pods
kubectl get po -A

Scale up to 3 running pods of our stateless server
kubectl scale --replicas=3 deployment/spring-test-app

kubectl describe node

Metrics service, use the edited file called components.yaml downloaded from:
https://github.com/kubernetes-sigs/metrics-server/releases/latest/download/components.yaml
and added:
    spec:
    containers:
    - args:
      - --kubelet-insecure-tls
kubectl apply -f components.yaml

kubectl get hpa
kubectl get hpa --watch

kubectl top node
https://www.kubecost.com/kubernetes-autoscaling/kubernetes-hpa/
https://kubernetes.io/docs/tasks/run-application/horizontal-pod-autoscale-walkthrough/
Apply hpa.yaml  (namespace kube-system if started from intellij)
kubectl get hpa -n kube-system

Rolling updates
https://kubernetes.io/docs/tutorials/kubernetes-basics/update/update-intro/

//Ingress on Docker desktop we need to install controller first.
kubectl apply -f https://raw.githubusercontent.com/kubernetes/ingress-nginx/controller-v1.7.0/deploy/static/provider/cloud/deploy.yaml
https://docs.nginx.com/nginx-ingress-controller/intro/how-nginx-ingress-controller-works/

Dashboard
https://kubernetes.io/docs/tasks/access-application-cluster/web-ui-dashboard/
