package Cubes.webpages.posts;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PostListPage {
	

	private WebDriver driver;
	private WebDriverWait driverWait;
	private static final String PAGE_URL = "https://testblog.kurs-qa.cubes.edu.rs/admin/posts";
	@FindBy(xpath="//a[@class='btn btn-success']")
	private WebElement weAddNewPost;
	
	public PostListPage(WebDriver driver, WebDriverWait driverWait) {
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
}
