package Cubes.test;

import static org.junit.Assert.*;

import java.time.Duration;

import Cubes.webpage.LoginPage;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestLoginPage {
	
	private static ChromeDriver driver;
	private static LoginPage loginPage;
	private final String EMAIL_VALID = "kursqa@cubes.edu.rs";
	private final String PASSWORD_VALID = "cubesqa";

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrom.driver", "C:\\Users\\Korisnik\\Desktop\\WebDriver\\chromedriver");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		
		driver = new ChromeDriver(options);
		WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofMillis(1000));
	
		loginPage = new LoginPage(driver);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		loginPage.openPage();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testLogin() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.inputStringInEmail(EMAIL_VALID);
		
		loginPage.inputStringInPassword(PASSWORD_VALID);
		
		loginPage.clickOnSignIn();
		
		assertEquals(driver.getCurrentUrl(), "http://testblog.kurs-qa.cubes.edu.rs/admin");
	}

}
