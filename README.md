# to run tests locally
mvn -f /path/to/pom_for_chrome.xml   clean test

mvn -f /path/to/pom_for_firefox.xml  clean test

mvn -f /path/to/pom_all_parallel.xml clean test

# to run remotely 
# replace the selenium grid ip with your specific ip
mvn clean -Dremotewebdriverurl=http://172.11.11.11:7000/wd/hub  -f pom_for_chrome.xml test

mvn clean -Dremotewebdriverurl=http://172.11.11.11:7000/wd/hub  -f pom_for_firefox.xml test

mvn clean -Dremotewebdriverurl=http://172.11.11.11:7000/wd/hub  -f pom_all_parallel.xml test
