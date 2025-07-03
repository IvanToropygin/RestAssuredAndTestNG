package ru.qaway.bookstore.tests.rest.model.request;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderSampleTest {

    @Test(dataProvider = "dataProvider")
    void testSample(Integer digit, String word) {

        System.out.printf("%s - %s\n", digit, word);
    }


    @DataProvider(name = "dataProvider")
    public Object[][] dataProviderMethod() {
        return new Object[][]{
                {1, "one"},
                {2, "two"},
        };
    }
}
