package ru.kovbasa.unittests;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import static ru.kovbasa.unittests.product.Products.*;

public class MainTest {
    private ArrayList<String> purchases;

    @BeforeEach
    public void setUp() {
        purchases = new ArrayList<>();
    }

    @Test
    public void testAddProduct() {
        addProduct(purchases, new Scanner("Молоко\n"));
        Assertions.assertEquals(1, purchases.size());
        Assertions.assertEquals("Молоко", purchases.get(0));
    }

    @Test
    public void testDelByProductName() {
        purchases.add("Молоко");
        delByProductName(purchases, new Scanner("Молоко\n"));
        Assertions.assertEquals(0, purchases.size());
    }

    @Test
    public void testDelByProductNumber() {
        purchases.add("Молоко");
        delByProductNumber(purchases, new Scanner("1\n"));
        Assertions.assertEquals(0, purchases.size());
    }

    @Test
    public void testSearchProduct() {
        purchases.add("Молоко");
        purchases.add("Хлеб");
        purchases.add("Яблоки");
        String expectedOutput = """
                Введите ключевое слово для поиска:
                Результаты поиска:
                1. Молоко
                """;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        searchProduct(purchases, new Scanner("мол\n"));
        Assertions.assertEquals(expectedOutput, outputStream.toString());
    }
}