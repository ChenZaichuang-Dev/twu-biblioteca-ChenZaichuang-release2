package com.twu.biblioteca;

import org.junit.*;

import java.io.*;

import static com.twu.biblioteca.ConsoleIOFunc.showInfoAndReadDataFromConsole;
import static com.twu.biblioteca.ConsoleIOFunc.showInfoToConsole;
import static org.junit.Assert.assertEquals;

public class ConsoleIOFuncTest {

    @Test
    public void showInfoAndReadDataFromConsoleTest() throws FileNotFoundException {
        PrintStream console = System.out;
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bytes));
        InputStream keyBoard = System.in;

        System.setIn(new FileInputStream("resource/inputContentOfBookInfo.txt"));
        String expectString = "test1234";
        String returnString = ConsoleIOFunc.showInfoAndReadDataFromConsole("test1234");

        assertEquals(expectString, bytes.toString());
        assertEquals("Book1970,Author1970,1970", returnString);

        System.setOut(console);
        System.setIn(keyBoard);
    }
    @Test
    public void generateSpecificLengthOfStringTest() throws FileNotFoundException {
        String expectString = "test1234    ";
        String actualString = ConsoleIOFunc.generateSpecificLengthOfString(12 , "test1234");
        assertEquals(expectString, actualString);
    }
}
