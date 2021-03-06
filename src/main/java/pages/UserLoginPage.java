package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cucumber.ContextMap;
import enums.Context;
import utils.ElementActions;

/**
 * <p>
 * Class defining elements and Methods for User's Login page
 * </p>
 * @author Singh
 *
 */
public class UserLoginPage extends Page{
	
	public WebDriver driver;
	public ContextMap brain;
	
	/**
	 * <p>
	 * Constructor to initialize driver and Scenario context
	 * </p>
	 * @param driver driver instance for current scenario
	 * @param brain Context Map for current Scenario
	 */
	public UserLoginPage(WebDriver driver, ContextMap brain) {
		super("account/logout/", driver);
		this.driver = driver;
		this.brain = brain;
	}
	
	/**
	 * <p>
	 * Page Elements
	 * </p>
	 */
	private WebElement email;
	public WebElement email(){
		email = driver.findElement(By.xpath("//input[@name = 'username']"));
		return email;
	}
	
	private WebElement password;
	public WebElement password(){
		password = driver.findElement(By.xpath("//input[@name = 'password']"));
		return password;
	}
	
	private WebElement login;
	public WebElement login(){
		login = driver.findElement(By.xpath("//button[@type = 'submit'][@class = 'btn btn-primary btn-lg btn-block loginbtn']"));
		return login;
	}
	
	/**
	 * Logs in as user that has been registered on the current scenario
	 */
	public void loginAsNewlyRegUser() {
		ElementActions.sendKeys(email(), (String)brain.scenarioContext.getContext(Context.regEmailAddress));
		ElementActions.sendKeys(password(), (String)brain.scenarioContext.getContext(Context.regPassword));
		ElementActions.clickElement(login());
	}
}