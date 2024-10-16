# Comp-Build-BackEnd

# Demo
  - A running demo for the front-end web application that utilizes this back-end API can be seen [here](https://www.compbuild.toddtran.com/)
  - This is hosted on Linode. It was previously hosted on an AWS EC2 instance.
  - Frontend repository [here](https://github.com/ttran9/comp-build-frontend)
  - Stand alone [API here](https://www.cb-be.toddtran.com/api/computerbuild/)


# Other Issues
  - Cloning this and attempting to use java jdk 17 was causing me issues with reflections. I fixed this by using java jdk 11 on Ubuntu 20.04. 

# Running tests locally
  - A limitation is that only the "test" profile can run the test without any errors after the first instance.
    - This occurs because the "test" database uses a CREATE-DROP ddl-auto strategy while I configured the "prod" and "dev" profiles to use a "validate" schema.
    - Due to this limitation if you want to run the tests use the "test" profile only
    - Given that only my "test" profile works I will be refactoring my tests (likely removing many as it seems they are not quite robust enough).
  - Running the tests will require a Tomcat instance and this can be done in many ways but the simplest way is just to  run it through intelliJ but the running demo I have linked above uses Docker to generate both a Tomcat instance and MySQL database.
  - To run my integration tests I prepopulated the database using both an external script (setup_files/mysql_backup.sql)
  - and programmatically through the ProductionBootstrapData.java class.
  - For the below steps I am assuming you're familiar with Docker but if not you can install it by following the
  - [guide here](https://docs.docker.com/engine/install/).
  - For creating both of your local docker containers I recommend cd'ing into the setup_files directory.
  - Steps to create a MySQL instance inside of Docker
    - sudo docker pull mysql:latest
    - sudo docker run --name cb_api_db -e MYSQL_ROOT_PASSWORD=rootPW -e MYSQL_DATABASE=cb_db -p 3306:3306 --network host -d mysql:latest
    - cat mysql_backup.sql | sudo docker exec -i cb_api_db /usr/bin/mysql -u root --password=rootPW cb_db
    - The above is useful if you would like to run this app locally with a "prod" profile and to use a client such as Postman to make requests without a frontend application.
  - Steps to create a docker tomcat container for this application (using Ubuntu)
    - sudo docker image pull tomcat:9.0.45
    - sudo docker image build -t todd/compbuild ./
    - sudo docker container run --network host --name cb_api -it todd/compbuild
      - At this point the application won't start so you can just kill this process by using ctrl+c or cmd+c (macOS)
    - sudo docker cp /etc/cb_be_config.json cb_api:/etc
    - sudo docker start cb_api
    - Similarly to the MySQL instance if you are interested in using this stand alone api follow the above steps.


# This will house the code for the backend.
  - I have decided to split the app up into individual repositories as this would be more practical.
    - My former implementation (for simplicity) was to have the frontend
    as a compressed javascript file with an index.html file that references the minified javascript file. This wouldn't
    be a great practice because this back-end API should not serve any templates (any views) for the user, instead it
    should just house endpoints that the front-end (an individual application) can reference and display back to a user.

# Some issues I ran into while trying to deploy:
  - An issue I had was that I am trying to process both www.compbuild.toddtran.com and compbuild.toddtran.com
  and I have tried to follow the CORS configuration [documentation here](https://docs.spring.io/spring-security/site/docs/current/reference/html5/#cors) 
    - My work-around was to follow the documentation and the solution can be seen in the WebConfig class (WebConfig.java).
  - I also was using gmail to send the registration confirmation emails as well as the change password emails but I found
  that this had issues from time to time so I decided to use sendgrid as it presents me with less issues but I realize a
  limitation is that I am only allowed 100 emails a day.
    - Due to this being a small scale app this is not a priority I have not extensively looked for a solution.     
  