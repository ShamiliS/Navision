# Ooyala_task

Download Zip file and unzip the project.

# Pre-requisites:

1. Make sure All the dependent jar files from pom.xml have been downloaded to local.
	Perform:
	Right click on project -> Run as -> Maven install 

Execution1:
#Open command prompt
#Make sure maven is installed and the mavenhome is set in the environment path.
#Change/specify the project folder path
Eg: cd projectpath
#Type 'mvn test'

Execution2:
#Open 'Eclipse IDE'
#Import 'Existing Maven Project'
#Right Click on the project 'Run As->Maven Test'

Execution3: To Execute as JUnit Project
#Open 'Eclipse IDE'
#Import 'Existing Maven Project'
#Expand Project 'src/test/java/runner'
#Right Click on the 'TestRunner.java' and 'Run As->JUnit Test'

Execution4: To Execute as TestNG Project
#Open 'Eclipse IDE'
#Import 'Exixting Maven Project'
#Expand Project 'src/test/java/runner'
#Right Click on the 'TestNG.xml' and 'Run As->TestNG Suite'
#Note: Make sure TestNg is instslled in the eclipse
