package com.twu.biblioteca;

import org.junit.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.assertEquals;

public class BookManagerTest {
    @Test
    public void checkOutABookTest() throws Exception {
        BookManager bookManager = new BookManager();
        UserClass user = new UserClass("1111111" , "1111" , "ChenZaichuang" , "0" , "1111@test.com" , "13111111111" , null);
        BookClass bookTest1 = new BookClass("Book1970" , "Author1970" , 1971);
        BookClass bookTest2 = new BookClass("Book1970" , "Author1970" , 1970);
        boolean checkOutResult = bookManager.checkOutABook(bookTest1 , user);
        assertEquals(false , checkOutResult);
        checkOutResult = bookManager.checkOutABook(bookTest2 , user);
        assertEquals(true , checkOutResult);
        checkOutResult = bookManager.checkOutABook(bookTest2 , user);
        assertEquals(false , checkOutResult);
    }
    @Test
    public void returnABookTest() throws Exception {
        BookManager bookManager = new BookManager();
        UserClass user = new UserClass("1111111" , "1111" , "ChenZaichuang" , "0" , "1111@test.com" , "13111111111" , null);
        BookClass bookTest1 = new BookClass("Book1970" , "Author1970" , 1971);
        BookClass bookTest2 = new BookClass("Book1970" , "Author1970" , 1970);
        bookManager.checkOutABook(bookTest2 , user);
        boolean returnResult = bookManager.returnABook(bookTest1 , user);
        assertEquals(false , returnResult);
        returnResult = bookManager.returnABook(bookTest2 , user);
        assertEquals(true , returnResult);
        returnResult = bookManager.returnABook(bookTest2 , user);
        assertEquals(false , returnResult);
    }
    @Test
    public void printBookListNotCheckedOutTest() {
        PrintStream console = System.out;
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bytes));

        BookManager bookManager = new BookManager();
        BookClass bookObjInList = new BookClass("Book1970" , "Author1970" , 1970);
        UserClass user = new UserClass("1111111" , "1111" , "ChenZaichuang" , "0" , "1111@test.com" , "13111111111" , null);
        bookManager.printBookListNotCheckedOut(25);
        String expectPrintString =  "Book Name                " + "Author/Year Published    " + "\n" +
                "Book1970                 " + "Author1970/1970          " + "\n" +
                "Book1971                 " + "Author1971/1971          " + "\n" +
                "Book1972                 " + "Author1972/1972          " + "\n" +
                "Book1973                 " + "Author1973/1973          " + "\n" +
                "Book1974                 " + "Author1974/1974          " + "\n" + "\n";
        assertEquals(expectPrintString, bytes.toString());
        bookManager.checkOutABook(bookObjInList , user);
        bookManager.printBookListNotCheckedOut(25);
        expectPrintString +=  "Book Name                " + "Author/Year Published    " + "\n" +
                "Book1971                 " + "Author1971/1971          " + "\n" +
                "Book1972                 " + "Author1972/1972          " + "\n" +
                "Book1973                 " + "Author1973/1973          " + "\n" +
                "Book1974                 " + "Author1974/1974          " + "\n" + "\n";
        assertEquals(expectPrintString, bytes.toString());

        System.setOut(console);
    }
    @Test
    public void printBookListIsCheckedOutTest() {
        PrintStream console = System.out;
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bytes));

        BookManager bookManager = new BookManager();
        BookClass bookObjInList = new BookClass("Book1970" , "Author1970" , 1970);
        UserClass user = new UserClass("1111111" , "1111" , "ChenZaichuang" , "0" , "1111@test.com" , "13111111111" , null);
        bookManager.printBookListIsCheckedOut(25);
        String expectPrintString =  "Book Name                " + "Author/Year Published    " +  "User Id                  " + "User Name                " + "Email Address            " + "Phone Number             \n" + "\n";
        assertEquals(expectPrintString, bytes.toString());
        bookManager.checkOutABook(bookObjInList , user);
        bookManager.printBookListIsCheckedOut(25);
        expectPrintString +=  "Book Name                " + "Author/Year Published    " +  "User Id                  " + "User Name                " + "Email Address            " + "Phone Number             " + "\n" +
                            "Book1970                 " + "Author1970/1970          " + "1111111                  " + "ChenZaichuang            " + "1111@test.com            " + "13111111111              " + "\n" + "\n";
        assertEquals(expectPrintString, bytes.toString());
        bookManager.checkOutABook(bookObjInList , user);
        bookManager.printBookListIsCheckedOut(25);

        System.setOut(console);
    }
    @Test
    public void generateBookObjFromStringTest() {
        BookClass bookTest1 = new BookClass("Book1970" , "Author1970" , 1971);
        BookClass bookTest2 = new BookClass("Book1970" , "Author1970" , 1970);
        BookClass getBook = BookManager.generateBookObjFromString("Book1970,Author1970,1970");
        assertEquals(false, bookTest1.checkIfASameBook(getBook));
        assertEquals(true, bookTest2.checkIfASameBook(getBook));
    }
}
