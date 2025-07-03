package ru.qaway.bookstore.tests;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import ru.qaway.bookstore.tests.rest.client.TestClient;
import ru.qaway.bookstore.tests.rest.model.request.Book;
import ru.qaway.bookstore.tests.rest.enums.Category;

public class CreateBookTest {

    @Test
    public void testCreateBook() {

        Book book = new Book(
                "The Adventures of Tom Sawyer",
                "The story about Tom Sawyer.",
                "Mark Twain",
                350,
                10,
                Category.Adventures);

        TestClient testClient = new TestClient();

        testClient.create(book)
                .checkStatusCode(201)
                .checkIdNotNull()
                .checkLastUpdated()
                .checkBook(book);
    }
}
