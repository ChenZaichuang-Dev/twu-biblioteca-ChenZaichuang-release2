package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class BookClassTest {
    @Test
    public void checkIfASameBookTest() {
        BookClass bookTest1 = new BookClass("1" , "A" , 1);
        BookClass bookTest2 = new BookClass("1" , "A" , 1);
        BookClass bookTest3 = new BookClass("2" , "A" , 1);
        assertEquals(bookTest1.checkIfASameBook(bookTest2) , true);
        assertEquals(bookTest1.checkIfASameBook(bookTest3) , false);
    }
    @Test
    public void checkOutTheBookTest() {
        BookClass bookTest1 = new BookClass("1" , "A" , 1);
        boolean checkResult = bookTest1.checkOutTheBook(null);
        assertEquals(true , checkResult);
        checkResult = bookTest1.checkOutTheBook(null);
        assertEquals(false , checkResult);
    }
    @Test
    public void returnTheBookTest() {
        BookClass bookTest1 = new BookClass("1" , "A" , 1);
        boolean returnResult = bookTest1.returnTheBook(null);
        assertEquals(false , returnResult);
        bookTest1.checkOutTheBook(null);
        returnResult = bookTest1.returnTheBook(null);
        assertEquals(true , returnResult);

    }
    @Test
    public void isCheckedOutTest() {
        BookClass bookTest1 = new BookClass("1" , "A" , 1);
        UserClass user = new UserClass("1111111" , "1111" , "ChenZaichuang" , "0" , "1111@test.com" , "13111111111" , null);
        assertEquals(false , bookTest1.isCheckedOut());
        bookTest1.checkOutTheBook(user);
        assertEquals(true , bookTest1.isCheckedOut());
        bookTest1.returnTheBook(user);
        assertEquals(false , bookTest1.isCheckedOut());
    }
    @Test
    public void generatePrintInfoOfThisBookWithUserInfoTest() {
        PrintStream console = System.out;
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bytes));

        UserClass user = new UserClass("1111111" , "1111" , "ChenZaichuang" , "0" , "1111@test.com" , "13111111111" , null);
        BookClass bookObj = new BookClass("1" , "A" , 1);
        String expectPrintString = "1                             A/1                           1111111                       ChenZaichuang                 1111@test.com                 13111111111                   " + "\n";
        bookObj.checkOutTheBook(user);
        String actualPrintString = bookObj.generatePrintInfoOfThisBookWithUserInfo(30);
        assertEquals(expectPrintString, actualPrintString);

        System.setOut(console);
    }
}