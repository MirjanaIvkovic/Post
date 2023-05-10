package Cubes.test;

import static org.junit.Assert.*;

import java.time.Duration;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Cubes.webpage.LoginPage;
import Cubes.webpages.posts.PostFormPage;
import Cubes.webpages.posts.PostListPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestAddPosts {

	private static ChromeDriver driver;
	private static LoginPage loginPage;
	private static PostFormPage postFormPage;
	private static PostListPage postListPage;
	
	private static String addPostsTitle;
	private static String addPostsDescription;
	private static String addPostsContent;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrom.driver", "C:\\Users\\Korisnik\\Desktop\\WebDriver\\chromedriver");
	

		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		driver = new ChromeDriver(options);

		WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofMillis(1000));
		
		loginPage = new LoginPage(driver);
		postListPage = new PostListPage(driver, driverWait);
		postFormPage = new PostFormPage(driver, driverWait);
		loginPage.loginSuccess();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		driver.close();
	}

	@Before
	public void setUp() throws Exception {
		postListPage.openPage();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void  tc01TestMenuLinks() {
		checkMenuLink("Sliders list","https://testblog.kurs-qa.cubes.edu.rs/admin/sliders");
		checkMenuLink("Add Slider","https://testblog.kurs-qa.cubes.edu.rs/admin/sliders/add");
		checkMenuLink("Post Categories list","https://testblog.kurs-qa.cubes.edu.rs/admin/post-categories");
		checkMenuLink("Add Post Category","https://testblog.kurs-qa.cubes.edu.rs/admin/post-categories/add");
		checkMenuLink("Tags list","https://testblog.kurs-qa.cubes.edu.rs/admin/tags");
		checkMenuLink("Posts list","https://testblog.kurs-qa.cubes.edu.rs/admin/posts");
		checkMenuLink("Add Post","https://testblog.kurs-qa.cubes.edu.rs/admin/posts/add");
		checkMenuLink("Comments List","https://testblog.kurs-qa.cubes.edu.rs/admin/comments");
		checkMenuLink("Users List","https://testblog.kurs-qa.cubes.edu.rs/admin/users");
		checkMenuLink("Add User","https://testblog.kurs-qa.cubes.edu.rs/admin/users/add");
	}
	
	@Test
	public void tc02TestNavigationLink() {
		checkNavigationLink("Home", "https://testblog.kurs-qa.cubes.edu.rs/admin");
	}
	
	@Test 
	public void tc03TestNavigationLink() {
		postListPage.clickOnAddNewPost();
		
		checkNavigationLink("Post", "https://testblog.kurs-qa.cubes.edu.rs/admin/posts");
	}
	

	@Test
	public void tc04TestAddPostAllFieldsEmpty() {
		postListPage.clickOnAddNewPost();
				
		postFormPage.inputStringInTitle("");
		
		postFormPage.inputStrigInDescription("");
			
		postFormPage.unselectOnCheckBoxTags();
		
		postFormPage.inputStringInContent("");
		
		postFormPage.clickOnSave();
		
		assertEquals(postFormPage.getTitleInputError(), "This field is required.", "Bad error string on Title input");
		
		assertEquals(postFormPage.getDescriptionInputError(), "This field is required.", "Bad error string on Description input");
		
		assertEquals(postFormPage.getTagsInputError(), "This field is required.", "Bad error string on Tags input");
		
		assertEquals(postFormPage.getContentInputError(), "The content field is required.", "Bad error string on Content input");
	}
	
	@Test
	public void tc05TestAddPostCategorySelectedAllOtherInputEmpty() {
		postListPage.clickOnAddNewPost();
	
		postFormPage.dropdownCategory("Clarkstad");
		
		postFormPage.inputStringInTitle("");
	
		postFormPage.inputStrigInDescription("");
		
		postFormPage.unselectOnCheckBoxTags();
	
		postFormPage.inputStringInContent("");
	
		postFormPage.clickOnSave();
	
		assertEquals(postFormPage.getTitleInputError(), "This field is required.", "Bad error string on Title input");
	
		assertEquals(postFormPage.getDescriptionInputError(), "This field is required.", "Bad error string on Description input");
	
		assertEquals(postFormPage.getTagsInputError(), "This field is required.", "Bad error string on Tags input");
	
		assertEquals(postFormPage.getContentInputError(), "The content is required.", "Bad error string on Content input");
}
	
	@Test
	public void tc06TestAddPostCategorySelectedInvalidTitleAllOtherInputEmpty() {
		postListPage.clickOnAddNewPost();
	
		postFormPage.dropdownCategory("Clarkstad");
		
		postFormPage.inputStringInTitle("Lorem Ipsum");
	
		postFormPage.inputStrigInDescription("");
		
		postFormPage.unselectOnCheckBoxTags();
	
		postFormPage.inputStringInContent("");
	
		postFormPage.clickOnSave();
	
		assertEquals(postFormPage.getTitleInputError(), "Please enter at least 20 characters.", "Bad error string on Title input");
	
		assertEquals(postFormPage.getDescriptionInputError(), "This field is required.", "Bad error string on Description input");
	
		assertEquals(postFormPage.getTagsInputError(), "This field is required.", "Bad error string on Tags input");
	
		assertEquals(postFormPage.getContentInputError(), "The content is required.", "Bad error string on Content input");
}
	
	@Test
	public void tc07TestAddPostCategorySelectedValidTitleAllOtherInputEmpty() {
		postListPage.clickOnAddNewPost();
	
		postFormPage.dropdownCategory("Clarkstad");
		
		postFormPage.inputStringInTitle("Where does it come from?");
	
		postFormPage.inputStrigInDescription("");
		
		postFormPage.unselectOnCheckBoxTags();
	
		postFormPage.inputStringInContent("");
	
		postFormPage.clickOnSave();
		
		assertEquals(postFormPage.getDescriptionInputError(), "This field is required.", "Bad error string on Description input");
	
		assertEquals(postFormPage.getTagsInputError(), "This field is required.", "Bad error string on Tags input");
	
		assertEquals(postFormPage.getContentInputError(), "The content is required.", "Bad error string on Content input");
}
	
	@Test
	public void tc08TestAddPostCategorySelectedInvalidDescriptionAllOtherInputEmpty() {
		postListPage.clickOnAddNewPost();
	
		postFormPage.dropdownCategory("Clarkstad");
		
		postFormPage.inputStringInTitle("");
	
		postFormPage.inputStrigInDescription("Contrary to popular belief, Lorem Ipsum");
		
		postFormPage.unselectOnCheckBoxTags();
	
		postFormPage.inputStringInContent("");
	
		postFormPage.clickOnSave();
	
		assertEquals(postFormPage.getTitleInputError(), "This field is required.", "Bad error string on Title input");
	
		assertEquals(postFormPage.getDescriptionInputError(), "Please enter at least 50 characters.", "Bad error string on Description input");
	
		assertEquals(postFormPage.getTagsInputError(), "This field is required.", "Bad error string on Tags input");
	
		assertEquals(postFormPage.getContentInputError(), "The content is required.", "Bad error string on Content input");
	}
	
	@Test
	public void tc09TestAddPostCategorySelectedValidDescriptionAllOtherInputEmpty() {
		postListPage.clickOnAddNewPost();
	
		postFormPage.dropdownCategory("Clarkstad");
		
		postFormPage.inputStringInTitle("");
	
		postFormPage.inputStrigInDescription("Contrary to popular belief, Lorem Ipsumis not simply random text.");
		
		postFormPage.unselectOnCheckBoxTags();
	
		postFormPage.inputStringInContent("");
	
		postFormPage.clickOnSave();
	
		assertEquals(postFormPage.getTitleInputError(), "This field is required.", "Bad error string on Title input");
		
		assertEquals(postFormPage.getTagsInputError(), "This field is required.", "Bad error string on Tags input");
	
		assertEquals(postFormPage.getContentInputError(), "The content is required.", "Bad error string on Content input");
}
	
	@Test
	public void tc10TestAddPostCategorySelectedInvalidTitleInvalidDescriptionAllOtherFieldEmpty() {
		postListPage.clickOnAddNewPost();
	
		postFormPage.dropdownCategory("Clarkstad");
		
		postFormPage.inputStringInTitle("Lorem Ipsum");
	
		postFormPage.inputStrigInDescription("Contrary to popular belief, Lorem Ipsumis");
		
		postFormPage.unselectOnCheckBoxTags();
	
		postFormPage.inputStringInContent("");
	
		postFormPage.clickOnSave();
		
		assertEquals(postFormPage.getTitleInputError(), "Please enter at least 20 characters.", "Bad error string on Title input");
		
		assertEquals(postFormPage.getDescriptionInputError(), "Please enter at least 50 characters.", "Bad error string on Description input");
	
		assertEquals(postFormPage.getTagsInputError(), "This field is required.", "Bad error string on Tags input");
	
		assertEquals(postFormPage.getContentInputError(), "The content is required.", "Bad error string on Content input");
	}
	
	@Test
	public void tc11TestAddPostCategorySelectedValidTitleValidDescriptionAllOtherFieldEmpty() {
		postListPage.clickOnAddNewPost();
	
		postFormPage.dropdownCategory("Clarkstad");
		
		postFormPage.inputStringInTitle("Where does it come from?");
	
		postFormPage.inputStrigInDescription("Contrary to popular belief, Lorem Ipsumis not simply random text.");
		
		postFormPage.unselectOnCheckBoxTags();
	
		postFormPage.inputStringInContent("");
	
		postFormPage.clickOnSave();
			
		assertEquals(postFormPage.getTagsInputError(), "This field is required.", "Bad error string on Tags input");
	
		assertEquals(postFormPage.getContentInputError(), "The content is required.", "Bad error string on Content input");
	}
	
	@Test
	public void tc12TestAddPostTagsSelectedAllOtherFieldEmpty() {
		postListPage.clickOnAddNewPost();
	
		postFormPage.dropdownCategory("");
		
		postFormPage.inputStringInTitle("");
	
		postFormPage.inputStrigInDescription("");
		
		postFormPage.selectOnCheckBoxTags();
	
		postFormPage.inputStringInContent("");
	
		postFormPage.clickOnSave();
			
		assertEquals(postFormPage.getTitleInputError(), "This field is required.", "Bad error string on Title input");
		
		assertEquals(postFormPage.getDescriptionInputError(), "This field is required.", "Bad error string on Description input");
		
		assertEquals(postFormPage.getTagsInputError(), "This field is required.", "Bad error string on Tags input");
	
		assertEquals(postFormPage.getContentInputError(), "The content is required.", "Bad error string on Content input");
	}
	
	@Test
	public void tc13TestAddPostValidContentAllOtherFieldEmpty() {
		postListPage.clickOnAddNewPost();
	
		postFormPage.dropdownCategory("");
		
		postFormPage.inputStringInTitle("");
	
		postFormPage.inputStrigInDescription("");
		
		postFormPage.unselectOnCheckBoxTags();
	
		postFormPage.inputStringInContent("The first line of Lorem Ipsum");
	
		postFormPage.clickOnSave();
			
		assertEquals(postFormPage.getTitleInputError(), "This field is required.", "Bad error string on Title input");
		
		assertEquals(postFormPage.getDescriptionInputError(), "This field is required.", "Bad error string on Description input");
		
		assertEquals(postFormPage.getTagsInputError(), "This field is required.", "Bad error string on Tags input");
	}
	
	@Test
	public void tc14TestAddPostSelectedImportantAllOtherFieldEmpty() {
		postListPage.clickOnAddNewPost();
	
		postFormPage.dropdownCategory("");
		
		postFormPage.inputStringInTitle("");
	
		postFormPage.inputStrigInDescription("");
		
		postFormPage.clickOnRadioButtonImportant();
		
		postFormPage.unselectOnCheckBoxTags();
	
		postFormPage.inputStringInContent("");
	
		postFormPage.clickOnSave();
			
		assertEquals(postFormPage.getTitleInputError(), "This field is required.", "Bad error string on Title input");
		
		assertEquals(postFormPage.getDescriptionInputError(), "This field is required.", "Bad error string on Description input");
		
		assertEquals(postFormPage.getTagsInputError(), "This field is required.", "Bad error string on Tags input");
		
		assertEquals(postFormPage.getContentInputError(), "The content is required.", "Bad error string on Content input");
	}
	
	@Test
	public void tc15TestAddPostInvalidFileForImageAllOtherFieldEmpty() {
		postListPage.clickOnAddNewPost();
	
		postFormPage.dropdownCategory("");
		
		postFormPage.inputStringInTitle("");
	
		postFormPage.inputStrigInDescription("");
		
		postFormPage.clickOnRadioButtonImportant();
		
		postFormPage.unselectOnCheckBoxTags();
		
		postFormPage.uploadNotImage();
	
		postFormPage.inputStringInContent("");
	
		postFormPage.clickOnSave();
			
		assertEquals(postFormPage.getTitleInputError(), "This field is required.", "Bad error string on Title input");
		
		assertEquals(postFormPage.getDescriptionInputError(), "This field is required.", "Bad error string on Description input");
		
		assertEquals(postFormPage.getTagsInputError(), "This field is required.", "Bad error string on Tags input");
		
		assertEquals(postFormPage.getContentInputError(), "The content is required.", "Bad error string on Content input");
	}
	
	@Test
	public void tc16TestAddPostValidFileForImageAllOtherFieldEmpty() {
		postListPage.clickOnAddNewPost();
	
		postFormPage.dropdownCategory("");
		
		postFormPage.inputStringInTitle("");
	
		postFormPage.inputStrigInDescription("");
		
		//postFormPage.clickOnRadioButtonImportant();
		
		postFormPage.unselectOnCheckBoxTags();
	
		postFormPage.uploadImage();
		
		postFormPage.inputStringInContent("");
	
		postFormPage.clickOnSave();
			
		assertEquals(postFormPage.getTitleInputError(), "This field is required.", "Bad error string on Title input");
		
		assertEquals(postFormPage.getDescriptionInputError(), "This field is required.", "Bad error string on Description input");
		
		assertEquals(postFormPage.getTagsInputError(), "This field is required.", "Bad error string on Tags input");
		
		assertEquals(postFormPage.getContentInputError(), "The content is required.", "Bad error string on Content input");
	}
		
	@Test
	public void tc17TestAddPostInvalidTitleValidDescriptionAndEmptyAllOtherFields() {
		postListPage.clickOnAddNewPost();
		
		postFormPage.inputStringInTitle("Lorem Ipsum");
		
		postFormPage.inputStrigInDescription("Contrary to popular belief, Lorem Ipsum is not simply random text.");
					
		postFormPage.unselectOnCheckBoxTags();
		
		postFormPage.inputStringInContent("");
		
		postFormPage.clickOnSave();

		assertEquals(postFormPage.getTitleInputError(), "Please enter at least 20 characters.", "Bad error string on Title input");
				
		assertEquals(postFormPage.getTagsInputError(), "This field is required.", "Bad error string on Tags input");
		
		assertEquals(postFormPage.getContentInputError(), "The content is required.", "Bad error string on Content input");
	}
	
	@Test
	public void tc18TestAddPostValidTitleInvalidDescriptionAndEmptyAllOtherFields() {
		postListPage.clickOnAddNewPost();
		
		postFormPage.inputStringInTitle("Where does it come from?");
		
		postFormPage.inputStrigInDescription("Contrary to popular belief, Lorem Ipsum");
					
		postFormPage.unselectOnCheckBoxTags();
		
		postFormPage.inputStringInContent("");
		
		postFormPage.clickOnSave();

		assertEquals(postFormPage.getDescriptionInputError(), "Please enter at least 50 characters.", "Bad error string on Description input");
		
		assertEquals(postFormPage.getTagsInputError(), "This field is required.", "Bad error string on Tags input");
		
		assertEquals(postFormPage.getContentInputError(), "The content is required.", "Bad error string on Content input");
	}
	
	@Test
	public void tc19TestAddPostInvalidTitleInvalidDescriptionTagsSelectedAndEmptyAllOtherFields() {
		postListPage.clickOnAddNewPost();
		
		postFormPage.inputStringInTitle("Lorem Ipsum");
		
		postFormPage.inputStrigInDescription("Contrary to popular belief, Lorem Ipsum");
					
		postFormPage.selectOnCheckBoxTags();
		
		postFormPage.inputStringInContent("");
		
		postFormPage.clickOnSave();

		assertEquals(postFormPage.getTitleInputError(), "Please enter at least 20 characters.", "Bad error string on Title input");
		
		assertEquals(postFormPage.getDescriptionInputError(), "Please enter at least 50 characters.", "Bad error string on Description input");
				
		assertEquals(postFormPage.getContentInputError(), "The content is required.", "Bad error string on Content input");
	}
	
	@Test
	public void tc20TestAddPostValidTitleInvalidDescriptionTagsSelectedAndEmptyAllOtherFields() {
		postListPage.clickOnAddNewPost();
		
		postFormPage.inputStringInTitle("Where does it come from?");
		
		postFormPage.inputStrigInDescription("Contrary to popular belief, Lorem Ipsum");
					
		postFormPage.selectOnCheckBoxTags();
		
		postFormPage.inputStringInContent("");
		
		postFormPage.clickOnSave();
		
		assertEquals(postFormPage.getDescriptionInputError(), "Please enter at least 50 characters.", "Bad error string on Description input");
				
		assertEquals(postFormPage.getContentInputError(), "The content is required.", "Bad error string on Content input");
	}
	
	@Test
	public void tc21TestAddPostInvalidTitleValidDescriptionTagsSelectedAndEmptyAllOtherFields() {
		postListPage.clickOnAddNewPost();
		
		postFormPage.inputStringInTitle("Lore Ipsum");
		
		postFormPage.inputStrigInDescription("Contrary to popular belief, Lorem Ipsum is not simply random text.");
					
		postFormPage.selectOnCheckBoxTags();
		
		postFormPage.inputStringInContent("");
		
		postFormPage.clickOnSave();
		
		assertEquals(postFormPage.getTitleInputError(), "Please enter at least 20 characters.", "Bad error string on Description input");
				
		assertEquals(postFormPage.getContentInputError(), "The content is required.", "Bad error string on Content input");
	}
	
	@Test
	public void tc22TestAddPostValidTitleValidDescriptionTagsSelectedAndEmptyAllOtherFields() {
		postListPage.clickOnAddNewPost();
		
		postFormPage.inputStringInTitle("Where does it come from?");
		
		postFormPage.inputStrigInDescription("Contrary to popular belief, Lorem Ipsum is not simply random text.");
					
		postFormPage.selectOnCheckBoxTags();
		
		postFormPage.inputStringInContent("");
		
		postFormPage.clickOnSave();
		
		assertEquals(postFormPage.getContentInputError(), "The content is required.", "Bad error string on Content input");
	}
	
	@Test
	public void tc23TestAddPostInvalidTitleAddedContentAndEmptyAllOtherFields() {
		postListPage.clickOnAddNewPost();
		
		postFormPage.inputStringInTitle("Lorem Ipsum");
		
		postFormPage.inputStrigInDescription("");
					
		postFormPage.unselectOnCheckBoxTags();
		
		postFormPage.inputStringInContent("The first line of Lorem Ipsum");
		
		postFormPage.clickOnSave();
		
		assertEquals(postFormPage.getTitleInputError(), "Please enter at least 20 characters.", "Bad error string on Title input");

		assertEquals(postFormPage.getDescriptionInputError(), "This field is required.", "Bad error string on Description input");

		assertEquals(postFormPage.getTagsInputError(), "This field is required.", "Bad error string on Tags input");
	}
	
	@Test
	public void tc24TestAddPostInvalidDescriptionAddedContentAndEmptyAllOtherFields() {
		postListPage.clickOnAddNewPost();
		
		postFormPage.inputStringInTitle("");
		
		postFormPage.inputStrigInDescription("Contrary to popular belief, Lorem Ipsum");
					
		postFormPage.unselectOnCheckBoxTags();
		
		postFormPage.inputStringInContent("The first line of Lorem Ipsum");
		
		postFormPage.clickOnSave();
		
		assertEquals(postFormPage.getTitleInputError(), "This field is required.", "Bad error string on Title input");

		assertEquals(postFormPage.getDescriptionInputError(), "Please enter at least 50 characters.", "Bad error string on Description input");

		assertEquals(postFormPage.getTagsInputError(), "This field is required.", "Bad error string on Tags input");
	}
	
	@Test
	public void tc25TestAddPostValidDescriptionAddedContentAndEmptyAllOtherFields() {
		postListPage.clickOnAddNewPost();
		
		postFormPage.inputStringInTitle("");
		
		postFormPage.inputStrigInDescription("Contrary to popular belief, Lorem Ipsum is not simply random text.");
					
		postFormPage.unselectOnCheckBoxTags();
		
		postFormPage.inputStringInContent("The first line of Lorem Ipsum");
		
		postFormPage.clickOnSave();
		
		assertEquals(postFormPage.getTitleInputError(), "This field is required.", "Bad error string on Title input");
		
		assertEquals(postFormPage.getTagsInputError(), "This field is required.", "Bad error string on Tags input");
	}
	
	@Test
	public void tc26TestAddPostSelectTagAddedContentAndEmptyAllOtherFields() {
		postListPage.clickOnAddNewPost();
		
		postFormPage.inputStringInTitle("");
		
		postFormPage.inputStrigInDescription("");
					
		postFormPage.selectOnCheckBoxTags();
		
		postFormPage.inputStringInContent("The first line of Lorem Ipsum");
		
		postFormPage.clickOnSave();
		
		assertEquals(postFormPage.getTitleInputError(), "This field is required.", "Bad error string on Tags input");
		
		assertEquals(postFormPage.getDescriptionInputError(), "This field is required.", "Bad error string on Description input");
	}
	
	@Test
	public void tc27TestAddPostInvalidTitleInvalidDescriptionAddedContentAndEmptyAllOtherFields() {
		postListPage.clickOnAddNewPost();
		
		postFormPage.inputStringInTitle("Lorem Ipsum");
		
		postFormPage.inputStrigInDescription("Contrary to popular belief, Lorem Ipsum");
					
		postFormPage.unselectOnCheckBoxTags();
		
		postFormPage.inputStringInContent("The first line of Lorem Ipsum");
		
		postFormPage.clickOnSave();

		assertEquals(postFormPage.getTitleInputError(), "Please enter at least 20 characters.", "Bad error string on Title input");
	
		assertEquals(postFormPage.getDescriptionInputError(), "Please enter at least 50 characters.", "Bad error string on Description input");
		
		assertEquals(postFormPage.getTagsInputError(), "This field is required.", "Bad error string on Tags input");
	}
	
	@Test
	public void tc28TestAddPostValidTitleInvalidDescriptionAddedContentAndEmptyAllOtherFields() {
		postListPage.clickOnAddNewPost();
		
		postFormPage.inputStringInTitle("Where does it come from?");
		
		postFormPage.inputStrigInDescription("Contrary to popular belief, Lorem Ipsum");
					
		postFormPage.unselectOnCheckBoxTags();
		
		postFormPage.inputStringInContent("The first line of Lorem Ipsum");
		
		postFormPage.clickOnSave();
	
		assertEquals(postFormPage.getDescriptionInputError(), "Please enter at least 50 characters.", "Bad error string on Description input");
		
		assertEquals(postFormPage.getTagsInputError(), "This field is required.", "Bad error string on Tags input");
	}
	
	@Test
	public void tc29TestAddPostValidTitleValidDescriptionAddedContentAndEmptyAllOtherFields() {
		postListPage.clickOnAddNewPost();
		
		postFormPage.inputStringInTitle("Where does it come from?");
		
		postFormPage.inputStrigInDescription("Contrary to popular belief, Lorem Ipsum is not simply random text.");
					
		postFormPage.unselectOnCheckBoxTags();
		
		postFormPage.inputStringInContent("The first line of Lorem Ipsum");
		
		postFormPage.clickOnSave();
			
		assertEquals(postFormPage.getTagsInputError(), "This field is required.", "Bad error string on Tags input");
	}
	
	@Test
	public void tc30TestAddPostInvalidTitleInvalidDescriptionTagSelectedAddedContentAndEmptyAllOtherFields() {
		postListPage.clickOnAddNewPost();
		
		postFormPage.inputStringInTitle("Lorem Ipsum");
		
		postFormPage.inputStrigInDescription("Contrary to popular belief, Lorem Ipsum.");
					
		postFormPage.selectOnCheckBoxTags();
		
		postFormPage.inputStringInContent("The first line of Lorem Ipsum");
		
		postFormPage.clickOnSave();
		
		assertEquals(postFormPage.getTitleInputError(), "Please enter at least 20 characters.", "Bad error string on Title input");
		
		assertEquals(postFormPage.getDescriptionInputError(), "Please enter at least 50 characters.", "Bad error string on Description input");
	}
	
	@Test
	public void tc31TestAddPostValidTitleInvalidDescriptionTagSelectedAddedContentAndEmptyAllOtherFields() {
		postListPage.clickOnAddNewPost();
		
		postFormPage.inputStringInTitle("Where does it come from?");
		
		postFormPage.inputStrigInDescription("Contrary to popular belief, Lorem Ipsum.");
					
		postFormPage.selectOnCheckBoxTags();
		
		postFormPage.inputStringInContent("The first line of Lorem Ipsum");
		
		postFormPage.clickOnSave();
				
		assertEquals(postFormPage.getDescriptionInputError(), "Please enter at least 50 characters.", "Bad error string on Description input");
	}
	
	@Test
	public void tc32TestAddPostInvalidTitleValidDescriptionTagSelectedAddedContentAndEmptyAllOtherFields() {
		postListPage.clickOnAddNewPost();
				
		postFormPage.inputStringInTitle("Lorem Ipsum");
		
		postFormPage.inputStrigInDescription("Contrary to popular belief, Lorem Ipsum is not simply random text.");
					
		postFormPage.selectOnCheckBoxTags();
		
		postFormPage.inputStringInContent("The first line of Lorem Ipsum");
		
		postFormPage.clickOnSave();
				
		assertEquals(postFormPage.getTitleInputError(), "Please enter at least 20 characters.", "Bad error string on Title input");
	}
	
	@Test
	public void tc33TestAddPostValidTitleValidDescriptionTagSelectedAddedContentAndEmptyAllOtherFields() {
		postListPage.clickOnAddNewPost();
				
		postFormPage.inputStringInTitle("Where does it come from?");
		
		postFormPage.inputStrigInDescription("Contrary to popular belief, Lorem Ipsum is not simply random text.");
					
		postFormPage.selectOnCheckBoxTags();
		
		postFormPage.inputStringInContent("The first line of Lorem Ipsum");
		
		postFormPage.clickOnSave();
		
		assertEquals(driver.getCurrentUrl(), "https://testblog.kurs-qa.cubes.edu.rs/admin/posts");
	}
	
	@Test
	public void tc34TestAddPostValidTitleValidDescriptionTagsSelectedAddedContentInvalidFileChosenForImage() {
		postListPage.clickOnAddNewPost();
		
		postFormPage.inputStringInTitle("Where does it come from?");
		
		postFormPage.inputStrigInDescription("Contrary to popular belief, Lorem Ipsum is not simply random text.");
					
		postFormPage.selectOnCheckBoxTags();
		
		postFormPage.inputStringInContent("The first line of Lorem Ipsum");
		
		postFormPage.uploadNotImage();
		
		postFormPage.clickOnSave();

		assertEquals(postFormPage.getErrorChooseNewPhoto(), "The photo must be an image. Bad error string on Choose New Photo dropbox");
	}
	
	@Test
	public void tc35TestAddPostValidTitleValidDescriptionTagsSelectedAddedContentValidFileChosenForImage() {
		postListPage.clickOnAddNewPost();
		
		postFormPage.inputStringInTitle("Where does it come from?");
		
		postFormPage.inputStrigInDescription("Contrary to popular belief, Lorem Ipsum is not simply random text.");
					
		postFormPage.selectOnCheckBoxTags();
		
		postFormPage.uploadImage();
		
		postFormPage.inputStringInContent("The first line of Lorem Ipsum");
		
		postFormPage.clickOnSave();		

		assertEquals(driver.getCurrentUrl(), "https://testblog.kurs-qa.cubes.edu.rs/admin/posts");
	}
	
	@Test
	public void tc36TestAddPostClickOnCancelButton() {
		postListPage.clickOnAddNewPost();
		
		postFormPage.clickOnCancel();

		assertEquals(driver.getCurrentUrl(), "https://testblog.kurs-qa.cubes.edu.rs/admin/posts");
	}
	
	@Test
	public void tc37TestPostReadAPost() {
		assertEquals(postListPage.isPostInPage("Animi ad explicabo magnam et."), true);
		
		postListPage.clickOnReadPosts("Animi ad explicabo magnam et.");
		
		assertEquals(driver.getCurrentUrl(), "https://testblog.kurs-qa.cubes.edu.rs/posts/single-post/5/animi-ad-explicabo-magnam-et");
	}
	
	@Test
	public void tc38TestPostEditAPost() {
		assertEquals(postListPage.isPostInPage("Animi ad explicabo magnam et."), true);
		
		postListPage.clickOnEditPosts("Animi ad explicabo magnam et.");
			
		assertEquals(driver.getCurrentUrl(), "https://testblog.kurs-qa.cubes.edu.rs/admin/posts/edit/5");
	}
	
	@Test
	public void tc39TestPostCancelEnableAPost() {
		assertEquals(postListPage.isPostInPage("Animi ad explicabo magnam et."), true);
		
		postListPage.clickOnEnablePosts("Animi ad explicabo magnam et.");
			
		postListPage.clickOnCancelEnabled();
	}
	
	@Test
	public void tc40TestPostEnableAPost() {
		assertEquals(postListPage.isPostInPage("Animi ad explicabo magnam et."), true);
		
		postListPage.clickOnEnablePosts("Animi ad explicabo magnam et.");
			
		postListPage.clickOnEnabled();
	}
	
	@Test
	public void tc41TestPostCancelDisableAPost() {
		assertEquals(postListPage.isPostInPage("Animi ad explicabo magnam et."), true);
		
		postListPage.clickOnDisablePosts("Animi ad explicabo magnam et.");
			
		postListPage.clickOnCancelDisable();
	}
	
	@Test
	public void tc42TestPostDisableAPost() {
		assertEquals(postListPage.isPostInPage("Animi ad explicabo magnam et."), true);
		
		postListPage.clickOnDisablePosts("Animi ad explicabo magnam et.");
			
		postListPage.clickOnDisable();
	}
	
	@Test
	public void tc43TestPostCancelImportantAPost() {
		assertEquals(postListPage.isPostInPage("Animi ad explicabo magnam et."), true);
		
		postListPage.clickOnDisablePosts("Animi ad explicabo magnam et.");
			
		postListPage.clickOnCancelImportant();
	}
	
	@Test
	public void tc44TestPostImportantAPost() {
		assertEquals(postListPage.isPostInPage("Animi ad explicabo magnam et."), true);
		
		postListPage.clickOnDisablePosts("Animi ad explicabo magnam et.");
			
		postListPage.clickOnImportant();
	}
	
	@Test
	public void tc45TestPostCancelUnimportantAPost() {
		assertEquals(postListPage.isPostInPage("Animi ad explicabo magnam et."), true);
		
		postListPage.clickOnDisablePosts("Animi ad explicabo magnam et.");
			
		postListPage.clickOnCancelUnimportant();
	}
	
	@Test
	public void tc46TestPostUnimportantAPost() {
		assertEquals(postListPage.isPostInPage("Animi ad explicabo magnam et."), true);
		
		postListPage.clickOnDisablePosts("Animi ad explicabo magnam et.");
			
		postListPage.clickOnUnimportant();
	}
	
	@Test
	public void tc47TestPostDialogCancelAPost() {
		assertEquals(postListPage.isPostInPage("Animi ad explicabo magnam et."), true);
		
		postListPage.clickOnDisablePosts("Animi ad explicabo magnam et.");
			
		postListPage.clickOnDialogCancel();
	}
	
	@Test
	public void tc48TestPostDialogDeleteAPost() {
		assertEquals(postListPage.isPostInPage("Animi ad explicabo magnam et."), true);
		
		postListPage.clickOnDisablePosts("Animi ad explicabo magnam et.");
			
		postListPage.clickOnDialogDelete();
	}
	public void checkMenuLink(String title, String url) {
		postListPage.openLinkParentInManu(title);
			
		postListPage.clickOnLinkInMenu(title);
		
		assertEquals("Bed url for " + title, url, driver.getCurrentUrl());

		postListPage.openPage();
	}
	
	public void checkNavigationLink(String title, String url) {
		postListPage.clickOnNavigationLikn(title);
		
		assertEquals("Bed url for " + title, url, driver.getCurrentUrl());
	
		postListPage.openPage();
	}
}