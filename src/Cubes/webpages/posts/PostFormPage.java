package Cubes.webpages.posts;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
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
	@FindBy(id="set-as-important")
	private WebElement weRadioButtonImportant;
	@FindBy(id="tag-checkbox-8")
	private WebElement weCheckBoxTags;
	@FindBy(xpath="//input[@type='file']")
	private WebElement weButtonChooseNewPhoto;
	@FindBy(xpath="//body[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']//child::p[1]")
	private WebElement weAreaContent;
	@FindBy(xpath="//button[@type='submit']")
	private WebElement weButtonSave;
	@FindBy(xpath="//a[@href='https://testblog.kurs-qa.cubes.edu.rs/admin/posts']/p")
	private WebElement weButtonCancel;
	@FindBy(id="title-error")
	private WebElement weErrorTitle;
	@FindBy(id="description-error")
	private WebElement weErrorDescription;	
	@FindBy(id="tag_id[]-error")
	private WebElement weErrorTags;
	@FindBy(xpath="//div[@class='invalid-feedback']")
	private WebElement weErrorPhotos;
	@FindBy(xpath="//class['invalid-feedback']")
	private WebElement weErrorContent;
	@FindBy(xpath="//ul[@class='navbar-nav']")
	private WebElement weHamburger;

	
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
		this.weHamburger.click();
	}
	
	public void clickOnSave() {
//		Actions actions = new Actions(driver);
//		actions.sendKeys(Keys.END).perform();
//		actions.keyDown(Keys.CONTROL).sendKeys(Keys.SUBTRACT).sendKeys(Keys.SUBTRACT).sendKeys(Keys.SUBTRACT).sendKeys(Keys.SUBTRACT).sendKeys(Keys.SUBTRACT).keyUp(Keys.CONTROL).perform();
		
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("document.body.style.zoom='80%'");
//		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(2000));
//		weButtonSave = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit']")));
		
//		actions.moveToElement(weButtonSave).perform();
//		try {
//			driverWait.wait(2000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		weHamburger.click();
//		weButtonSave.click();
	}
	
	public void clickOnCancel() {
		weButtonCancel.click();
	}
	
	public void dropdownCategory(String category) {
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
	
	public void clickOnRadioButtonImportant() {
		weRadioButtonImportant.click();
	}
	
	public void unselectOnCheckBoxTags() {
		if (weCheckBoxTags.isSelected()) {
			weCheckBoxTags.click();
		}
	}
	
	public void selectOnCheckBoxTags() {
		if (!weCheckBoxTags.isSelected()) {
			weCheckBoxTags.click();
		}
	}
	
	
	public void uploadImage() {
		File file = new File("./Screenshot_1.png");
		weButtonChooseNewPhoto.sendKeys(file.getAbsolutePath());
	}
	
	public void uploadNotImage() {
		File file = new File("./pom.xml");
		weButtonChooseNewPhoto.sendKeys(file.getAbsolutePath());
	}
	
	public void inputStringInContent(String content) {
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[1]")));
		driver.findElement(By.cssSelector("body")).sendKeys("valid content");
	}
		
	public String getTitleInputError() {
		return weErrorTitle.getText();
	}
	
	public String getDescriptionInputError() {
		return weErrorDescription.getText();
	}
	
	public String getTagsInputError() {
		return weErrorTags.getText();
	}
	
	public String getErrorChooseNewPhoto() {
		return weErrorPhotos.getText();
	}
	
	public String getContentInputError() {
		return weErrorContent.getText();
	}
}


