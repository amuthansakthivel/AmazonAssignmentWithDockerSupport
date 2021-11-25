FROM amuthanqa/maven-3.6.3-testdep
COPY src  home/framework/src
COPY ExtentReports/index.html  home/framework/ExentReports/index.html
COPY pom.xml	home/framework/pom.xml
COPY testng.xml	home/framework/testng.xml
WORKDIR home/framework
ENTRYPOINT mvn clean test -Pall -D