package com.twu.biblioteca;

import java.io.IOException;
import java.util.Map;

import static com.twu.biblioteca.ConsoleIOFunc.clearTheConsoleContent;

public class MenuNodeForListBooks extends MenuNode {
    private BookManager bookManager;
    MenuNodeForListBooks(){
        this.dataNeeded = "BookManager";
        this.menuNodeName = "List Books";
    }
    public MenuNode menuFunction(ManagerClass managerObj , UserClass user) throws IOException {
        this.bookManager = (BookManager) managerObj;
        clearTheConsoleContent();
        int contentLength = 25;
        this.bookManager.printBookListNotCheckedOut(contentLength);
        return this.fartherMenuNode.get(0);
    }
}
