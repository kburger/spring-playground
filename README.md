spring-playground
=================
Run with ```mvn org.apache.tomcat.maven:tomcat7-maven-plugin:run```

App tries to connect to mongo using the default mongo settings (localhost om 27017)

POST to ```/auth/token``` to receive a token

GET all endpoints from /items or /notes with an ```x-token``` header containing the token
