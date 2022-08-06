# webTestingAutomationReadExcel
A simple format to extract basic information like username, password from an excel file and utilize for login into a webPage.

The page object model(POM) framework of Selenium would be used.

Utilities Folder: Driver Class to prepare and use drivers. it will switch based on the choice of browser.  
-Configuration Reader class to contain website adress, browser choıces. 
-Usefull methods classs contains a hard wait method and the takeScreenShot method 
-ExcelUtil class that defines :
  + a Constructor to take the path of excel file, and the related sheetName.
  + 3 objects: fileInputStream {via new }, workBook {via FActory}, workSheet {via getSheet(sheetName)} objects.
  + getDataList() method that will 
  
  Excel handling may appear a bit complex. 



A resource package(folder)under the java  to contain the Excel file of data

The TestRun class a login() method that would use driver, create pageObjects, will click the "Loginébutton for the first time, IF THERE IS ONE {With the help pf try catch-without printing stacks.
if it is the other case (a successLoginPage, it is a second try-catch blok that would try to logout by first clicking on the user butoon, choose "Logout" option from dropdown, and click on the "OK" popUP on the same page.  and will do the relogin again. 

Note that a simple action can even be expressed in a try-catch framework. 


The main @Test method (CustomerLogin() ) define path of hte excel file, sheetName, excelUtil object wchich is define by path and sheetName. and dataList object that contains a list of pairs (maps) of username-password.  Then we initiate a for loop for each pair to get the username and sendKeys into related input forms.  Then we click the submit butoon. Note that, this test method alreads start with the login() method for each pair., which itself contains 2 trz-catch block with respect to whether we are on the first LoginPage or the second SuccessLoginPage.
