Functional Description
======================
Provides a dashboard to display number of free docks and bikes at  pre-configured set of citibike stations.  
The sets are specified in the `application.conf file`.

Technical Description
=====================
* Source Data: Citibike Station Feed, URL taken from https://www.citibikenyc.com/system-data, under "Additional Resources"
* Core parsing logic of source data in `src/main/java/explore/CitiBike`.  Only keep status if station is in the specified set.
* Expose result through an HTTP endpoint, `src/main/java/servlet/CitiServlet`
* Front End: Angular (```docks.html```) or React table (```docks-react.html```) on html page to pull JSON from my HTTP endpoint, and display status in a table. See src/webapp/docks.html

Deployment
==========
Setup for running on Heroku:
* Prepare build script, run with```mvn package```
* See startup script `Procfile`
* Launcher is in `src/main/java/launch`
