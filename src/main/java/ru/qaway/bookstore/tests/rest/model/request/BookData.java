package ru.qaway.bookstore.tests.rest.model.request;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.DataProvider;
import ru.qaway.bookstore.tests.rest.enums.Category;

public class BookData {

    @DataProvider(name = "createBooksPositive")
    public static Object[][] createBooksPositive() {

        return new Object[][]{
                {Book.defaultOf()},
                // title min = 3,
                {Book.defaultOf().setTitle(RandomStringUtils.randomAlphabetic(3))},
                // title max = 256,
                {Book.defaultOf().setTitle(RandomStringUtils.randomAlphabetic(256))},
                // description min = 3,
                {Book.defaultOf().setDescription(RandomStringUtils.randomAlphabetic(3))},
                // description max = 512,
                {Book.defaultOf().setDescription(RandomStringUtils.randomAlphabetic(512))},
                // author min = 3,
                {Book.defaultOf().setAuthor(RandomStringUtils.randomAlphabetic(3))},
                // author max = 100,
                {Book.defaultOf().setAuthor(RandomStringUtils.randomAlphabetic(100))},
                // price >= 0,
                {Book.defaultOf().setPrice(0)},
                // count >= 0,
                {Book.defaultOf().setCount(0)},
                // categories from enum: Detective
                {Book.defaultOf().setCategory(Category.Detective)},
                // categories from enum: Horror
                {Book.defaultOf().setCategory(Category.Horror)},
                // categories from enum: Thriller
                {Book.defaultOf().setCategory(Category.Thriller)},
        };
    }
}
