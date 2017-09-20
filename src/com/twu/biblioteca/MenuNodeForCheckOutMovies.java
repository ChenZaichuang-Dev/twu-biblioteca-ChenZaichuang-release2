package com.twu.biblioteca;

import java.io.IOException;
import java.util.Map;

import static com.twu.biblioteca.ConsoleIOFunc.clearTheConsoleContent;
import static com.twu.biblioteca.ConsoleIOFunc.showInfoAndReadDataFromConsole;
import static com.twu.biblioteca.ConsoleIOFunc.showInfoToConsole;

public class MenuNodeForCheckOutMovies extends MenuNode {
    private MovieManager movieManager;
    private UserClass user;
    MenuNodeForCheckOutMovies(){
        this.dataNeeded = "MovieManager";
        this.menuNodeName = "Check Out Movies";
    }
    public MenuNode menuFunction(ManagerClass managerObj , UserClass user) throws IOException {
        String input;
        this.movieManager = (MovieManager)managerObj;
        this.user = user;
        clearTheConsoleContent();
        this.printInfo = "Please input the movie name , year , director and rating (eg:testMovie,2017,Me,3)\n" +
                "and input q for quit:";
        input = showInfoAndReadDataFromConsole(this.printInfo);
        if(input.equals("q")){
            return this.fartherMenuNode.get(0);
        }
        boolean result = this.handleInput(input);
        this.handleInputResult(result);
        return result ? this.fartherMenuNode.get(0) : this;
    }
    private boolean handleInput(String input){
        MovieClass movieObj = MovieManager.generateMovieObjFromString(input);
        if(movieObj == null){
            return false;
        }
        return this.movieManager.checkOutAMovie(movieObj , this.user);
    }
    private void handleInputResult(boolean result){
        this.printInfo = result ? "Thank you! Enjoy the movie\n" : "That movie is not available.\n";
        showInfoToConsole(this.printInfo);
    }
}
