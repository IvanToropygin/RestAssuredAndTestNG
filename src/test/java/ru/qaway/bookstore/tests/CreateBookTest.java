package ru.qaway.bookstore.tests;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.qaway.bookstore.tests.rest.client.TestClient;
import ru.qaway.bookstore.tests.rest.enums.Category;
import ru.qaway.bookstore.tests.rest.model.request.Book;
import ru.qaway.bookstore.tests.rest.model.responce.BookValidatableResponse;

public class CreateBookTest {

    @Test(dataProvider = "books")
    public void testCreateBook(Book book) {

        TestClient client = new TestClient();

        BookValidatableResponse response = client.create(book)
                .checkStatusCode(201)
                .checkIdNotNull()
                .checkLastUpdated()
                .checkBook(book);

        client.read(response.getId())
                .checkStatusCode(200)
                .checkId(response.getId())
                .checkLastUpdated()
                .checkBook(book);
    }

    @DataProvider(name = "books")
    public Object[][] createBooks() {

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
