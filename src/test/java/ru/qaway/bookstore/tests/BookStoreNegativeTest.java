package ru.qaway.bookstore.tests;

import org.testng.annotations.Test;
import ru.qaway.bookstore.tests.rest.model.request.Book;
import ru.qaway.bookstore.tests.rest.model.request.BookData;

public class BookStoreNegativeTest extends BookStoreTestBase {

    @Test(dataProvider = "booksNegative", dataProviderClass = BookData.class)
    public void testCreateBookNegative(Book book) {
        testClient.create(book).checkStatusCode(400);
    }
}
