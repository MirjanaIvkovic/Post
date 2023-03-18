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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
