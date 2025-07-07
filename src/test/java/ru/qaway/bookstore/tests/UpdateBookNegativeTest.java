package ru.qaway.bookstore.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.qaway.bookstore.tests.rest.model.request.Book;
import ru.qaway.bookstore.tests.rest.model.request.BookData;
import ru.qaway.bookstore.tests.rest.model.response.BookResponse;

public class UpdateBookNegativeTest extends BookStoreTestBase {

    private Integer id;

    @BeforeClass
    public void setUp() {
        id = testClient
                .create(Book.defaultOf())
                .checkStatusCode(201)
                .getId();
    }

    @Test(dataProvider = "booksNegative", dataProviderClass = BookData.class)
    public void testUpdateBookNegative(Book updateBook) {

        testClient.update(id, updateBook)
                .checkStatusCode(400)
                .checkErrorResponse(BookResponse.updateError400(id));

        testClient.read(id)
                .checkStatusCode(200)
                .checkId(id)
                .checkLastUpdated()
                .checkBook(Book.defaultOf());
    }
}
