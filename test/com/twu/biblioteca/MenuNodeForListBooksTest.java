package com.twu.biblioteca;

import org.junit.*;

import java.io.*;

import static org.junit.Assert.assertEquals;

public class MenuNodeForListBooksTest {
    @Test
    public void menuFunctionTest() throws Exception {
        PrintStream console = System.out;
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bytes));

        MenuNodeForListBooks menuNodeForListBooks = new MenuNodeForListBooks();
        BookManager bookManager = new BookManager();
        UserClass user = new UserClass("2222222" , "2222" , "Xujun" , "1" , "2222@test.com" , "13222222222" , null);
        menuNodeForListBooks.setMyFarther(menuNodeForListBooks);
        MenuNode returnedMenuNode = menuNodeForListBooks.menuFunction(bookManager , user);
        String expectPrintString =  "Book Name                " + "Author/Year Published    " + "\n" +
                                    "Book1970                 " + "Author1970/1970          " + "\n" +
                                    "Book1971                 " + "Author1971/1971          " + "\n" +
                                    "Book1972                 " + "Author1972/1972          " + "\n" +
                                    "Book1973                 " + "Author1973/1973          " + "\n" +
                                    "Book1974                 " + "Author1974/1974          " + "\n" + "\n";
        assertEquals(menuNodeForListBooks, returnedMenuNode);
        assertEquals(expectPrintString, bytes.toString());

        System.setOut(console);
    }
}
