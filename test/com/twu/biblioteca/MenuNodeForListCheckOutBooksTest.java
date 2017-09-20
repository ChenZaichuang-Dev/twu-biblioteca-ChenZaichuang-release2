package com.twu.biblioteca;

import org.junit.Test;

import java.awt.print.Book;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class MenuNodeForListCheckOutBooksTest {
    @Test
    public void menuFunctionTest() throws Exception {
        PrintStream console = System.out;
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bytes));

        MenuNodeForListCheckOutBooks menuNodeForListCheckOutBooks = new MenuNodeForListCheckOutBooks();
        menuNodeForListCheckOutBooks.setMyFarther(null);
        BookManager bookManager = new BookManager();
        BookClass bookTest = new BookClass("Book1970" , "Author1970" , 1970);
        UserClass user = new UserClass("1111111" , "1111" , "ChenZaichuang" , "0" , "1111@test.com" , "13111111111" , null);
        bookManager.checkOutABook(bookTest , user);
        menuNodeForListCheckOutBooks.menuFunction(bookManager , user);
        String expectPrintString =  "Book Name                " + "Author/Year Published    " +  "User Id                  " + "User Name                " + "Email Address            " + "Phone Number             " + "\n" +
                "Book1970                 " + "Author1970/1970          " + "1111111                  " + "ChenZaichuang            " + "1111@test.com            " + "13111111111              " + "\n" + "\n";
        assertEquals(expectPrintString, bytes.toString());

        System.setOut(console);
    }
}
