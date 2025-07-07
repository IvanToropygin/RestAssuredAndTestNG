package ru.qaway.bookstore.tests.create;

import org.testng.annotations.Test;
import ru.qaway.bookstore.tests.BookStoreTestBase;
import ru.qaway.bookstore.tests.rest.model.request.Book;
import ru.qaway.bookstore.tests.rest.model.request.BookData;
import ru.qaway.bookstore.tests.rest.model.response.BookValidatableResponse;

public class CreateBookTest extends BookStoreTestBase {

    @Test(dataProvider = "positive", dataProviderClass = BookData.class)
    public void testCreateBook(Book book) {

        BookValidatableResponse response = testClient.create(book)
                .checkStatusCode(201)
                .checkIdNotNull()
                .checkLastUpdated()
                .checkBook(book);

        testClient.read(response.getId())
                .checkStatusCode(200)
                .checkId(response.getId())
                .checkLastUpdated()
                .checkBook(book);
    }


}
