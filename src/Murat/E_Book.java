package Murat;

import Utility.BaseDriver;
import Utility.MyFunc;
import com.sun.deploy.cache.BaseLocalApplicationProperties;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class E_Book extends BaseDriver {
    @Test
    public  void test(){
        driver.get("https://www.e-junkie.com/wiki/demo");

        WebElement addToCart=driver.findElement(By.xpath("//a[text()='Add to Cart']"));
        addToCart.click();
        MyFunc.Bekle(3);

        driver.switchTo().frame(0);
        WebElement odemeSecimi=driver.findElement(By.xpath("//*[@class='Payment-Button CC']"));
        odemeSecimi.click();

        WebElement pay=driver.findElement(By.cssSelector("[class='Pay-Button']"));
        pay.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#SnackBar>span")));
        WebElement yazilar=driver.findElement(By.cssSelector("#SnackBar>span"));
        Assert.assertTrue("dogrulanamadi",yazilar.getText().contains("Invalid"));

        BekleVeKapat();
    }
}
