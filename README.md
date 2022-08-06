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



A resource package(folder)under the java  to contain the Excel file of data


