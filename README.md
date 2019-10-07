# Comp-Build-FrontEnd

- This will house the code for the backend.
  - I have decided to split the app up into individual repositories as this would be more practical.
    - My former implementation (taken from a Udemy course and likely done for simplicity) was to have the frontend
    as a compressed javascript file with an index.html file that references the minified javascript file. This wouldn't
    be a great practice because this back-end API should not serve any templates (any views) for the user, instead it
    should just house endpoints that the front-end (an individual application) can reference and display back to a user.


- Some issues I ran into while trying to deploy:
  - So I was getting an issue with an improper CORS configuration and I found [this](https://docs.spring.io/spring/docs/current/spring-framework-reference/web.html#mvc-cors-global-java)
  to be a very helpful reference.

- Demo
  - A running demo for the front-end web application that utilizes this back-end API can be seen [here](https://todd-comp-build-frontend.herokuapp.com)
