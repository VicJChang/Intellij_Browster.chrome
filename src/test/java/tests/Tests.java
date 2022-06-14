package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Tests extends BaseClass{
    @Test
    public void testOne(){
        driver.get("https://google.com");

    }
}
