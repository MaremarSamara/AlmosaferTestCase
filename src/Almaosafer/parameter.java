package Almaosafer;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.asserts.Assertion;

import io.github.bonigarcia.wdm.WebDriverManager;

public class parameter {
	static WebDriver driver= new ChromeDriver();
	String NameTheWebsite="https://www.almosafer.com/en";
	
	Assertion Aassert =new Assertion();
	Random rand=new Random();
	String ExpectedLanguageArabic="العربية";
	String ExpectedLanguageEnglish="English";
	String ExpectedCurrancy="Sar";
	String ExpectedNumber="+966554400000";
	Boolean ActualValueOfQitafIsThere;
	String ExpectedHotelIsNotSelecte="false";
}
