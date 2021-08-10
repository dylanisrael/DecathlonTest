# Test Framework

**This is a Template for the automated _BDD_ tests with Cucumber using _page object pattern_ and _maven command line
tool_ as test launcher**
![test automation](https://www.indiumsoftware.com/blog/wp-content/uploads/2020/01/10-Selenium-Test-Automation-Best-Practices.jpg)

## Getting Started 🏁

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.  
See deployment for notes on how to deploy the project on a live system.

### Prerequisites 📌

* [Java 8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
* [Maven 3](https://maven.apache.org/download.cgi)
* [Git](https://git-scm.com/downloads)
* [Gecko driver](https://github.com/mozilla/geckodriver/releases)
* [Chrome driver](https://sites.google.com/a/chromium.org/chromedriver/downloads)

### Installing 💿

Go to
[pom.xml](pom.xml) install maven dependencies and change **_ProjectName_** in ```<artifactId>ProjectName</artifactId>``` and `<projectName>ProjectName</projectName>` with your current project name.

Go to
[testng.xml](testng.xml) and replace **_projectName_** in```<suite name="ProjectName"...>``` with your current project name.


### Usage 💡

Firstly you need to add the webdrivers executables in [local_driver](local_driver).

####### [config.properties](config/config.properties)
allows you to change thimgs like the `browser`and the `device`
####### [urls.properties](config/urls.properties)
allows you to change and manage your `environments`

***********
hope this will be useful for you 😉
*****************




