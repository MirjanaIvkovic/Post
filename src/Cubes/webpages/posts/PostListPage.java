package Cubes.webpages.posts;

import static org.junit.Assert.assertEquals;

import java.time.Duration;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PostListPage {
	

	private WebDriver driver;
	private WebDriverWait driverWait;
	private static final String PAGE_URL = "https://testblog.kurs-qa.cubes.edu.rs/admin/posts";
	@FindBy(xpath="//a[@class='btn btn-success']")
	private WebElement weAddNewPost;
	@FindBy(xpath = "//button[text()='Delete']")
	private WebElement weDialogDelete;
	@FindBy(xpath = "//button[text()='Cancel']")
	private WebElement weDialogCancel;
	@FindBy(xpath = "//form[@id='disable-modal']//button[@class='btn btn-default']")
	private WebElement weCancelEnabled;
	@FindBy(xpath = "//form[@id='disable-modal']//i[@class='fas fa-minus-circle']")
	private WebElement weEnable;
	@FindBy(xpath = "//form[@id='disable-modal']//button[@class='btn btn-default']")
	private WebElement weCancelDisable;
	@FindBy(xpath = "//form[@id='disable-modal']//i[@class='fas fa-minus-circle']")
	private WebElement weDisable;
	@FindBy(xpath = "//form[@id='important-modal']//button[@class='btn btn-default']")
	private WebElement weCancelImportant;
	@FindBy(xpath = "//tbody[1]/tr[1]//i[@class='fas fa-bookmark']")
	private WebElement weImportant;
	@FindBy(xpath = "//form[@id='unimportant-modal']//button[@class='btn btn-default']")
	private WebElement weCancelUnimportant;
	@FindBy(xpath = "//button[contains(.,'Set as Unimportant')]")
	private WebElement weUnimportant;
	private WebElement weTableHeader;
	
	
	public  PostListPage(WebDriver driver, WebDriverWait driverWait) {
		super();
		this.driver = driver;
		this.driverWait = driverWait;
		this.driver.get(PAGE_URL);
		this.driver.manage().window().maximize();
		PageFactory.initElements(driver, this);
	}
	
	public void openPage() {
		this.driver.get(PAGE_URL);
	}
	
	public void openLinkParentInManu(String title) {
			WebElement weManu = driver.findElement(By.xpath("//p[text()='"+title+"']//ancestor::li[2]"));
				
			if(!weManu.getAttribute("class").toString().equalsIgnoreCase("nav-item has-treeview menu-open")) {
			weManu.click();
			}
		}
	
	public void clickOnLinkInMenu(String title) {
		WebElement weLink = driver.findElement(By.xpath("//p[text()='"+title+"']"));
		driverWait.until(ExpectedConditions.visibilityOf(weLink));
		weLink.click();
	}
	
	public void clickOnNavigationLikn(String title) {
		WebElement weLink = driver.findElement(By.xpath("//a[text()='"+title+"']"));
		weLink.click();
	}
		
	public void clickOnAddNewPost() {
		weAddNewPost.click();
	}
	
	public void clickOnSave() {
//		WebElement weButtonSave = driver.findElement(By.xpath("//button[@type='submit']"));
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].scrollIntoView();", weButtonSave);
//		weButtonSave.click();
		
//		WebElement weButtonSave = driver.findElement(By.xpath("//button[@type='submit']"));
//		Actions actions = new Actions(driver);
//		actions.moveToElement(weButtonSave).click().perform();
//		weButtonSave.click();
		
		
		FluentWait<WebDriver> wait = null;
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit']")));
	}
		
	public boolean isPostInPage(String title) {		
		ArrayList<WebElement> wePosts = (ArrayList<WebElement>) driver.findElements(By.xpath("//td[text()='"+title+"']"));
		
		return !wePosts.isEmpty();
	}
	
	public void clickOnReadPosts(String title) {
		WebElement weReadButton = driver.findElement(By.xpath("//td[text()='"+title+"']//ancestor::tr//td[12]//div[1]//a[1]"));
		weReadButton.click();
	}
	
	public void clickOnEditPosts(String title) {
		WebElement weEditButton  = driver.findElement(By.xpath("//td[text()='"+title+"']//ancestor::tr//td[12]//div[1]//a[2]"));
		weEditButton.click();		
	}
	
	public void clickOnDeletePosts(String title) {
		WebElement weDeleteButton  = driver.findElement(By.xpath("//td[text()='"+title+"']//ancestor::tr//td[12]//div[1]//button"));
		weDeleteButton.click();		
	}
		
	public void clickOnDialogCancel() {
		driverWait.until(ExpectedConditions.visibilityOf(weDialogCancel));
		weDialogCancel.click();
	}
	
	public void clickOnDialogDelete() {
		driverWait.until(ExpectedConditions.visibilityOf(weDialogDelete));
		weDialogDelete.click();
	}
	
	public void clickOnEnablePosts(String title) {
		WebElement weEnableButton = driver.findElement(By.xpath("//td[text()='"+title+"']//ancestor::tr//td[12]//div[2]//button[1]"));
		weEnableButton.click();
	}
	
	public void clickOnCancelEnabled() {
		driverWait.until(ExpectedConditions.visibilityOf(weCancelEnabled));
		weCancelEnabled.click();
	}
	
	public void clickOnEnabled() {
		driverWait.until(ExpectedConditions.visibilityOf(weEnable));
		weEnable.click();
	}
	
	public void clickOnDisablePosts(String title) {
		WebElement weDisableButton = driver.findElement(By.xpath("//td[text()='"+title+"']//ancestor::tr//td[12]//div[2]//button[1]"));
		weDisableButton.click();
	}
	
	public void clickOnCancelDisable() {
		driverWait.until(ExpectedConditions.visibilityOf(weCancelDisable));
		weCancelEnabled.click();
	}
	
	public void clickOnDisable() {
		driverWait.until(ExpectedConditions.visibilityOf(weDisable));
		weDisable.click();
	}
	
	public void clickOnImportantPosts(String title) {
		WebElement weImportantButton = driver.findElement(By.xpath("//td[text()='"+title+"']//ancestor::tr//td[12]//div[2]//button[2]"));
		weImportantButton.click();
	}
	
	public void clickOnCancelImportant() {
		driverWait.until(ExpectedConditions.visibilityOf(weCancelImportant));
		weCancelImportant.click();
	}
	
	public void clickOnImportant() {
		driverWait.until(ExpectedConditions.visibilityOf(weImportant));
		weImportant.click();
	}
	
	public void clickOnUnimportantPosts(String title) {
		WebElement weUnimportantButton = driver.findElement(By.xpath("//td[text()='"+title+"']//ancestor::tr//td[12]//div[2]//button[2]"));
		weUnimportantButton.click();
	}
	
	public void clickOnCancelUnimportant() {
		driverWait.until(ExpectedConditions.visibilityOf(weCancelUnimportant));
		weCancelUnimportant.click();
	}
	
	public void clickOnUnimportant() {
		driverWait.until(ExpectedConditions.visibilityOf(weUnimportant));
		weUnimportant.click();
	}

	public void clickOnTableHeader() {
		driverWait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(5));
		driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//th[@class='sorting_desc']")));
		weTableHeader = driver.findElement(By.xpath("//th[@class='sorting_desc']"));
		weTableHeader.click();
	}
}
