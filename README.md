#Docker steps
    
   ##Build and push
   - step 1: ./mvnw install dockerfile:build -Dimage.tag=dev
       - result: repository/image_name:tag  -> regissantana/spring-example:dev
   - step 2:  docker login
   - step 3: ./mvnw dockerfile:push
    
   ##Pull and run (local or server)
   - step 1:  docker login
   - step 2:  docker run -d -e "SPRING_PROFILES_ACTIVE=dev" -p 6080:8080 regissantana/spring-example:dev
       - 6080 is the exposed port and 8080 is the internal port  
   - step 3:  docker logs 40591d4a501e
       - 40591d4a501e is the CONTAINER ID
       
   ##Running with compose (aws-Lightsail)
   - step 1:  cd opt/projects/spring-example/src/main/resources
   - step 1:  docker login
   - step 1:  docker pull regissantana/spring-example:dev
   - step 2:  TAG=dev docker-compose up -d
   
   
####Commands
- kill all containers 
    - docker kill $(docker ps -q)

