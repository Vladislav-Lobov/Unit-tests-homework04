package seminars.fourth.book;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BookServiceTest {
    @Test
    void findBookByIdTest(){
        //Arrange
        BookRepository bookRepositoryMock = mock(BookRepository.class);
        BookService bookService = new BookService(bookRepositoryMock);
        String id = "4";
        Book book = new Book(id,"Tom Soyer","Mark Tven");

        //Act
        bookService.findBookById(id);
        when(bookRepositoryMock.findById(id)).thenReturn(book);
        //Assert
        verify(bookRepositoryMock,times(1)).findById(id);
        assertEquals(book,bookRepositoryMock.findById(id));
    }
    @Test
    void findAllTets(){
        //Arrange
        BookRepository bookRepositoryMock = mock(BookRepository.class);
        BookService bookService = new BookService(bookRepositoryMock);
        Book book1 = new Book("1","Idiot","Dostoevsky");
        Book book2 = new Book("2","Besy","Dostoevsky");
        List<Book> arr = new ArrayList<>();
        arr.add(book1);
        arr.add(book2);
        //Act
        bookService.findAllBooks();
        when(bookRepositoryMock.findAll()).thenReturn(arr);
        //Assert
        verify(bookRepositoryMock,times(1)).findAll();
        assertEquals(arr,bookRepositoryMock.findAll());

    }
}