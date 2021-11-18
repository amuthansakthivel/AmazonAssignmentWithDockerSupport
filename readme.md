# Amazon Assignment - Personio

## Libraries Used :

1. **Selenium** - Web Automation
2. **TestNG** - Unit Testing Library
3. **Extent Reports** - Reporting Library to generate beautiful html reports
4. **AssertJ** - Fluent Assertion Library in Java
5. **WebDriverManager** - Executables management

**Note : All the aforementioned libraries are open-source and does not include any license.**

## Capabilities:

1. This framework has the capability to run the tests in local machine and remote.
2. Web Tests will be delegated to the dockerised selenium grid on chosing runmode as
   remote
3. Mobile Tests will be delegated to the Mobile Center Devices on chosing runmode as
   remote
4. API Tests are uiless and can be run on the hosting machine.
5. Have the code to interact with _Oracle Database_
6. Can create the defects automatically in _JIRA_ on test failure
7. Easily customizable based on the configurations in src/test/resources/config.properties and
   src/test/resources/mobileconfig.properties
8. Utility methods avaiable for Web Interactions *(SeleniumActions.java)*, Mobile App Interactions *(
   MobileActions.java)*, API request and response parsing. _(RequestBuilder.java)_
9. Integration with Jenkins for scheduling is easy. :raising_hand:

## Adding more tests :

1. Tests should be added as per the convention followed. New testng tests should be created inside the src/test/java
   folder.
2. Based on the type of tests, it has to be created inside api or ui/mobile or ui/web.
3. All the api tests should extend **APIBaseTest.java**
4. All the mobile tests should extend **MobileBaseTest.java**
5. All the web tests should extend **WebBaseTest.java**
6. Each test created should define the groups, description as mandatory parameters. This will be helpful while creating
   the extent reports.
7. All the tests should be follow AAA pattern - **ARRANGE, ACT and ASSERT**

![img_1.png](readmeimages/img_1.png)

## Running Tests :

1. There are multiple ways to run the tests. During development phase you can use the **testng_web.xml , testng_api.xml,
   testng_mobile.xml** present in the root folder to run. Right click and choose run.
2. Each of the testng xml files contains the test classes to pick for the run.
3. User can also choose the thread-count parameter to run the tests in parallel. In the below picture we have choosen
   the thread-count as 3.Hence three tests from the given test classes will run in parallel.

![img.png](readmeimages/img.png)

4. User can also choose to run via maven commands which is highly recommended.
5. Maven profiles are configured in the pom.xml. You can run these from IDE Terminal or Windows Terminal inside the
   project folder.

`mvn clean test -Pall` - To run all the different types of tests (web,mobile and api)

`mvn clean test -Pweb` - To run only the tests related to web, configured in testng_web.xml

`mvn clean test -Pmobile` - To run only the tests related to mobile , configured in testng_mobile.xml

`mvn clean test -Papi` - To run only the tests related to api, configured in testng_api.xml

## Report Interpretation :

![img_2.png](readmeimages/img_2.png)

1. Dashboard view clearly indicates the start time, end time of the run, number of tests passed and failed. It also
   shows the time took for the individual tests in form of timeline. Hover the mouse over the timeline to get the exact
   time details.

![img_3.png](readmeimages/img_3.png)

2. Tags tab in the Dashboard view clearly indicates the pass and fail according to the functionality. Groups tag given
   on top of tests will be picked to categorize the tests based on the functionality.

![img_4.png](readmeimages/img_4.png)

3. The left Tests pane indicated in the above diagram contains the list of all the test run and it's log events.
4. Click on each test tab to view the corresponding test log events.
5. All the web tests and mobile tests will have a screenshot attached for each step. Click on the pink base64.img to
   view the screenshot.

![img_5.png](readmeimages/img_5.png)

6. All the API tests will have the request endpoint, request body and response body logged in the report for debugging
   purpose. Request body will be marked with info tag and reponse with pass tag for easy interpretation. This is also
   configurable.

![img_6.png](readmeimages/img_6.png)

7. After each test run, reports can be found under root directory and ExtentReports folder.
8. Press "l" on the keyboard after opening the report to switch the theme to Standard.

![img_7.png](readmeimages/img_7.png)

## Jenkins Integration :

1. This project is integrated in Jenkins.
2. Login to Jenkins -> FSIX -> FSIX Automation -> Choose test type and click on build.

![img_8.png](readmeimages/img_8.png)

3. For colleagues who want to setup this pipeline can see the screenshots below.
4. Under general section -> Add different choice parameters. (If scheduled to run, then the first option will be picked)
   . In our case it will run all the test types.

![img_9.png](readmeimages/img_9.png)

5. Under SCM -> Choose Git repo and branch to be pulled for the run.

![img_10.png](readmeimages/img_10.png)

6. Under Build Environment -> Configure the artificatory server

![img_11.png](readmeimages/img_11.png)

7. Under Build section -> Confiure the pom.xml path and goals to run. Here the ${testType} is a variable and value will
   be choosen based on the choice parameter.

![img_12.png](readmeimages/img_12.png)

8. To send email after test run with reports. Post Build -> Editable Email Notification -> Choose the recipients, report
   path and email body.

![img_13.png](readmeimages/img_13.png)

## Questions :

For any further clarification - please reach out to `amuthan.sakthivel@dhl.com`





