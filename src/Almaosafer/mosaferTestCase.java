package Almaosafer;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class mosaferTestCase extends parameter{
	@BeforeTest
	public void mybefortest() {
		driver.get(NameTheWebsite); 
	}
	
	@Test(priority =1 )
	public void CheckLanguage() {
		String ActualLanguage=driver.findElement(By.xpath("//*[@id=\"__next\"]/header/div/div[1]/div[2]/div/a")).getText();
		Aassert.assertEquals(ActualLanguage, ExpectedLanguageArabic);
	}
	
	
	@Test
	public void CheckCurrancy() {
		String ActualCurrancy=driver.findElement(By.xpath("//*[@id=\"__next\"]/header/div/div[1]/div[2]/div/div/div/button")).getText();
		Aassert.assertEquals(ActualCurrancy, ExpectedCurrancy);
	}
	
	@Test
	public void CheckNumberIsCorrect() {
		String ActualNumber=driver.findElement(By.xpath("//*[@id=\"__next\"]/footer/div[2]/div/div/div/div/div[2]/div[3]/div/h4")).getText();
		Aassert.assertEquals(ActualNumber, ExpectedNumber);
	}
	
	@Test
	public void CheckQutafLogo() {
		//String QitafLogo=driver.findElement(By.xpath("//*[@id=\"__next\"]/footer/div[3]/div[3]/div[1]/div[2]/div/div[2]")).getText();
	     WebElement FooterLogo=driver.findElement(By.tagName("Footer"));
	     List<WebElement> ListOfSvgImages=FooterLogo.findElements(By.tagName("svg"));
	
	     for(int i=0;i<ListOfSvgImages.size();i++) {
		       String Qitaf =ListOfSvgImages.get(i).getAttribute("Footer_QitafLogo");
		       
		       if(Qitaf==null) {
		    	   continue;
	      }
		       else if(ListOfSvgImages.get(i).getAttribute("Footer_QitafLogo").contains("Qitaf")) {
		    	   ActualValueOfQitafIsThere=true;
		       }
	    
	}
	}
	
	@Test
	public void Check_Hotel_Is_Selected() {
		
		WebElement hotel=driver.findElement(By.xpath("//*[@id=\"uncontrolled-tab-example-tab-hotels\"]"));
		String ActualHotelSelected= hotel.getAttribute("aria-selected");
		 Aassert.assertEquals(ActualHotelSelected, ExpectedHotelIsNotSelecte);
		
	}
	
	
	
	
	@Test
	public void Check_Flight() {
		
		int numberExtra=1;
		
		String ActualDate=driver.findElement(By.xpath("//*[@id=\"uncontrolled-tab-example-tabpane-flights\"]/div/div[2]/div[1]/div/div[3]/div/div/div/div[1]")).getText();
		int theDateOfTheWebsite=Integer.parseInt(ActualDate);
		
		Date today= new Date();
		int ActualdateDay=today.getDate();
		
		//Calendar todayTime= Calendar.getInstance();
		 Aassert.assertEquals(theDateOfTheWebsite, ActualdateDay+numberExtra);
		
	}
	
	@Test
	public void Check_Flight_Return() {
		
		int numberExtra=2;
		
		String ActualDate=driver.findElement(By.xpath("//*[@id=\"uncontrolled-tab-example-tabpane-flights\"]/div/div[2]/div[1]/div/div[3]/div/div/div/div[2]")).getText();
		int theDateOfTheWebsite=Integer.parseInt(ActualDate);
		
		Date today= new Date();
		int ActualdateDay=today.getDate();
		
		//Calendar todayTime= Calendar.getInstance();
		 Aassert.assertEquals(theDateOfTheWebsite, ActualdateDay+numberExtra);
		
	}
	
	@Test
	
	public void Random_Check_The_Website_Language() {
		String [] language = {"https://www.almosafer.com/en","https://www.almosafer.com/ar"};	
		int Index= rand.nextInt(0, 2);
		driver.get(language[Index]);
		
		if(driver.getCurrentUrl().contains("ar")) {
			String lang=driver.findElement(By.xpath("//*[@id=\"__next\"]/header/div/div[1]/div[2]/div/a[1]")).getText();
			Aassert.assertEquals(lang, ExpectedLanguageEnglish);
		}
		
		else {
			String lang=driver.findElement(By.xpath("//*[@id=\"__next\"]/header/div/div[1]/div[2]/div/a[1]")).getText();
            Aassert.assertEquals(lang, ExpectedLanguageArabic);

		}
		
	}

@Test
	
	public void test_the_hotel_tab() {
	
	  String[] ArabicCountries= {"جدة","دبي"};
	  int IndexArabic= rand.nextInt(0, 2);
	  String[] EnglishCountries= {"Dubai","Jeddah","riyadh"};
	  int IndexEnglish= rand.nextInt(0, 3);
		String [] language = {"https://www.almosafer.com/en","https://www.almosafer.com/ar"};	
		int Index= rand.nextInt(0, 2);
		driver.get(language[Index]);
		
		if(driver.getCurrentUrl().contains("ar")) {
			 WebElement hotal_tab=driver.findElement(By.xpath("//*[@id=\"uncontrolled-tab-example-tab-hotels\"]"));
			 hotal_tab.click();
			 
			 WebElement searchBar=driver.findElement(By.xpath("//*[@id=\"uncontrolled-tab-example-tabpane-hotels\"]/div/div/div/div[1]/div/div/div/div/input"));
			 searchBar.sendKeys(ArabicCountries[IndexArabic]);
			 
			 WebElement search_Button=driver.findElement(By.xpath("//*[@id=\"uncontrolled-tab-example-tabpane-hotels\"]/div/div/div/div[4]/button"));
			 searchBar.sendKeys(Keys.chord(Keys.ARROW_DOWN)+Keys.ENTER);
			 search_Button.click();
		}
		
		else {
			WebElement hotal_tab=driver.findElement(By.xpath("//*[@id=\"uncontrolled-tab-example-tab-hotels\"]"));
			 hotal_tab.click();
			 
			 WebElement searchBar=driver.findElement(By.xpath("//*[@id=\"uncontrolled-tab-example-tabpane-hotels\"]/div/div/div/div[1]/div/div/div/div/input"));
			 searchBar.sendKeys(EnglishCountries[IndexEnglish]);

			 WebElement search_Button=driver.findElement(By.xpath("//*[@id=\"uncontrolled-tab-example-tabpane-hotels\"]/div/div/div/div[4]/button"));
			 searchBar.sendKeys(Keys.chord(Keys.ARROW_DOWN)+Keys.ENTER);
			 search_Button.click();
			 
		}
		
	}
	
	
	@Test
	public void testNumberOfVistors() {
		WebElement NumberOfVistor=driver.findElement(By.xpath("//*[@id=\"uncontrolled-tab-example-tabpane-hotels\"]/div/div/div/div[3]/div/select"));
		Select mySelectot=new  Select(NumberOfVistor);
		int index=rand.nextInt(0, 2);
		mySelectot.selectByIndex(index);
	}
	
	@Test(priority=1)
	public void ShearchHotel (){
		WebElement SearchButton=driver.findElement(By.xpath("//*[@id=\"uncontrolled-tab-example-tabpane-hotels\"]/div/div/div/div[4]/button"));
		SearchButton.click();
	}
	
	@Test
	public void DoneSearching (){
		String Search=driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/section/span")).getText();
		Boolean ActualResultInWebsite=Search.contains("found");
		Aassert.assertEquals(ActualResultInWebsite, true);
		
	}
	
	@Test
	public void Searching_low_to_high (){
		WebElement lowest_price=driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div[1]/div[2]/section[1]/div/button[2]"));
		lowest_price.click();
		
		
		WebElement Right_slide=driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div[1]/div[2]/section[2]/div[1]"));
		List<WebElement> The_Price =Right_slide.findElements(By.className("Price_Value"));
		String PriceTheFirstElements=The_Price.get(0).getText();
		String PriceTheLastElements=The_Price.get(The_Price.size()-1).getText();

        int FirstElement=Integer.parseInt(PriceTheFirstElements);
        int lastElement=Integer.parseInt(PriceTheLastElements);
		
        Aassert.assertEquals(FirstElement<lastElement, true);
        
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}