# Applitools Hackathon

I have created this Hackathon project to participate in the Applitools Hackathon challenge. This project is based on Selenium WenDriver using Java language.

This README includes information about the project structure and instructions to execute both TraditionalTest and VisualAITests suites.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for evaluating my effort on this challenge.

### Technologies

* Selenium WebDriver v3.141.59 - for Web Based UI Automation Testing
* Applitool Eyes v3.157.10 - for Visual Testing
* Java JDK 11 - for Development
* Apache Maven v3.6.1 - as Build Tool
* TestNG v7.0.0 - as Test Runner
* Google Chrome v78.0.3904.108 - as Browser

### External Libraries Used

* Apache POI v4.0.1 - for reading test data from Excel sheet for Data Driven Testing
* AssertJ v3.12.1 - for implementing assertions in TraditionalTests.java

### Plugins

* Maven Compiler v3.8.0 - for compiling the project
* Maven FailSafe v2.22.0 - to execute tests with specified configurations and goals
* Selenium driver binary downloader maven plugin v1.0.17 - to automatically download the WebDriver stand alone server binaries

## Project Structure

src/main/java/com/hackathon/base - contains the AutomationBase.java which is the singleton base class all our tests inherit
src/main/java/com/hackathon/config - contains the AutomationFactory.java which is developed on factory design pattern for instatntiations
                                   - contains the DriverOptions.java which handles browser capabilities and options
                                   - contains the HackathonApp.java which handles opening of Hackathon App V1 & V2 both with ads and without ads
src/main/java/com/hackathon/constants - contains Globals.Java which has all the required constant variables used in the project
src/main/java/com/hackathon/exceptions - contains the customized exception in ValidationFailed.java
src/main/java/com/hackathon/listeners - contains the TestListener.java listener
src/main/java/com/hackathon/pages - segregated further into objects & pages folders, this is where coding logic of test scenarios exists implemented using the very famous design pattern PageFactory. However, I have done this implementation in a different and my own way. Hope you like it. :)
src/main/java/com/hackathon/utils - contains all the utilitiy functions needed to support the automation of this challenge

src/resources/data - contains the data.xlsx excel file for data driven testing
src/resources/webdrivers - running the Maven commands discussed in the coming sections will automatically download the binary of Chrome browser version 78.0.3904.70 [NOTE: Please note that after the download it will also set the binary location in System properties]

src/test/java/com/hackathon/suites - contains TestNG xml suite files. The traditional.xml file is responsible for executing TraditionalTests.java and the visual.xml suite file is responsile for executing VisualAITests.java

src/test/java/com/hackathon/tests - contains TraditionalTests.java for functional tests and VisualAITests.java for visual tests

pom.xml - contains the information of the project and configurations to build the project such as dependencies, build directory, source directory, test source directory, plugin, goals etc.

## Guide to Execute Test Suites

Please either clone this project or download it on your local machine.

### Excel Sheet

Placed under src/resources/data, the data.xlsx contains two sheets namely, Suite and Tests.
The Suite sheet has a header row (1st row) with two columns Suite Name and Mode. The Tests sheet contains data variations for each test iteration. Since the data driven test has only four data variations, I have fed dataDrivenLogin test with four different data variations.
As per the Hackathon challenge, you will see two suites under Suite Name column. The Traditional Tests Suite which executes all the data driven traditional tests and the Visual AI Tests Suite which executes all the data driven visual AI tests.

Please pay special attention to the Mode column. There are three values designed to feed this column and each value has special meaning as explained below.

The value RUN in the Mode column against Traditional Tests Suite will execute the data driven traditional tests.
The value SKIP in the Mode column against Traditional Tests Suite will NOT execute the data driven traditional tests.
The value EYES in the Mode column against Visual AI Tests Suite will execute the data driven visual AI tests.
The value SKIP in the Mode column against Visual AI Tests Suite will NOT execute the data driven visual AI tests.

In nutshell, use RUN for Traditional Tests Suite and EYES for Visual AI Tests Suite.

Note: I have already set the correct values in the Excel sheet. You just need to execute the maven commands discussed in the following sub sections.

### Executing the Traditional Tests Suite

Step 1: Open the data.xlsx workbook. Go to Suite sheet, and write RUN in the Mode column against Traditional Tests Suite. Also, write SKIP in the Mode column against Visual AI Tests Suite so that you can only see traditional tests running first.

Step 2: Open CMD or any terminal. Go to the project root directory and run the following commands.

For executing tests on Hackathon App V1:

mvn clean test-compile failsafe:integration-test -DtestSuite=traditional.xml -DappVersion=V1

For executing tests on Hackathon App V2:

mvn clean test-compile failsafe:integration-test -DtestSuite=traditional.xml -DappVersion=V2

### Executing the Visual AI Tests Suite

Step 1: Open the data.xlsx workbook. Go to Suite sheet, and write EYES in the Mode column against Visual AI Tests Suite. Also, write SKIP in the Mode column against Traditional Tests Suite so that you can only see visual AI tests running first.

Step 2: Open CMD or any terminal. Go to the project root directory and run the following command.

For executing tests on Hackathon App V1:

mvn clean test-compile failsafe:integration-test -DtestSuite=visual.xml -DappVersion=V1

For executing tests on Hackathon App V2:

mvn clean test-compile failsafe:integration-test -DtestSuite=visual.xml -DappVersion=V2

## Tests Stats

### Traditional Tests Suite Stats

No. of lines of code to implement coding logic (Page classes) for traditional tests = 460
No. of lines of code in TraditionalTests.java = 198
Total lines of lines of code in Traditional Tests Suite = 658

### Visual AI Tests Suite Stats

No. of lines of code to implement coding logic (functional clicks from Page classes) for visual tests = 50
No. of lines of code in VisualAITests.java = 204
Total lines of lines of code in Visual AI Tests Suite = 254

## Applitools Eyes Test Manager Results

Please visit the below link to see the results of my execution of the Visual AI Tests Suite.

https://eyes.applitools.com/app/test-results/00000251827419869710?accountId=Qo_5OZnIKU2jseDUzFj7Wg~~&display=details&top=00000251827419869710%282%29

## Author

* MUHAMMAD TAFSEER HAIDER, Test Automation Developer & DevOps Evangelist from Pakistan

## Contact

In case you are stuck and not able to run my tests for any reason, please contact me on:

E-mail: mtafseer.haider@gmail.com OR tafseer.haider@netsoltech.com, WhatsApp: +923008359570
