package ExcInteract.tests;

import ExcInteract.pages.HomePage;
import ExcInteract.pages.LoginPage;
import ExcInteract.pages.SuccessLoginPage;
import ExcInteract.utilities.ConfigReader;
import ExcInteract.utilities.Driver;
import ExcInteract.utilities.ExcelUtil;
import ExcInteract.utilities.ReusableMethods;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class LoginWithExcelTest {

    HomePage homePage;
    LoginPage loginPage;
    SuccessLoginPage successLoginPage;
    ExcelUtil excelUtil;

    // this var will refer to the list of  username, password pairs (maps)
    List<Map<String, String>> testData;

    public void login() {
        Driver.getDriver().get(ConfigReader.getProperty("app_Url"));

        //initiating (Instantiation?) of the variables for this method
        homePage = new HomePage();
        loginPage = new LoginPage();
        successLoginPage = new SuccessLoginPage();

        try {
            //clicking on the loginButton
            homePage.homeLoginButton.click();
        } catch (Exception e){
    //e.printStackTrace();
        }
        try {
    successLoginPage.userIDLoged.click();
    successLoginPage.logoutOption.click();
    successLoginPage.consentOK.click();

    homePage.homeLoginButton.click();
}catch (Exception e) {
   // e.printStackTrace();
}
    }

    @Test
    public void customerLogin() {
        //path of the excel sheet
        String path = "./src/test/java/resources/TestData.xlsx";
        //Customer Data sheet vs Admin data sheet
        String customerSheet = "customer_info";

        //invoke the define method that opens a path with a named sheet.
        excelUtil = new ExcelUtil(path, customerSheet);
        //gets data and stores in the test-data variable
        testData = excelUtil.getDataList();
        System.out.println(testData);
        //}
//}

        //for each username-pswrd pair
        for (Map<String, String> eachData : testData) {
            System.out.println(eachData);
            login();

            ReusableMethods.waitFor(2) ;

            //Get the username in key-value pair.
            System.out.println(eachData.get("username"));
            loginPage.username.sendKeys(eachData.get("username"));
            ReusableMethods.waitFor(2);

            //As excell convert to decimals. wee need non decimal. if we can truncate after zero. TRY This  split(".")
            loginPage.password.sendKeys(eachData.get("password").substring(0,5));
            ReusableMethods.waitFor(2);

            loginPage.submitButton.click();
            ReusableMethods.waitFor(2);
        }

    }

}
/*
 loginPage.username.sendKeys(ConfigReader.getProperty("admin_username"));
        loginPage.password.sendKeys(ConfigReader.getProperty("admin_password"));


        loginPage.loginButton.click();

        //verification
        Assert.assertTrue(successLoginPage.userIDLoged.isDisplayed());

        Driver.closeDriver();

        @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
}
 */