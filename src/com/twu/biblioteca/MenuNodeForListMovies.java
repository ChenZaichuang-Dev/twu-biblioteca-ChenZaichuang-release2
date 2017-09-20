package com.twu.biblioteca;

import java.io.IOException;
import java.util.Map;

import static com.twu.biblioteca.ConsoleIOFunc.clearTheConsoleContent;

public class MenuNodeForListMovies extends MenuNode {
    private MovieManager movieManager;
    MenuNodeForListMovies(){
        this.dataNeeded = "MovieManager";
        this.menuNodeName = "List Movies";
    }
    public MenuNode menuFunction(ManagerClass managerObj , UserClass user) throws IOException {
        this.movieManager = (MovieManager)managerObj;
        clearTheConsoleContent();
        int contentLength = 25;
        this.movieManager.printMovieListNotCheckedOut(contentLength);
        return this.fartherMenuNode.get(0);
    }
}
