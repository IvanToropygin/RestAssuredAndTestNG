package ru.qaway.bookstore.tests.update;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.qaway.bookstore.tests.BookStoreTestBase;
import ru.qaway.bookstore.tests.rest.model.request.Book;
import ru.qaway.bookstore.tests.rest.model.request.BookData;

public class UpdateBookTest extends BookStoreTestBase {

    private Integer id;

    @BeforeClass
    public void setUp() {
        id = testClient
                .create(Book.defaultOf())
                .checkStatusCode(201)
                .getId();
    }

    @Test(dataProvider = "positive", dataProviderClass = BookData.class)
    public void testUpdateBook(Book updateBook) {

        testClient.update(id, updateBook)
                .checkStatusCode(200)
                .checkId(id)
                .checkLastUpdated()
                .checkBook(updateBook);

        testClient.read(id)
                .checkStatusCode(200)
                .checkId(id)
                .checkBook(updateBook);
    }
}
