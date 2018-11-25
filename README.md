# Weatherfrog
Weatherfrog is a Simple Weather Application with Java EE and a html output.

To start the application, clone the git project
```bash
git clone https://github.com/m3yco/Weatherfrog.git
```

to configure your city uses the path and change the variable "city=[NAME]"

```bash
Weatherfrog\weatherfrog\webapp\src\main\java\de\fh\albsig\milazzdo\web\WeatherServlet.java
```

then add in the cities.properties file to your city

```bash
Weatherfrog\weatherfrog\weather\src\main\resources\cities.properties
[NAME]=select * from weather.forecast where u \= 'c' and woeid in (select woeid from geo.places where text \= '[NAME]')
```

Then you have to go into the folder Weatherfrog and build the project
```bash
mvn clean install
```
Then each module needs to be prepared for Eclipse with
```bash
mvn eclipse:clean eclipse:eclipse
```

When you have problems in Eclipse, then update the project
```bash
mvn clean install -U
```

Then you go to the folder webapp and start the Jetty plugin
```bash
mvn jetty:run
```
Then you open the browser and enter the following URL http://localhost:8080/webapp/start
