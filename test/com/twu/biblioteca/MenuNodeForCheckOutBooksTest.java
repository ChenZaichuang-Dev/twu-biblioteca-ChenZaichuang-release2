package com.twu.biblioteca;

import org.junit.*;

import java.io.*;

import static org.junit.Assert.assertEquals;
public class MenuNodeForCheckOutBooksTest {
    @Test
    public void menuFunctionTest() throws IOException {
        PrintStream console = System.out;
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bytes));
        InputStream keyBoard = System.in;

        System.setIn(new FileInputStream("resource/inputOptionNumber0.txt"));
        MenuNodeForCheckOutBooks menuNodeForCheckOutBooks = new MenuNodeForCheckOutBooks();
        UserClass user = new UserClass("2222222" , "2222" , "Xujun" , "1" , "2222@test.com" , "13222222222" , null);
        BookManager bookManager = new BookManager();
        menuNodeForCheckOutBooks.setMyFarther(null);
        MenuNode returnedMenuNode = menuNodeForCheckOutBooks.menuFunction(bookManager , user);
        String expectPrintString =  "Please input the book name , author and year published (eg:testName,Me,2017)\n" +
                                    "and input q for quit:" + "That book is not available.\n";
        assertEquals(menuNodeForCheckOutBooks, returnedMenuNode);
        assertEquals(expectPrintString, bytes.toString());
        System.setIn(new FileInputStream("resource/inputContentOfBookInfo.txt"));
        returnedMenuNode = menuNodeForCheckOutBooks.menuFunction(bookManager , user);
        expectPrintString +=    "Please input the book name , author and year published (eg:testName,Me,2017)\n" +
                                "and input q for quit:" + "Thank you! Enjoy the book\n";
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
