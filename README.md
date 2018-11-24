# Weatherfrog
Weatherfrog is a Simple Weather Application with Java EE with a html output.

To start the application, clone the git project

git clone https://github.com/DonColon/Weatherfrog.git

Then you have to go into the folder Weatherfrog and build the project

mvn clean install

Then each module needs to be prepared for Eclipse with

mvn eclipse:clean eclipse:eclipse

Then you go to the folder webapp and start the Jetty plugin

mvn jetty:run

Then you open the browser and enter the following URL http://localhost:8080/weatherfrog/start
