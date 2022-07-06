# Knowledge Application
 Project Description
-------------
This app is a simple implementation of a knowledge library, created using Spring and Hibernate frameworks, SQL database, REST principles and supports CRUD operations. All data is displayed to user in JSON format.

This app stores data about K-PACs and K-PAC Sets in a relational database managed by MySQL.

## Features :
Each knowledge pack can be included in several knowledge pack sets Each knowledge pack set can contain several knowledge packs

* create knowledge pack/knowledge pack set
* get list of knowledge packs/knowledge pack sets
* get knowledge pack/knowledge pack set by id
* remove knowledge pack/knowledge pack set by id

Technology Stack
-------------
- Java 11
- Spring (Core, Web, JdbcTemplate)
- MySQL
- Apache TomCat 9.0.50
- Maven

Instructions to run the project
-------------
1. Install IDE to your PC
2. Clone the project to your IDE (e.g. IntelliJ IDEA)
3. Install MySQL to your PC and create new MySQL connection
4. Create a schema and respective tables, and fill these tables with data by running the scripts placed in `schema.sql` and `data.sql` files in the `resources` directory.
5. Change parameters in db.properties: db.user, db.password for yours (they should match username and password from your MySQL connection)
6. Download Tomcat and add configuration in your IDE (for this project v9.0.50 was used)
7. You can now run this application by using a TomCat local server.
8. Use Postman and send GET/POST/PUT/DELETE requests
