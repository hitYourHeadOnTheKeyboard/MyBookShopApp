package com.example.MyBookShopApp.data;

import com.example.MyBookShopApp.data.book.BookEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findBooksByAuthor_FirstName(String name);

    @Query("from Book ")
    List<Book> customFindAllBooks();

    //new book rest repo

    List<Book> findBooksByAuthorFirstNameContaining(String authorFirstName);

    List<Book> findBookByTitleContaining(String bookTitle);

    List<Book> findBooksByPriceOldBetween(Integer min, Integer max);

    List<Book> findBooksByPriceOldIs(Integer price);

    @Query("from BookEntity where isBestseller=1")
    List<Book> getBestsellers();

    @Query(value = "SELECT * FROM book where discount = (SELECT MAX(discount) from book)", nativeQuery=true)
    List<Book> getBooksWithMaxDiscount();

    Page<Book> findBookByTitleContaining(String bookTitle, Pageable nextPage);
}
