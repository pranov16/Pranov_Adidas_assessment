package stepdefinition;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;

public class stepdefinitions {

	
	public WebDriver driver;
	
	
	
	@Given("^customer is on home page$")
	public void customer_is_on_home_page() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "E:\\sample db\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.demoblaze.com/index.html");
		Thread.sleep(10000);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}
	
	@When("^title of the page is confirmed$")
	public void title_of_the_page_is_confirmed(){
		String title=driver.getTitle();
		System.out.println(title);
		Assert.assertEquals("STORE", title);
	}
	
	@Then("^customer navigates to Laptop page$")
	public void customer_navigates_to_Laptop_page() {
		driver.findElement(By.id("itemc")).click();
	}

	@Then("^customer add one laptop to cart and customer accept the popup and customer navigates to home page$")
	public void customer_add_one_laptop_to_cart_and_customer_accept_the_popup_and_customer_navigates_to_home_page() throws InterruptedException {
		driver.findElement(By.linkText("Sony vaio i5")).click();
		Thread.sleep(5000);
		driver.findElement(By.linkText("Add to cart")).click();
		Thread.sleep(5000);
		Alert alert=driver.switchTo().alert();
		Thread.sleep(5000);
		alert.accept();
		driver.findElement(By.className("nav-link")).click();
		
	    
	}
	

	@Then("^customer add another laptop to cart and customer accept the popup$")
	public void customer_add_another_laptop_to_cart_and_customer_accept_the_popup() throws InterruptedException  {
		driver.findElement(By.xpath("//a[contains(text(),'Laptops')]")).click();
		Thread.sleep(5000);
		driver.findElement(By.linkText("Dell i7 8gb")).click();
		Thread.sleep(5000);
		driver.findElement(By.linkText("Add to cart")).click();
		Thread.sleep(5000);
		Alert alert1=driver.switchTo().alert();
		alert1.accept();
	    
	    
	}

	@Then("^customer navigates to cart$")
	public void customer_navigates_to_cart() throws InterruptedException {
		driver.findElement(By.id("cartur")).click();
		Thread.sleep(10000);
	    
	    
	}

	@Then("^customer delete one laptop item$")
	public void customer_delete_one_laptop_item() throws InterruptedException {

		driver.findElement(By.xpath("/html/body/div[6]/div/div[1]/div/table/tbody/tr/td[4]/a")).click();
		Thread.sleep(5000);
	   
	}

	@Then("^customer place the order$")
	public void customer_place_the_order() {

		driver.findElement(By.xpath("/html/body/div[6]/div/div[2]/button")).click();
	   
	}

	@Then("^customer is on order details page$")
	public void customer_is_on_order_details_page(){
		
	    
	   
	}

	@Then("^customer fill all the details and click on purchase$")
	public void customer_fill_all_the_details_and_click_on_purchase()  {
		
		WebDriverWait wait=new WebDriverWait(driver,20);
	    wait.until(ExpectedConditions.titleContains("STORE"));
	    
	    WebElement modalDialogBox=driver.findElement(By.className("modal-open"));
	    modalDialogBox.findElement(By.id("name")).sendKeys("Pranov");
	    modalDialogBox.findElement(By.id("country")).sendKeys("India");
	    modalDialogBox.findElement(By.id("city")).sendKeys("Gurgaon");
	    modalDialogBox.findElement(By.id("card")).sendKeys("1234567890123456");
	    modalDialogBox.findElement(By.id("month")).sendKeys("October");
	    modalDialogBox.findElement(By.id("year")).sendKeys("2020");
	    modalDialogBox.findElement(By.xpath("/html/body/div[3]/div/div/div[3]/button[2]")).click();
	    
	}

	@Then("^customer captures the purchase id and amount and assert the amount$")
	public void customer_captures_the_purchase_id_and_amount_and_assert_the_amount()  {

		Set <String> handler=driver.getWindowHandles();
		Iterator <String> win=handler.iterator();
		String parentwindowid=win.next();
		System.out.println(parentwindowid);
		String childwindowid=win.next();
		System.out.println(childwindowid);
		driver.switchTo().window(childwindowid);
		driver.findElement(By.xpath("/html/body/div[10]/div[7]/div/button")).click();
		
	    
	    
	}
		
		
	
	@Then("^customer click on ok$")
	public void customer_click_on_ok() {
		

	    driver.findElement(By.xpath("/html/body/div[10]/div[7]/div/button")).click();
	   
	}
	
	
}
	