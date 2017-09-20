package com.twu.biblioteca;

import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;

public class MenuNodeForListMoviesTest {
    @Test
    public void menuFunctionTest() throws Exception {
        PrintStream console = System.out;
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bytes));

        MenuNodeForListMovies menuNodeForListMovies = new MenuNodeForListMovies();
        MovieManager movieManager = new MovieManager();
        UserClass user = new UserClass("2222222" , "2222" , "Xujun" , "1" , "2222@test.com" , "13222222222" , null);
        menuNodeForListMovies.setMyFarther(menuNodeForListMovies);
        MenuNode returnedMenuNode = menuNodeForListMovies.menuFunction(movieManager , user);
        String expectPrintString =  "Movie Name               Year                     Director                 Movie Rating             " + "\n" +
                                    "Movie1970                1970                     Director1970             unrated                  " + "\n" +
                                    "Movie1971                1971                     Director1971             1                        " + "\n" +
                                    "Movie1972                1972                     Director1972             2                        " + "\n" +
                                    "Movie1973                1973                     Director1973             3                        " + "\n" +
                                    "Movie1974                1974                     Director1974             4                        " + "\n" + "\n";
        assertEquals(menuNodeForListMovies, returnedMenuNode);
        assertEquals(expectPrintString, bytes.toString());

        System.setOut(console);
    }
}
