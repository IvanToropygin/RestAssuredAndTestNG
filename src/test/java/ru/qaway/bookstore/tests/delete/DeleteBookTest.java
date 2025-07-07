package ru.qaway.bookstore.tests.delete;

import org.testng.annotations.Test;
import ru.qaway.bookstore.tests.BookStoreTestBase;
import ru.qaway.bookstore.tests.rest.model.request.Book;

public class DeleteBookTest extends BookStoreTestBase {

    @Test
    public void deleteBookTest() {
        Integer id = testClient.create(Book.defaultOf())
                .checkStatusCode(201)
                .getId();

        testClient.delete(id)
                .checkStatusCode(200);

        testClient.read(id)
                .checkStatusCode(404);
    }

    @Test
    public void tetsDeleteNotExistedBook() {
        testClient.delete(Integer.MAX_VALUE)
                .checkStatusCode(404);
    }
}
