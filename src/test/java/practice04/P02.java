package practice04;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBaseBeforeClassAfterClass;

import java.nio.file.Files;
import java.nio.file.Paths;

public class P02 {

    @Test
    public void test() {
        //Verify that we have pom.xml file in our project => please try in 4 min s

        String expectedFile="C:\\Users\\lkmnb\\IdeaProjects\\com.Batch81JUnit\\pom.xml";
        Assert.assertTrue(Files.exists(Paths.get(expectedFile)));

    }
}
