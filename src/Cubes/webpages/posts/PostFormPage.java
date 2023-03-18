package Cubes.webpages.posts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PostFormPage {


	private WebDriver driver;
	private WebDriverWait driverWait;
	private static final String PAGE_URL ="https://testblog.kurs-qa.cubes.edu.rs/admin/posts/add";
	//WebElements
	@FindBy(name="post_category_id")
	private WebElement weDropdownCategory;
	@FindBy(name="title")
	private WebElement weInputTitle;
	@FindBy(name="description")
	private WebElement weInputDescription;
	@FindBy(xpath="//label[@class='custom-control-label']")
	private WebElement weImportant;
	@FindBy(name="tag_id[]")
	private WebElement weTags;
	@FindBy(name="photo")
	private WebElement weChooseNewPhoto;
	@FindBy(xpath="//html[@dir='ltr']")
	private WebElement weContent;
	@FindBy(xpath="//button[@type='submit']")
	private WebElement weButtonSave;
	@FindBy(xpath="//a[@href='https://testblog.kurs-qa.cubes.edu.rs/admin/posts']")
	private WebElement weButtonCancel;
	@FindBy()
	private WebElement weErrorTitle;
	@FindBy()
	private WebElement weErrorDescription;
	@FindBy()
	private WebElement weErrorCategory;
	
	public PostFormPage(WebDriver driver, WebDriverWait driverWait) {
		this.driver = driver;
		this.driverWait = driverWait;
		this.driver.get(PAGE_URL);
		this.driver.manage().window().maximize();
		PageFactory.initElements(driver, this);
	}
	
	public void LoginPage(WebDriver driver) {
		this.driver = driver;
		this.driver.get(PAGE_URL);
		this.driver.manage().window().maximize();
		PageFactory.initElements(driver, this);
	}
	
	public void PostListPage(WebDriver driver) {
		this.driver = driver;
		this.driverWait = driverWait;
		this.driver.get(PAGE_URL);
		this.driver.manage().window().maximize();
		PageFactory.initElements(driver, this);
	}
	
	public void openPage() {
		this.driver.get(PAGE_URL);
	}
	
	public void clickOnSave() {
		weButtonSave.click();
	}
	
	public void clickOnCancel() {
		weButtonCancel.click();
	}
	
	public void dropdownCategory(String category) {
		weDropdownCategory.clear();
		weDropdownCategory.sendKeys(category);
	}

	public void inputStringInTitle(String title) {
		weInputTitle.clear();
		weInputTitle.sendKeys(title);
	}
	
	public void inputStrigInDescription(String descritpion) {
		weInputDescription.clear();
		weInputDescription.sendKeys(descritpion);
	}
	
	public void buttonImportant(String important) {
		weImportant.clear();
		weImportant.sendKeys(important);
	}
	
	public void buttonTags(String tags) {
		weTags.clear();
		weTags.sendKeys(tags);
	}
	
	public void weChooseNewPhoto(String photo) {
		weChooseNewPhoto.clear();
		weChooseNewPhoto.sendKeys(photo);
	}
	
	public void weContent(String content) {
		weContent.clear();
		weContent.sendKeys(content);
		
	}
}


