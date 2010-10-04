Echo Java Server
================

A small Jetty Server to echo back header and parameter information useful for testing and debugging.

  * Allows status to be set via status parameter (status=500)
  * Allows content-type to be set via type parameter (type=text/plain)
  * Allows content to be set via echo parameter (echo=Hello%20World)

Usage
-----

Checkout from git 
  git clone http://github.com/pcorliss/Echo-Server

Build with ant (Optional, JAR is already included)
  ant

Run (Select an appropriate port number)
  java -jar echo.jar 8080

Open in a browser
  http://localhost:8080/
  http://localhost:8080/?status=200&type=text/plain&echo=Hello%20World
