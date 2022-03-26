package com.example.MyBookShopApp.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {

    List<Book> findBooksByAuthor_FirstName(String name);

    @Query("from Book ")
    List<Book> customFindAllBooks();

    //new book rest repo

//    List<Book> findBooksByAuthorFirstNameContaining(String authorFirstName);
//
//    List<Book> findBooksByTitleContaining(String bookTitle);
//
//    List<Book> findBooksByPriceOldBetween(Integer min, Integer max);
//
//    List<Book> findBooksByPriceOldIs(Integer price);
//
//    @Query("from Book where isBestseller=1")
//    List<Book> getBestsellers();
//
//    @Query(value = "SELECT * FROM books where discount = (SELECT MAX(discount) from books)", nativeQuery=true)
//    List<Book> getBooksWithMaxDiscount();
}
