# CORC Client Profile REST API

This project is responsible for handling CRUD and Business operations against CORC client Profile.

To build the project using maven,
	run : mvn clean install

To run the application on command line,
	run: java -jar commit-client-profile-api-0.0.1-SNAPSHOT.jar & 

Please use default HTTP headers Content-Type: application/json and Accept: application/json in ALL below REST endpoints.

## 1. Create new client profile

POST http://sv-bm-03.meganexus.internal:2103/client-profile-api/client-profile/

required HTTP REQUEST HEADERS:  X-Authorization: validTokenString

`REQUEST BODY
```json
{
  "id": 5,
  "profileId": "sandun22333",
  "partner": null,
  "firstname": "jorge22333",
  "surname": null,
  "dateOfBirth": null,
  "nhsId": null,
  "nhsNumberStatusIndicatorCode": null,
  "serviceAllocatedPatientId": null,
  "gender": null,
  "ethnicity": null,
  "religion": null,
  "addressLine01": null,
  "addressLine02": null,
  "addressLine03": null,
  "town": null,
  "county": null,
  "country": null,
  "postcode": null,
  "phoneNumber": null,
  "mobileNumber": null,
  "portalAccess": null,
  "username": null,
  "email": null
}
```

`RESPONSE BODY - 
response body will contain ClientProfile json object with an ID.

# 2. GET client profile JSON by Id

GET http://sv-bm-03.meganexus.internal:2103/client-profile-api/client-profile/{clientProfileId}

`RESPONSE BODY
```json
{
  "id": 5,
  "profileId": "sandun22333",
  "partner": null,
  "firstname": "jorge22333",
  "surname": null,
  "dateOfBirth": null,
  "nhsId": null,
  "nhsNumberStatusIndicatorCode": null,
  "serviceAllocatedPatientId": null,
  "gender": null,
  "ethnicity": null,
  "religion": null,
  "addressLine01": null,
  "addressLine02": null,
  "addressLine03": null,
  "town": null,
  "county": null,
  "country": null,
  "postcode": null,
  "phoneNumber": null,
  "mobileNumber": null,
  "portalAccess": null,
  "username": null,
  "email": null
}
```

# 3 GET all the client profiles

GET http://sv-bm-03.meganexus.internal:2103/client-profile-api/client-profile-repository

`RESPONSE BODY
```json
{
  "_embedded": {
    "profile-repository": [
      {
        "id": 5,
        "profileId": "sandun22333",
        "partner": null,
        "firstname": "jorge22333",
        "_links": {
          "self": {
            "href": "http://sv-bm-03.meganexus.internal:2103/client-profile-api/client-profile-repository/5"
          },
          "clientProfile": {
            "href": "http://sv-bm-03.meganexus.internal:2103/client-profile-api/client-profile-repository/5"
          }
        }
      },
      {
        "id": 15,
        "profileId": "sandun223331111111",
        "partner": null,
        "firstname": "jorge22331111113",
        "_links": {
          "self": {
            "href": "http://sv-bm-03.meganexus.internal:2103/client-profile-api/client-profile-repository/15"
          },
          "clientProfile": {
            "href": "http://sv-bm-03.meganexus.internal:2103/client-profile-api/client-profile-repository/15"
          }
        }
      },
      {
        "id": 25,
        "profileId": "sandun2233fdfd",
        "partner": null,
        "firstname": "jorge22331dffsd13",
        "_links": {
          "self": {
            "href": "http://sv-bm-03.meganexus.internal:2103/client-profile-api/client-profile-repository/25"
          },
          "clientProfile": {
            "href": "http://sv-bm-03.meganexus.internal:2103/client-profile-api/client-profile-repository/25"
          }
        }
      }}
      }
    ]
  },
  "_links": {
    "self": {
      "href": "http://sv-bm-03.meganexus.internal:2103/client-profile-api/client-profile-repository"
    },
    "profile": {
      "href": "http://sv-bm-03.meganexus.internal:2103/client-profile-api/client-profile/client-profile-repository"
    }
  },
  "page": {
    "size": 20,
    "totalElements": 3,
    "totalPages": 1,
    "number": 0
  }
}
```

# 3 Update known Client Profile (http PUT)

PUT http://sv-bm-03.meganexus.internal:2103/client-profile-api/client-profile/875/update

required HTTP REQUEST HEADERS:  X-Authorization: validTokenString

`REQUEST BODY
```json
{
  "id" : 875,
  "profileId": "sanduxvbgbbhbbxn22333",
  "partner": null,
  "firstname": "jorgebbb22333",
  "surname": null
}
```

