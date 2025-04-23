package com.roomraccoon.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



import java.util.List;
import java.util.concurrent.TimeUnit;



public class HomePage extends BasePage{
     
    public HomePage(WebDriver driver){
        super(driver);

        PageFactory.initElements(driver, this);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }


// ---locators ///

@FindBy(css = "#tbodyid .card-title")
private List<WebElement> productTitles;

//<a href="#" onclick="addToCart(1)" class="btn btn-success btn-lg">Add to cart</a></div></div>
@FindBy(xpath ="//a[conatins(@onclick,'addToCart') and conatins(@class,'btn-success')]" )
private List<WebElement> AddToCartButton;


@FindBy(id = "cartur")// https://www.demoblaze.com/cart.html
private WebElement cartLink;

// add multiple Items

public void addItemToCarT(List<String> ItemNames){
    for(String name: ItemNames){
        for(int i =0; i< productTitles.size(); i++)
        {
            AddToCartButton.get(i).click();
            Alert alert = driver.switchTo().alert();
            alert.accept();

        }
    }

}

// Nav to HomePage

public void openHomePage(){
    driver.get("https://www.demoblaze.com/");
}
// Nav to Cart 

public void navigateToCart(){
    cartLink.click();
}

//Get total price with each add to function
public int getTotalPrice(){
    String TotalText = driver.findElement(By.id("totalp")).getText();
    return Integer.parseInt(TotalText);


}


//Fill UpTheForm
//I fill in the purchase details with name "Kabelo", country "South Africa", city "Cape Town", card "5536 3091 6673 7061", month "09", year "2029"
public void completePurchase(String name, String country, String city, String card, String month,  String year){
    //<button type="button" class="btn btn-success" data-toggle="modal" data-target="#orderModal">Place Order</button>
    driver.findElement(By.xpath("//button[text()='Place Order']"));

    //id:name
    driver.findElement(By.id("name")).sendKeys(name);
    //id:country
    driver.findElement(By.id("country")).sendKeys(country);
    //id:city
    driver.findElement(By.id("city")).sendKeys(city);
    //id:card
    driver.findElement(By.id("card")).sendKeys(card);
    //id:month
    driver.findElement(By.id("month")).sendKeys(month);
    //id:year
    driver.findElement(By.id("year")).sendKeys(year);

    //<button type="button" onclick="purchaseOrder()" class="btn btn-primary">Purchase</button>
    driver.findElement(By.xpath("//button[text(),'Purchase']")).click();


}

//confirmation message

public String  getConfirmationMessage(){
    WebElement msg = driver.findElement(By.cssSelector  (".sweet-alert h2"));
    return msg.getText();
}



}





