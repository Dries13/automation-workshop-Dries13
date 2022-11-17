package be.ucll.bmi.ui;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WebDriverTest {

    @Value("${chrome.driver.location}")
    private String chromeDriverLocation;

    @Test
    public void test_web_driver(){
        System.setProperty("webdriver.chrome.driver", chromeDriverLocation);

        WebDriver driver = new ChromeDriver();
        driver.get("https://research-expertise.ucll.be");
        assertTrue(driver.getTitle().contains("UCLL"));
    }
}
