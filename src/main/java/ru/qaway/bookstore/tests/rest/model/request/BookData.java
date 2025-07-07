package ru.qaway.bookstore.tests.rest.model.request;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.DataProvider;
import ru.qaway.bookstore.tests.rest.enums.Category;

public class BookData {

    @DataProvider(name = "positive")
    public static Object[][] booksPositive() {

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

    @DataProvider
    public static Object[][] booksNegative() {
        return new Object[][]{
                // title < min = 2
                {Book.defaultOf().setTitle(RandomStringUtils.randomAlphabetic(2))},
                // title > max = 257
                {Book.defaultOf().setTitle(RandomStringUtils.randomAlphabetic(257))},
                // description < min = 2
                {Book.defaultOf().setDescription(RandomStringUtils.randomAlphabetic(2))},
                // description > max = 513
                {Book.defaultOf().setDescription(RandomStringUtils.randomAlphabetic(513))},
                // author < min = 2
                {Book.defaultOf().setAuthor(RandomStringUtils.randomAlphabetic(2))},
                // author > max = 101
                {Book.defaultOf().setAuthor(RandomStringUtils.randomAlphabetic(101))},
                // price < min = -1
                {Book.defaultOf().setPrice(-1)},
                // count > max = 101
                {Book.defaultOf().setCount(-1)},
                // count > max = 101
                {Book.defaultOf().setCategory(Category.UnKnown)},

        };
    }
}
