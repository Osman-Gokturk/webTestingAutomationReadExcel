package ExcInteract.pages;

import ExcInteract.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SuccessLoginPage {

    public SuccessLoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id="dropdown-basic-button")
    public  WebElement userIDLoged;

    @FindBy(linkText="Logout")
    public  WebElement logoutOption;

    @FindBy(xpath="//button[text()='OK']")
    public  WebElement consentOK;

}
