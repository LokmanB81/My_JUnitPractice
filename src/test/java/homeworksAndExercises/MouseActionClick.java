package homeworksAndExercises;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeClassAfterClass;

public class MouseActionClick extends TestBaseBeforeClassAfterClass {
    @Test
    public void test() {
        driver.get("https://www.amazon.com");
        WebElement searchBox=driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));

        action.click(searchBox).perform();
    }
}
