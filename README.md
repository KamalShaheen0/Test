# Design Selenium FrameWork

## Testing-End-to-End-Ecommerce-using-Selenium

- Create ***Maven*** Structured Framework with all necessary Automation dependencies.

- Implement ***Page Object Model*** mechanism to drive the locators from respective classes.

- Drive object creation within Page object classes ***encapsulating*** it from Tests.

- Create Base Test Which sets browser configuration details and ***Global properties*** .

- Decide the ***Test Strategy***,how tests should be clubbed & distributed with appropriate annotations. 

- Create ***TestNG runner*** file to trigger the tests with one single point of execution control. 

- introduce ***Grouping in TestNG.xml*** to categorize tests with different tags of execution.

- Implement ***Data driven testing & Parameterization*** using TestNG data provider hashMao & Json  File readers. 

- Implement ***TestNG Listeners*** to capture Screenshot on automation test failures and logging. 

- Create Extent Report wrapper to generate ***execellent HTML reports*** for the application.

- Make FrameWork necessary changes to support ***parallel execution*** with Thread safe mechanism.

- Implement TestNG ***retry mechanism*** to return the failed flaky  tests in the application.

- Run the FrameWork tests with Maven commands with ***TestNg Maven integration plugin***.

- Implement Maven ***Run time variables***to replace  global parameters of test data at run time.

- integrate the Framwork with***Jenkins***with Parameterized Build Pipeline Jobs & Scheduel the jobs on specific  time frames.

- add ***Cucumber Wrapper*** to existing framework with Cucumber TestNG Runner.
