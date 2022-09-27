package day13;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBaseBeforeClassAfterClass;

import java.util.Set;

public class C01_Cookie extends TestBaseBeforeClassAfterClass {
    @Test
    public void test() {
        // 1-Amazon anasayfaya gidin
        driver.get("https://amazon.com");

        // -tum cookie’leri listeleyin
      Set<Cookie>  tumCookie=driver.manage().getCookies();
        for (Cookie each:tumCookie
             ) {
            System.out.println(each.getName()+" : "+each.getValue());
        }

        System.out.println(tumCookie.size());

        // 3-Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        Assert.assertTrue(tumCookie.size()>5);

        //4-ismi i18n-prefs olan cookie degerinin USD oldugunu test edin

        for (Cookie each:tumCookie
             ) {
            if(each.getName().equals("i18n-prefs")){
                Assert.assertTrue(each.getValue().equals("USD"));
            }
        }

        // 5-ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie  olusturun ve sayfaya ekleyin
        Cookie newCookie=new Cookie("en sevdigim cookie","cikolatali");
        driver.manage().addCookie(newCookie);

        //6-eklediginiz cookie’nin sayfaya eklendigini test edin
        tumCookie=driver.manage().getCookies();

        System.out.println(tumCookie.size());
        Assert.assertTrue(tumCookie.contains(newCookie));

        //7-ismi skin olan cookie’yi silin ve silindigini test edin

        driver.manage().deleteCookieNamed("skin");
        Assert.assertFalse(tumCookie.contains("skin"));
        tumCookie=driver.manage().getCookies();
        System.out.println(tumCookie.size());

        // 8-tum cookie’leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();
        tumCookie=driver.manage().getCookies();
        Assert.assertTrue(tumCookie.size()==0);
        System.out.println(tumCookie.size());

        driver.close();

    }
}
