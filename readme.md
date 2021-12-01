# Amazon Assignment

### Notes
I have used amazon.in and chocalate as Rocho Ferrero. 
I cannot choose Mars & Bounty and Amazon.com because of the error message shown by amazon due to location

## Libraries Used :

1. **Selenium** - Web Automation
2. **TestNG** - Unit Testing Library
3. **Extent Reports** - Reporting Library to generate beautiful html reports
4. **AssertJ** - Fluent Assertion Library in Java
5. **WebDriverManager** - Executables management
6. **Lombok** - To reduce boilerplate codes

**Note : All the aforementioned libraries are open-source and does not include any license.**

## Capabilities:

1. This framework has the capability to run the tests in local and remote selenium grid.
2. It can also be extended to run on clouds like browser stack or seetest.
3. Web Tests can be run on chrome or edge browsers.
4. Configuration can be changed from config.properties inside src/test/resources
5. Utility methods available for Web Interactions *(SeleniumActions.java)*
6. Integration with Jenkins for scheduling is easy. :raising_hand:

## Adding more tests :

Prerequisites: Java 8+ , Maven 3.6.3 Installed and path set

1. Tests should be added as per the convention followed. New testng tests should be created inside the src/test/java
   folder.
2. All the tests should extend BaseTest.java
3. Each test created should define the description as mandatory parameters. This will be helpful while creating
   the extent reports.
4. All the tests should be follow AAA pattern - **ARRANGE, ACT and ASSERT**
5. Have maximum of one to two assertions per test.
6. Tests should interact only with the Facade layer. This can be used to wrap the business logic.

## Running Tests :

Prerequisites: Java 8+ , Maven 3.6.3 Installed and path set

1. There are multiple ways to run the tests. During development phase you can use the **testng.xml** present in the root folder to run. Right click and choose run.
2. Each of the testng xml file should contain the test classes to pick for the run.
3. User can also choose the thread-count parameter to run the tests in parallel.
4. User can also choose to run via maven commands which is highly recommended.
5. Maven profiles are configured in the pom.xml. You can run these from IDE Terminal or any OS Terminal inside the
   project folder.

`mvn clean test -Pall` - To run all the tests available in the testng.xml

Note : User should not try to run the test from test class - Might end up in NPE. Because the listeners are configured only in testng.xml

## Report Interpretation :

1. Dashboard view clearly indicates the start time, end time of the run, number of tests passed and failed. It also
   shows the time took for the individual tests in form of timeline. Hover the mouse over the timeline to get the exact
   time details.
![img.png](readmeimages/img6.png)
2. Tags tab in the Dashboard view clearly indicates the pass and fail according to the functionality.
3. Click on each test tab to view the corresponding test log events.
4. All the web tests will have a screenshot attached on failure
5. After each test run, reports can be found under root directory and ExtentReports folder.
6. Press "l" on the keyboard after opening the report to switch the theme to Standard.
![img.png](readmeimages/img7.png)

## Jenkins Integration :

1. This project can be integrated easily with Jenkins.
2. Login to Jenkins
3. Create Maven Project(Add maven plugin if not present)
![img.png](readmeimages/img.png)
4. Configure choice parameters to run different maven profiles
![img_1.png](readmeimages/img_1.png)
5. Configure goal and options
![img_2.png](readmeimages/img_2.png)
6. Choose custom workspace and give the project location
![img_3.png](readmeimages/img_3.png)
7. To run, select Build with parameters -> Choose Profile -> Click build
![img_4.png](readmeimages/img_4.png)
8. View the results in the console output.
![img_5.png](readmeimages/img_5.png)


##Command to run the docker container

1. Make sure to have the selenium grid or selenoid grid up and running
2. Find cwd

`$current = $PWD -replace "\\", "/" -replace "C", "c"`

3.Start selenoid container

`docker run -d --name selenoid -p 4444:4444 -v //var/run/docker.sock:/var/run/docker.sock -v ${current}/config/:/etc/selenoid/:ro -v /c/Users/testi/selenoid/video/:/opt/selenoid/video/ -e OVERRIDE_VIDEO_OUTPUT_DIR=/c/Users/testi/selenoid/video/ aerokube/selenoid:latest-release`

or 

Start selenium standalone container or grid

`docker run -d --rm --name selenium -p 4444:4444 --shm-size="2g" selenium/standalone-chrome:96.0`

4. Start seleniod ui(only need to view live execution)

`docker run --rm -d --name selenoid-ui --link selenoid -p 8090:8080 aerokube/selenoid-ui --selenoid-uri=http://selenoid:4444`

5. Run the docker image with necessary parameters. (Remote URL can be any ip reachable to the container. All are optional parameters)

`docker run --rm -e remoteurl=http://192.168.0.231:4444/wd/hub -e runmode=remote -e remotemode=selenoid amuthanqa/assignment:latest`

6. Add the additional parameters to the jenkins build and execute shell or windows batch command

![img11.png](readmeimages/img11.png)

![img12.png](readmeimages/img12.png)

![img10.png](readmeimages/img10.png)

![img13.png](readmeimages/img13.png)

![img14.png](readmeimages/img14.png)


## Final Notes:

1. I have not written any unit tests because all the methods are relatively small and static
2. I have performed sonarlint analysis to check the code quality.
3. Base image used in the dockerfile is customised from `maven:3.6.3-jdk-8` where the maven dependencies are downloaded and kept handy to avoid downloading maven dependencies during each run.

## Questions :

For any further clarification - please reach out to `mech.amuthansakthivel@gmail.com`





