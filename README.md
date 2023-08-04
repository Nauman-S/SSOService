# SSOService (Work in Progress)


## `Running project`
0). Optional but recommended to set a new password for mongodb in Persistence/Dockerfile

1). `docker compose up -d` starts it

2). `docker compose down` stops it


## `Connecting to mongo`
1). `docker ps` and note the container id of image ssoservice-persistence

2). `docker exec -it *container-id* /bin/bash` to connect to the container

3). `mongosh -u root -p *password*` to connect to shell. 
