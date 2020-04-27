# Comp-Build-BackEnd

# Demo
  - A running demo for the front-end web application that utilizes this back-end API can be seen [here](https://www.compbuild.toddtran.com/)

# Other Information
  - Some technologies used to build this were Java, Spring Boot, Spring Security, Docker, Hibernate, JUnit, and MySQL.
  - I have decided to split the app up into individual repositories as this would be more practical.
  - In order to get familiar with using React with a Spring Boot API I followed a Udemy course where the frontend was a compressed javascript file with an index.html file that references the minified javascript file. This wouldn't be a great practice because this back-end API should only have endpoints the user can access from webpages or some web client in order to grab relevant information.


# Some issues I ran into while trying to deploy:
  - An on-going issue I have is that I am trying to process both www.compbuild.toddtran.com and compbuild.toddtran.com
  and I have tried to follow the CORS configuration [documentation here](https://docs.spring.io/spring-security/site/docs/current/reference/html5/#cors) 
  but have not been able to get it working and I will continue to try to create a configuration that works.
    - My current work-around for this is just to allow all origins but I realize this configuration is less secure.
  - At first I was attempting to directly use tomcat so I decided to use apache to proxy requests to the back-end api.
  - I also was using gmail to send the registration confirmation emails as well as the change password emails but I found
  that this had issues from time to time so I decided to use sendgrid as it presents me with less issues but I realize a
  limitation is that I am only allowed 100 emails a day.    

