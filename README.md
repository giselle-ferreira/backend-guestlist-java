## About
Rest API developed with Java, Spring Boot and PostgreSQL.
<br/>

## Requests
`
GET /guests
`
+ Returns guest list.
```
curl --location 'http://localhost:8080/guests'
```
<br/>

`
POST /guests/create
`
+ Adds a new guest.
```
curl --location 'http://localhost:8080/guests/create' \
--header 'Content-Type: application/json' \
--data '{
    "name": "João Maranhão"
}'
```
<br/>

`
PUT /guests
`
+ Updates the name of a guest.
```
curl --location --request PUT 'http://localhost:8080/guests' \
--header 'Content-Type: application/json' \
--data '{
        "id": "5fbc11e7",
        "name": "GISELLE FERREIRa"
    }'
```
<br/>

`
DELETE /guests/{id}
`
+ Removes a guest.
```
curl --location --request DELETE 'http://localhost:8080/guests/ca5bdaa4'
```

<br/>

>## Technologies 🧰

<p align="left">
<img alt="Java" src="https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white" height="27" />  
<img alt="SpringBoot" src="https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white" height="27" />
</p>

<br/>

## 

<div align="center">
<p>Made with ❤️ by Giselle Ferreira.</p>
  <p>
    <a href="https://linkedin.com/in/giselleferreiras" target="_blank" >
      <img align="center" height="35" src="https://cdn-icons-png.flaticon.com/512/174/174857.png" alt="Giselle Ferreira Linkedin" />
    </a>
    <a href="https://instagram.com/giselletech" target="_blank" >
      <img align="center" height="35" src="https://upload.wikimedia.org/wikipedia/commons/thumb/a/a5/Instagram_icon.png/1200px-Instagram_icon.png" alt="Giselle Ferreira Instagram" />
    </a>
  </p>
</div>


