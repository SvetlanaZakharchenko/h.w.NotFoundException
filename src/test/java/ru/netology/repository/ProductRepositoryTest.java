package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.NotFoundException;
import ru.netology.domain.Product;

import static org.junit.jupiter.api.Assertions.*;

public class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    private Book coreJava = new Book();
    Product first = new Book(1, "Жизнь взаймы", 800, "Ремарк", 150, 1950);
    Product second = new Book(2, "Три товарища", 600, "Ремарк", 200, 1940);

    @Test
    public void shouldSaveOneItem() {
        repository.save(coreJava);

        Product[] expected = new Product[]{coreJava};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveIfExists() {
        repository.save(first);

        int idToRemove=1;
        repository.removeById(idToRemove);

        Product[] expected = new Product[] {};
        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldThrowException() {

        Assertions.assertThrows(NotFoundException.class, ()->{repository.removeById(3);});
    }
}
