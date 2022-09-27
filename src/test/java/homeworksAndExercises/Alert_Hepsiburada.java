package homeworksAndExercises;

import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBaseBeforeClassAfterClass;

import java.time.Duration;

public class Alert_Hepsiburada extends TestBaseBeforeClassAfterClass {
    @Test
    public void test() {
        driver.get("https://hepsiburada.com");
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().dismiss();
    }

}
