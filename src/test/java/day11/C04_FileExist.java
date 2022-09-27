package day11;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBaseBeforeClassAfterClass;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FileExist  {
    @Test
    public void test1() {
       /* System.out.println(System.getProperty("user.dir"));//C:\Users\lkmnb\IdeaProjects\com.Batch81JUnit
        System.out.println(System.getProperty("user.home"));//C:\Users\lkmnb

        */
        String dosyaYolu="C:\\Users\\lkmnb\\Desktop\\text.txt";
        String dosyaYoluBmp="C:\\Users\\lkmnb\\Desktop\\Test_execise_sample.bmp";

        System.out.println(Files.exists(Paths.get(dosyaYolu)));
        System.out.println(Files.exists(Paths.get(dosyaYoluBmp)));
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
        Assert.assertTrue(Files.exists(Paths.get(dosyaYoluBmp)));

    }
}
