# RecruitingApplication

	Perquisites:
	Java 8 must be installed on the machine. Follow below steps if not installed.
	If not download it from https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html. If you have 64-bit Operating System, then use 64-bit version.
	Set the java environment variable. Follow the post  https://java.com/en/download/help/path.xml

	Installation Steps:
	code: This folder contains the codebase.
	bundle: This folder contains the runnable Recruiting Application.
•	run.bat file used for launching the Recruiting Application.
•	conf/application.properties file contains all the properties necessary for the application to start.(We have used externalized configuration.)
•	conf/logback.xml file contains the logging configuration. This file path is configurable in application.properties file.
•	lib/RecruitingApplication-0.0.1-SNAPSHOT.jar file contains our application compiled code.

Note: Currently, application will run on 8088 port number so make sure that no other application is running on this port. If you want different port, then edit the server.port property in conf/application.properties file.
	Running Application
	Use below URL to run the application in browser
•	Add Offer Endpoint : This endpoint will insert record in Offer Table.

 http://localhost:8088/RecruitingApplication/offers/
Request Method: POST

Request Body JSON
{
"jobTitle" : "Senior Software Enginner",
 "startDate" : "2020-01-23"  
}

Response Body JSON
{
 			"jobId": 1,
 			"jobTitle": "Senior Software Enginner",
  			"startDate": "2020-01-23T00:00:00.000+0000",
"numberOfApplications": 0,
 "applications": []
}

•	Get Offer EndPoint : This endpoint will get all offers from offer table.

http://localhost:8088/RecruitingApplication/offers/
Request Method: GET

Response Body JSON

[{
  		"jobId": 1,
  		"jobTitle": "Senior Software Enginner",
        		"startDate": "2020-01-23T00:00:00.000+0000",
        		"numberOfApplications": 0,
        		"applications": []
    	}]


•	Get Particular Offer Endpoint : This Endpoint will fetch particular job id from offer table.

http://localhost:8088/RecruitingApplication/offers/{offer_id}
Request Method: GET
Request Parameter:
offer_id: offer ID 

Response Body JSON

{
    "jobId": 1,
    "jobTitle": "Senior Software Enginner",
    "startDate": "2020-01-23T00:00:00.000+0000",
    "numberOfApplications": 0,
    "applications": []
}


•	Post Application Endpoint : This Endpoint will add application in application table bound with offer.

http://localhost:8088/RecruitingApplication/offers/{offer_id}/applications/
Request Method: POST
Request Parameter:
offer_id: offer ID 

Request Body JSON

{
    			"candidateEmail" : "test@test.com",
   			 "resumeText" : "Senior Software Enginner"
}

Response Body JSON 
{
    "applicationId": 2,
    "candidateEmail": "test@test.com",
    "resumeText": "Senior Software Enginner",
    "applicationStatus": "APPLIED"
}

•	Get All Applications EndPoint : This endpoint will get all application associated with particular offer id.

http://localhost:8088/RecruitingApplication/offers/{offer_id}/applications/
Request Method: GET
Request Parameter:
offer_id: offer ID 

Response Body JSON
[
    {
        "applicationId": 2,
        "candidateEmail": "test@test.com",
        "resumeText": "Senior Software Enginner",
        "applicationStatus": "APPLIED"
    }
]


•	Get Particular Application Endpoint : This Endpoint will fetch particular application associated with particular offer id.

http://localhost:8088/RecruitingApplication/offers/{offer_id}/applications/{application_id}
Request Method: GET
Request Parameter:
offer_id: offer ID 
application_id : Application ID

       Response Body JSON

{
    "applicationId": 2,
    "candidateEmail": "test@test.com",
    "resumeText": "Senior Software Enginner",
    "applicationStatus": "APPLIED"
}

•	PUT Application EndPoint : This Endpoint will allow to change Application status associated with particular offer id.

http://localhost:8088/RecruitingApplication/offers/{offer_id}/applications/{application_id}
Request Method: PUT
Request Parameter:
offer_id: offer ID 
application_id : Application ID

      Request Body JSON

{
    "candidateEmail" : "updated@test.com",
    "resumeText" : "Developer",
    "applicationStatus": "REJECTED"
}



     Response Body JSON

{
    "applicationId": 2,
    "candidateEmail": "updated@test.com",
    "resumeText": "Developer",
    "applicationStatus": "REJECTED"
}

•	Note : For Application Status Change Notification Added Log. Example : “############## Status of application#{application_id} changed to {updated_status}”

