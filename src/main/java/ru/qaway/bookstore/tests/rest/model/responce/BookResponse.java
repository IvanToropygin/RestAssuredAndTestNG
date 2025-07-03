package ru.qaway.bookstore.tests.rest.model.responce;

import lombok.*;
import ru.qaway.bookstore.tests.rest.model.request.Book;

import java.time.OffsetDateTime;

@Setter
@Getter
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class BookResponse extends Book {

    private Integer id;
    private OffsetDateTime lastUpdated;
}
