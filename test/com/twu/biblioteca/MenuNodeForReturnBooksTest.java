package com.twu.biblioteca;
import org.junit.*;

import java.io.*;

import static org.junit.Assert.assertEquals;
public class MenuNodeForReturnBooksTest {
    @Test
    public void test() throws IOException {
        PrintStream console = System.out;
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bytes));
        InputStream keyBoard = System.in;

        System.setIn(new FileInputStream("resource/inputContentOfBookInfo.txt"));
        MenuNodeForCheckOutBooks menuNodeForCheckOutBooks = new MenuNodeForCheckOutBooks();
        UserClass user = new UserClass("2222222" , "2222" , "Xujun" , "1" , "2222@test.com" , "13222222222" , null);
        BookManager bookManager = new BookManager();
        menuNodeForCheckOutBooks.setMyFarther(null);
        menuNodeForCheckOutBooks.menuFunction(bookManager , user);
        String expectPrintString =  "Please input the book name , author and year published (eg:testName,Me,2017)\n" +
                                    "and input q for quit:" + "Thank you! Enjoy the book\n";
//        assertEquals(menuNodeForCheckOutBooks, returnedMenuNode);
//        assertEquals(expectPrintString, bytes.toString());
        System.setIn(new FileInputStream("resource/inputOptionNumber0.txt"));
        MenuNodeForReturnBooks menuNodeForReturnBooks = new MenuNodeForReturnBooks();
        menuNodeForReturnBooks.setMyFarther(null);
        MenuNode returnedMenuNode = menuNodeForReturnBooks.menuFunction(bookManager , user);
        expectPrintString +=    "Please input the book name , author and year published (eg:testName,Me,2017)\n" +
                "and input q for quit:" + "That is not a valid book to return.\n";
        assertEquals(menuNodeForReturnBooks, returnedMenuNode);
        assertEquals(expectPrintString, bytes.toString());

        System.setIn(new FileInputStream("resource/inputContentOfBookInfo.txt"));
        returnedMenuNode = menuNodeForReturnBooks.menuFunction(bookManager , user);
        expectPrintString +=    "Please input the book name , author and year published (eg:testName,Me,2017)\n" +
                                "and input q for quit:" + "Thank you for returning the book.\n";
        assertEquals(null, returnedMenuNode);
        assertEquals(expectPrintString, bytes.toString());

        System.setIn(new FileInputStream("resource/inputQForQuit.txt"));
        returnedMenuNode = menuNodeForCheckOutBooks.menuFunction(bookManager , user);
        expectPrintString +=    "Please input the book name , author and year published (eg:testName,Me,2017)\n" +
                                "and input q for quit:";
        assertEquals(null, returnedMenuNode);
        assertEquals(expectPrintString, bytes.toString());

        System.setOut(console);
        System.setIn(keyBoard);
    }
}
