# Advanced Computing Concepts Project 
# Web Search Engine


## Introduction

In simple terms, search engines are response machines. They discover and catalogue all the material accessible on the Internet through crawling and indexing. All the results are then sorted and ranked based on the best match. The Crawlers/Spiders are search engine programs that start by finding web pages and then hopping through a path of links and web pages to find new content.

### Features Used

For the implementation of Web Search Engine, we will apply these concepts including the following:
- Pattern Matching
- Indexing
- Edit Distance Algorithm
- Occurences of Words
- Parsing
- Search Engine Process


### Project Flowchart

![alt text](https://github.com/AnishaGharat/Web_Search_Engine/blob/dev/data/Web_Search_Engine_Project_Flowchart.png?raw=true)


### Prerequisites


- [JAVA] (https://www.java.com/en/download/manual.jsp)
- [Git] (https://git-scm.com/downloads)
- [Eclipse] (https://www.eclipse.org/downloads/)
- [Jsoup] (https://jsoup.org/download/)

### Installing


The steps are:
 1. [Setting up Eclipse Environment](#step-1---setting-up-eclipse-environment)
 2. [Cloning the Application](#step-2---cloning-the-application)
 3. [Downloading necessary Java Libraries](#step-3---downloading-necessary-Java-Libraries)
 4. [Running the Application](#step-4---running-the-application)


### Step 1 - Setting up Eclipse Environment


- After installing the Eclipse IDE for the respective OS, launch the IDE.


### Step 2 - Cloning the Application

- Extract project .zip file or
- In the terminal type the following command

```
$ git clone https://github.com/AnishaGharat/Web_Search_Engine.git
```

This command will pull the latest project files from git repository.


### Step 3 - Downloading necessary Java Libraries 


- Create a new project in Eclipse using the path of the cloned or extracted source codes.

- For installing the required libraries, you require jsoup jar file. 

- Under the project configurations in Eclipse > Add External JAR files, set the relative path of the Jsoup JAR file (check pre-requisites).


### Step 4 - Running the Application

- Change the file paths in the below two files and add the complete path of the WebPages/Text folder in your directories:
  - Parser.java -> File FolderWithFiles = new File(""); 
  - WebSearchEngine.java -> private static String filePathAbs = "";

- In the Eclipse IDE, open a new terminal and run the Java Application.

- Follow the Project Flowchart for further assistance on the user inputs and flow of the application.


## Versioning

We use [GitHub](http://github.com/) for versioning. 

## Testing

- Unit tests were performed on each individual feature.

- Integration tests were performed after the integration of all the features into a single application.

## Application Video

A comprehensive explanation of the application along with the demo can be viewed here:
 - https://youtu.be/tZBE_PEM4Oc

## Authors

* **Adhiraj Singh**
* **Anisha Gharat**
* **Sarwat Til Vusqa**
* **Manavdeep Singh**
* **Akhilesh Sharda**



