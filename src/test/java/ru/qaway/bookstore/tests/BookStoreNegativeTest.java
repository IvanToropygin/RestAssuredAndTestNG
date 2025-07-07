package ru.qaway.bookstore.tests;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.qaway.bookstore.tests.rest.enums.Category;
import ru.qaway.bookstore.tests.rest.model.request.Book;

public class BookStoreNegativeTest extends BookStoreTestBase {

    @Test(dataProvider = "createBooksNegative")
    public void testCreate(Book book) {
        testClient.create(book).checkStatusCode(400);
    }

    @DataProvider
    public Object[][] createBooksNegative() {
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
