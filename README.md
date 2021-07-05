# Comp-Build-BackEnd

- Demo
  - A running demo for the front-end web application that utilizes this back-end API can be seen [here](https://www.compbuild.toddtran.com/)
  - This is hosted on Linode. It was previously hosted on an AWS EC2 instance.
  - Frontend repository [here](https://github.com/ttran9/comp-build-frontend)

- This will house the code for the backend.
  - I have decided to split the app up into individual repositories as this would be more practical.
    - My former implementation (for simplicity) was to have the frontend
    as a compressed javascript file with an index.html file that references the minified javascript file. This wouldn't
    be a great practice because this back-end API should not serve any templates (any views) for the user, instead it
    should just house endpoints that the front-end (an individual application) can reference and display back to a user.


- Some issues I ran into while trying to deploy:
  - An issue I had was that I am trying to process both www.compbuild.toddtran.com and compbuild.toddtran.com
  and I have tried to follow the CORS configuration [documentation here](https://docs.spring.io/spring-security/site/docs/current/reference/html5/#cors) 
    - My work-around was to follow the documentation and the solution can be seen in the WebConfig class (WebConfig.java).
  - I also was using gmail to send the registration confirmation emails as well as the change password emails but I found
  that this had issues from time to time so I decided to use sendgrid as it presents me with less issues but I realize a
  limitation is that I am only allowed 100 emails a day.
    - Due to this being a small scale app this is not a priority I have not extensively looked for a solution.     
