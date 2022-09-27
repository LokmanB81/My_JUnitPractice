package day12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBaseBeforeClassAfterClass;

import java.time.Duration;

public class C03_SenkronizasyonWait extends TestBaseBeforeClassAfterClass {
    @Test
    public void implicitlyWaittest1() {
        //https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //Remove butonuna basin.
        driver.findElement(By.xpath("//*[text()='Remove']")).click();

        //“It’s gone!” mesajinin goruntulendigini dogrulayin.
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='message']")).isDisplayed());

        //Add buttonuna basin
        driver.findElement(By.xpath("//*[text()='Add']")).click();

        //It’s back mesajinin gorundugunu test edin
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='message']")).isDisplayed());
    }

    @Test
    public void explicitlytest() {
        //https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //Remove butonuna basin.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(By.xpath("//*[text()='Remove']")).click();

        //“It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebElement element = wait.until(ExpectedConditions.
                visibilityOfElementLocated(By.xpath("//*[@id='message']")));
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='message']")).isDisplayed());

        //Add buttonuna basin
        driver.findElement(By.xpath("//*[text()='Add']")).click();

        //It’s back mesajinin gorundugunu test edin
        element= wait.until(ExpectedConditions.
                visibilityOfElementLocated(By.xpath("//*[@id='message']")));
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='message']")).isDisplayed());

    }
    /*
Iki tane metod olusturun : implicitWait() , explicitWait()
Iki metod icin de asagidaki adimlari test edin.
  */
    /*
​
    Senkronize etmekten kasıt bilgisayar, internet sayfasinın hızını kodlarimizda eş zamanli çalışmasini sağlamaktir.
    Bunun için 3 tane bekletme yolu vardir.
​
    1-- Thread.sleep ---> Java tabanli wait. seleniumda yoktur. javadan kullaniriz.
​
    2-- implicitly wait ---> Selenium tabanli. site içerisinde elementlerin yüklenmesini beklemek için kullanilir.
    Bu kod sayfa acilmadiysa verilen sure kadar bekler ve sayfa içerisinde çalışırken karşılaştığı yüklenmemis elementleri de
    yüklenene kadar verilen süre kadar bekler.
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
​
    3-- Explicitly wait --> istediğimiz bir element için koşul gerçekleşene kadar beklet
    Özellikle bekletmek istediğimiz elementlerin öncesinde ayarladığımız sure ve koşuldur.Koşul gerçekleşince surenin dolmasini beklemez.
    Aslinda wait kullandiğmiz elementten once o element yüklenene kadar şu kadar süre içerisinde ve şu şart gerçekleşene
    kadar bekle demektirdir.
    örneğin; dosya indirilene kdar bekle, veya dosyanin inmesini 15 sn bekle gibi...
       --> her element yada işlem için oncesinde yapilir.
​
       oluşturmak için (1)wait objesi yapariz. --> WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(15));
       --> sonrasinda 2. satirda (2) wait.until() yazarak parantez içine ExpectedConditions + nokta basarak uygun şartı belirleriz.
       --> koşulların parantez içine --wait.until(ExpectedConditions.elementToBeClickable(enableKutusu);--
       webelement gibi şeyler yazmak gerekebilir.
​
       Ornegin;
        wait.until(ExpectedConditions.alertIsPresent()); -->
        wait.until(ExpectedConditions.elementToBeClickable(enableKutusu);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("locate adresi"));
        wait.until(ExpectedConditions.refreshed();
​
        Birde ek olarak FluentWait vardir. o da her 2 saniyede bir çalışmayı dene demektir. dosya indi mi inmedi mi diye loop yapiyor denebilir.
​
​
​
​
​
​
                Cookies
                2 çeşittir.
                1) oturum çerezi -  bizim ip gibi bilgilerimizi serverda tutup bir daha bize soru sormuyor.
                Oturum çerezleri yalnızca bir web sitesinde gezinirken kullanılır.
                Bunlar rastgele erişimli bellekte saklanır ve hiçbir zaman sabit sürücüye yazılmaz.
                Oturum sona erdiğinde oturum çerezleri otomatik olarak silinir.
​
                2) kalıcı çerezler - Kalıcı çerezler bir bilgisayarda sonsuza kadar kalır
                ancak birçoğunun bir son kullanma tarihi olup bu tarihe gelindiğinde otomatik olarak kaldırılırlar.
​
                *** Üçüncü taraf çerezler daha sıkıntılıdır. Bunlar, genellikle kullanıcıların halihazırda
                gezindiği web sayfalarındaki reklamlarla bağlantılı olduklarından bu sayfalardan farklı
                web siteleri tarafındanoluşturulur.
​
     */
}
