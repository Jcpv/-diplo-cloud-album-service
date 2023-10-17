# -diplo-cloud-album-service
Final Modulo 2 : Microservicio de Albums

**Getting Started Project**

Implementation of Album microservice for the Pixup application.

# Deploy 
// TODO

# Test

Execute the next curl command to validate the deploy of the service.

    curl -X 'POST' \
    'http://localhost:8083/api/albums' \ 
    -H 'accept: application/json' \  
    -H 'Content-Type: application/json' \ 
    -d '{"nombre":"Disco X - Super exito" 
    }'


The expected result should looks like:

    '{"id":"652e237521f1c24664370b71",
    "nombre":"Disco X - Super exito"
    }'


# Reference Documentation
For further reference, please review the following sections:

    Official Apache Maven documentation
    Spring Boot Maven Plugin Reference Guide
    Create an OCI image
    Spring Web
    Spring Data MongoDB


# Guides

The following guides illustrate how to use some features concretely:

    Building a RESTful Web Service
    Serving Web Content with Spring MVC
    Building REST services with Spring
    Accessing Data with MongoDB




