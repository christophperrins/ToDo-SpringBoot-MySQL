# Todo

### Database: MySQL

To get the database running first you will need to download the mysql-server 

`$ sudo apt-get update`
`$ sudo apt-get install mysql-server`

Next you will need to create a database called "TODO".
* Login to mysql
* Create the database

`$ sudo mysql -u root -p`

Enter nothing as the password

`mysql> CREATE DATABASE TODO`


The next step is to create a new user in mysql which has full access to the database
* Create a user in mysql
* Grant all privileges to user for database

`mysql> INSERT INTO mysql.user (User,Host,authentication_string,ssl_cipher,x509_issuer,x509_subject)
VALUES('admin','localhost',PASSWORD('admin'),'','','');`

`mysql> FLUSH PRIVILEGES;`

`mysql> GRANT ALL PRIVILEGES ON TODO.* to admin@localhost;`

### Backend: SpringBoot

To get this backend running you will first need to clone this repo down.

`$ git clone https://github.com/christophperrins/ToDo-SpringBoot-MySQL.git`


After that go into the cloned folder

`$ cd ToDo-SpringBoot-MySQL/`


If maven isn't already downloaded, download it with 

`$ sudo apt-get install maven`

Then build the files with maven

`$ mvn install`


Then run the following command to run the SpringBoot Server

`$ java -jar target/ToDo-ReactNative-v1.jar` 
