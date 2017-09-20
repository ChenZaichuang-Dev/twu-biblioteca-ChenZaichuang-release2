package com.twu.biblioteca;

import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;

public class MenuNodeForCheckMoviesTest {
    @Test
    public void menuFunctionTest() throws IOException {
        PrintStream console = System.out;
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bytes));
        InputStream keyBoard = System.in;

        System.setIn(new FileInputStream("resource/inputOptionNumber0.txt"));
        MenuNodeForCheckOutMovies menuNodeForCheckOutMovies = new MenuNodeForCheckOutMovies();
        UserClass user = new UserClass("2222222", "2222", "Xujun", "1", "2222@test.com", "13222222222", null);
        MovieManager movieManager = new MovieManager();
        menuNodeForCheckOutMovies.setMyFarther(null);
        MenuNode returnedMenuNode = menuNodeForCheckOutMovies.menuFunction(movieManager, user);
        String expectPrintString = "Please input the movie name , year , director and rating (eg:testMovie,2017,Me,3)\n" +
                "and input q for quit:" + "That movie is not available.\n";
        assertEquals(menuNodeForCheckOutMovies, returnedMenuNode);
        assertEquals(expectPrintString, bytes.toString());
        System.setIn(new FileInputStream("resource/inputContentOfMovieInfo.txt"));
        returnedMenuNode = menuNodeForCheckOutMovies.menuFunction(movieManager, user);
        expectPrintString += "Please input the movie name , year , director and rating (eg:testMovie,2017,Me,3)\n" +
                "and input q for quit:" + "Thank you! Enjoy the movie\n";
        assertEquals(null, returnedMenuNode);
        assertEquals(expectPrintString, bytes.toString());
        System.setIn(new FileInputStream("resource/inputQForQuit.txt"));
        returnedMenuNode = menuNodeForCheckOutMovies.menuFunction(movieManager, user);
        expectPrintString += "Please input the movie name , year , director and rating (eg:testMovie,2017,Me,3)\n" +
                "and input q for quit:";
        assertEquals(null, returnedMenuNode);
        assertEquals(expectPrintString, bytes.toString());

        System.setOut(console);
        System.setIn(keyBoard);
    }
}
