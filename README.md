# Spring Boot Todo Application

* This is a Spring Boot application using MVC model.
* The application has the below functionalities
    * View all the tasks.
    * Add new todo tasks.
    * Update existing tasks.
    * Mark the task as Completed.
    * Delete a task.

## Technologies and tools used

* Spring Boot
* MySQL

## Required dependencies

* Spring Data JPA
* Spring Web
* MySQL Driver
* Jstl
* Bootstrap
* JQuery

### Additionally adding the below external jars to the classpath is required

* https://repo1.maven.org/maven2/org/glassfish/web/jakarta.servlet.jsp.jstl/3.0.0/
* https://repo1.maven.org/maven2/jakarta/servlet/jsp/jstl/jakarta.servlet.jsp.jstl-api/3.0.0/

## Add the below code in application.properties

    spring.mvc.view.prefix=/WEB-INF/jsp/
    spring.mvc.view.suffix=.jsp
    spring.jpa.hibernate.ddl-auto=update
    spring.datasource.url=jdbc:mysql://localhost:3306/DatabaseName
    spring.datasource.username=root
    spring.datasource.password=yourDatabasePassword
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver