package com.twu.biblioteca;

import java.io.IOException;
import java.util.Map;

import static com.twu.biblioteca.ConsoleIOFunc.clearTheConsoleContent;
import static com.twu.biblioteca.ConsoleIOFunc.showInfoAndReadDataFromConsole;
import static com.twu.biblioteca.ConsoleIOFunc.showInfoToConsole;

public class MenuNodeForCheckOutBooks extends MenuNode{
    private BookManager bookManager;
    private UserClass user;
    MenuNodeForCheckOutBooks(){
        this.dataNeeded = "BookManager";
        this.menuNodeName = "Check Out Books";
    }
    public MenuNode menuFunction(ManagerClass managerObj , UserClass user) throws IOException {
        String input;
        this.bookManager = (BookManager) managerObj;
        this.user = user;
        clearTheConsoleContent();
        this.printInfo = "Please input the book name , author and year published (eg:testName,Me,2017)\n" +
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
        BookClass bookObj = BookManager.generateBookObjFromString(input);
        if(bookObj == null){
            return false;
        }
        return this.bookManager.checkOutABook(bookObj , this.user);
    }
    private void handleInputResult(boolean result){
        this.printInfo = result ? "Thank you! Enjoy the book\n" : "That book is not available.\n";
        showInfoToConsole(this.printInfo);
    }
}
