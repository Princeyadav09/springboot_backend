Project Setup:

	Java version- 17
	
Database Setup:

	I have attached the live database URL from the opensource platform (neon)
	or
	Create a new database in Postgres and replace the credentials where needed.
  	spring.datasource.url=jdbc:postgresql://localhost:your_port/database_name
	spring.datasource.username=your_username
	spring.datasource.password=your_password


Project Run:

	I am providing the deployed link(it may take some time to load as it is on free platform):
 
 	https://new-img2.onrender.com/swagger-ui/index.html#/
  
	Or
 
	Simply run the spring boot application on the default port 8080.

	  Access first endpoint on :
	  POST : http://localhost:8080/api/training-centers
	  Body: {
	   {
	    "centerName": "new-center",
	    "centerCode": "a12345678978",
	    "address": {
	         "city": "kanpur"
	    },
	    "coursesOffered": ["a1","a2"],
	    "email": "your@gmail.com",
	    "contactPhone": "1234567890"
	  }
	  
	  The second endpoint on:
	  GET : http://localhost:8080/api/training-centers
	  Or using the query parameter 
	  GET : http://localhost:8080/api/training-centers?centerName=p&centerCode=a12345678978&createdOn=1714131702
	  
	  
