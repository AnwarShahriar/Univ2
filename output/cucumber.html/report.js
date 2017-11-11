$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("cucumbertest/login.feature");
formatter.feature({
  "name": "Login",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Clerk login success",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "the university is initialized",
  "keyword": "Given "
});
formatter.match({
  "location": "cucumberStepDefinitions.the_university_is_initialized()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user inputs clerk",
  "keyword": "And "
});
formatter.match({
  "location": "cucumberStepDefinitions.the_user_inputs_clerk()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the clerk logs in with admin",
  "keyword": "When "
});
formatter.match({
  "location": "cucumberStepDefinitions.the_clerk_logs_in_with(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the clerk is logged in",
  "keyword": "Then "
});
formatter.match({
  "location": "cucumberStepDefinitions.the_clerk_is_logged_in()"
});
formatter.result({
  "status": "passed"
});
formatter.scenarioOutline({
  "name": "Clerk login fail",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "the university is initialized",
  "keyword": "Given "
});
formatter.step({
  "name": "the user inputs clerk",
  "keyword": "And "
});
formatter.step({
  "name": "the clerk logs in with \u003cpassword\u003e",
  "keyword": "When "
});
formatter.step({
  "name": "the clerk is not logged in",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "password"
      ]
    },
    {
      "cells": [
        "123456"
      ]
    },
    {
      "cells": [
        "asdfgh"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Clerk login fail",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "the university is initialized",
  "keyword": "Given "
});
formatter.match({
  "location": "cucumberStepDefinitions.the_university_is_initialized()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user inputs clerk",
  "keyword": "And "
});
formatter.match({
  "location": "cucumberStepDefinitions.the_user_inputs_clerk()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the clerk logs in with 123456",
  "keyword": "When "
});
formatter.match({
  "location": "cucumberStepDefinitions.the_clerk_logs_in_with(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the clerk is not logged in",
  "keyword": "Then "
});
formatter.match({
  "location": "cucumberStepDefinitions.the_clerk_is_not_logged_in()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Clerk login fail",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "the university is initialized",
  "keyword": "Given "
});
formatter.match({
  "location": "cucumberStepDefinitions.the_university_is_initialized()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user inputs clerk",
  "keyword": "And "
});
formatter.match({
  "location": "cucumberStepDefinitions.the_user_inputs_clerk()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the clerk logs in with asdfgh",
  "keyword": "When "
});
formatter.match({
  "location": "cucumberStepDefinitions.the_clerk_logs_in_with(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the clerk is not logged in",
  "keyword": "Then "
});
formatter.match({
  "location": "cucumberStepDefinitions.the_clerk_is_not_logged_in()"
});
formatter.result({
  "status": "passed"
});
formatter.scenarioOutline({
  "name": "Student login success",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "the university is initialized",
  "keyword": "Given "
});
formatter.step({
  "name": "the user inputs student",
  "keyword": "And "
});
formatter.step({
  "name": "the student logs in with \u003cemail\u003e \u003cpassword\u003e",
  "keyword": "When "
});
formatter.step({
  "name": "the student is logged in",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "email",
        "password"
      ]
    },
    {
      "cells": [
        "jim@gotham",
        "12345"
      ]
    },
    {
      "cells": [
        "lee@gotham",
        "12345"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Student login success",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "the university is initialized",
  "keyword": "Given "
});
formatter.match({
  "location": "cucumberStepDefinitions.the_university_is_initialized()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user inputs student",
  "keyword": "And "
});
formatter.match({
  "location": "cucumberStepDefinitions.the_user_inputs_student()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the student logs in with jim@gotham 12345",
  "keyword": "When "
});
formatter.match({
  "location": "cucumberStepDefinitions.the_student_logs_in_with_(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the student is logged in",
  "keyword": "Then "
});
formatter.match({
  "location": "cucumberStepDefinitions.the_student_is_logged_in()"
});
formatter.result({
  "error_message": "java.lang.AssertionError: \nExpected: \u003c3\u003e\n     but: was \u003c15\u003e\r\n\tat org.hamcrest.MatcherAssert.assertThat(MatcherAssert.java:20)\r\n\tat org.hamcrest.MatcherAssert.assertThat(MatcherAssert.java:8)\r\n\tat cucumbertest.cucumberStepDefinitions.the_student_is_logged_in(cucumberStepDefinitions.java:60)\r\n\tat ✽.the student is logged in(cucumbertest/login.feature:24)\r\n",
  "status": "failed"
});
formatter.scenario({
  "name": "Student login success",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "the university is initialized",
  "keyword": "Given "
});
formatter.match({
  "location": "cucumberStepDefinitions.the_university_is_initialized()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the user inputs student",
  "keyword": "And "
});
formatter.match({
  "location": "cucumberStepDefinitions.the_user_inputs_student()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the student logs in with lee@gotham 12345",
  "keyword": "When "
});
formatter.match({
  "location": "cucumberStepDefinitions.the_student_logs_in_with_(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the student is logged in",
  "keyword": "Then "
});
formatter.match({
  "location": "cucumberStepDefinitions.the_student_is_logged_in()"
});
formatter.result({
  "error_message": "java.lang.AssertionError: \nExpected: \u003c3\u003e\n     but: was \u003c15\u003e\r\n\tat org.hamcrest.MatcherAssert.assertThat(MatcherAssert.java:20)\r\n\tat org.hamcrest.MatcherAssert.assertThat(MatcherAssert.java:8)\r\n\tat cucumbertest.cucumberStepDefinitions.the_student_is_logged_in(cucumberStepDefinitions.java:60)\r\n\tat ✽.the student is logged in(cucumbertest/login.feature:24)\r\n",
  "status": "failed"
});
});