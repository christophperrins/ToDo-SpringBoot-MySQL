# Todo
  
### Operating System image: Ubuntu 18.04 LTS Minimal

Go to Google Cloud Platform

Then go to the console

On the left under 'Compute' hover over 'Compute Engine' then select VM instances

Click Create Instance

Change the boot disk to Ubuntu 18.04 LTS Minimal

Allow HTTP & HTTPS traffic

Select Management, Security, Disks, Networking, Sole Tenancy

Under networking edit the networ interfaces

In primary internal IP reserve a static IP address

Then click Create

### Database: MySQL

To get the database running first you will need to download the mysql-server 

`$ sudo apt-get update`

`$ sudo apt-get install -y mysql-server`

Next you will need to create a database called "TODO".
* Login to mysql
* Create the database

`$ sudo mysql`

`mysql> CREATE DATABASE TODO;`


The next step is to create a new user in mysql which has full access to the database
* Create a user in mysql
* Grant all privileges to user for database

`mysql> INSERT INTO mysql.user (User,Host,authentication_string,ssl_cipher,x509_issuer,x509_subject)
VALUES('admin','localhost',PASSWORD('admin'),'','','');`

`mysql> FLUSH PRIVILEGES;`

`mysql> GRANT ALL PRIVILEGES ON TODO.* to admin@localhost;`

`mysql> FLUSH PRIVILEGES;`

`mysql> exit`

### Backend: SpringBoot

To get this backend running you will first need to clone this repo down.

`$ sudo apt-get install -y git`

`$ sudo apt-get install -y maven`

`$ sudo apt-get install -y screen`

`$ git clone https://github.com/christophperrins/ToDo-SpringBoot-MySQL.git`


After that go into the cloned folder

`$ cd ToDo-SpringBoot-MySQL/`


Then build the files with maven

`$ mvn install`


Next create a new screen with

`$ screen -S backend`


Then run the following command to run the SpringBoot Server

`$ java -jar target/ToDo-ReactNative-v1.jar` 


Press CTRL+a then d to detach from the terminal screen


This will now run in the backround.


