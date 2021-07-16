# BitPanda_ECommerce Test automation Framework


We are using Selenium Hybrid Frameworks in the project

#Tech Stach:
- JAVA
- MAVEN
- TESTNG
- ExtentReport
- DDT (from properties files & Excel Sheet)
- Support all the kind of browsers
- Running over GitLab CI/CD


## Getting started

### Before using that framework locally you should have the following: 
- Must have MAVEN and JAVA installed
- Must have IntelliJ or Eclipse setup

_________
## Structure of Project:
### 1- src/main/java

#### Pages Package:
- contains classes for every web page in automation practice app and inside every page , there are list of the elemenets related to that page

#### Utilities Package:
##### Helper:
- Contains all the generic methods in java that are used inside the automation scripts

##### readprop:
- Contains method for reading from properties files

_________
### 2- src/test/java

#### tests Package:
* Contains test classes that are used for executing the test methods inside

#### RegisterAnAccount Class:
* Test class conntains all the test methods (test cases) with logging of every step , failure , success
* contains 4 test methods :
- Register An Account
- Add Item from Search
- Add Item from woman category
- Add Item from T-Shirts section
- Verify Item Is Deleted
- Verify User Can Checkout


#### TestBase:
* Contains the base class for defining which env I am testing against, browsers I am testing against and which variable I am calling such as ***Url***
_________
### 3- src/test/resources

#### Excel sheet:
* Contains all the locators of the all elements in every page I use for testing

#### config.properties:
* Contains general env variable like browser name , URL of the app, execution type

#### data.properties:
* Contains some test data I use for testing in the automation practice app
_________
### 4- extentconfig.xml

* Contains the configuration of the extent report that will be published after the automation run
_________
### 5- Generating Test Report

* Automation test report will be published autonatically after executing all the test cases inside (RegisterAnAccount) Test class . also that html report can be found in the root of the project under (Report.html)
* Also the screenshots of the failures will be saved inside (ScreenShot) folder
_________
## Executing & Running Tests
```
$ mvn clean test
```
_________
### 6- Running over CI/CD Tool

* Please refer to the below link which contains the same project running over Gitlab CI/CD and contains two stages (Build & Test)
https://gitlab.com/adelgamalmostafa/bitpandaecommerceautomation

##### 7-Running oer Azure Pipeline:

* <img width="1645" alt="Screen Shot 2021-07-16 at 10 51 53 PM" src="https://user-images.githubusercontent.com/66884373/126007282-d75dce70-701e-4888-a4fb-5cdf1150f7b6.png">
* <img width="1680" alt="Screen Shot 2021-07-16 at 10 53 29 PM" src="https://user-images.githubusercontent.com/66884373/126007407-061c7812-c768-463e-bcfc-079f47bf945a.png">
* <img width="1656" alt="Screen Shot 2021-07-16 at 10 54 45 PM" src="https://user-images.githubusercontent.com/66884373/126007522-e049bf6d-471c-47ff-9afa-d1d3cfedb5ec.png">

