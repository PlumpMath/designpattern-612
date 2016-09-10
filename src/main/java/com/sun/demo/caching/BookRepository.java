package com.sun.demo.caching;

/**
 * Created by kimi on 6/10/16.
 */
public interface BookRepository {
    Book getByIsbn(String isbn);
}
