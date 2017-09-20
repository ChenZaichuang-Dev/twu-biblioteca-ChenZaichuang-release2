package com.twu.biblioteca;

import java.io.IOException;

class MenuNodeManager {
    private MenuNodeHead menuNodeHead = new MenuNodeHead();
    private static BookManager bookManager = new BookManager();
    private static MovieManager movieManager = new MovieManager();
    private UserManager userManager;
    private UserClass user;
    MenuNodeManager(UserManager userManager , UserClass user){
        String permissionLevel = user.userInfo.get("permissionLevel");
        this.userManager = userManager;
        this.user = user;
        MenuNodeForListBooks menuNodeForListBooks = new MenuNodeForListBooks();
        MenuNodeForCheckOutBooks menuNodeForCheckOutBooks = new MenuNodeForCheckOutBooks();
        MenuNodeForReturnBooks menuNodeForReturnBooks = new MenuNodeForReturnBooks();
        MenuNodeForQuit menuNodeForQuit = new MenuNodeForQuit();
        MenuNodeForListMovies menuNodeForListMovies = new MenuNodeForListMovies();
        MenuNodeForCheckOutMovies menuNodeForCheckOutMovies = new MenuNodeForCheckOutMovies();
        MenuNodeForLogIn  menuNodeForLogIn = new MenuNodeForLogIn();
        MenuNodeForLogOut menuNodeForLogOut = new MenuNodeForLogOut();
        MenuNodeForListCheckOutBooks menuNodeForListCheckOutBooks = new MenuNodeForListCheckOutBooks();
        MenuNodeForShowUserInfo menuNodeForShowUserInfo = new MenuNodeForShowUserInfo();
        switch(permissionLevel){
            case "0":setFatherAndChild(this.menuNodeHead , menuNodeForLogIn);
                    setFatherAndChild(this.menuNodeHead , menuNodeForListBooks);
                    setFatherAndChild(this.menuNodeHead , menuNodeForListMovies);
                    setFatherAndChild(this.menuNodeHead , menuNodeForQuit);
                    break;
            case "1":setFatherAndChild(this.menuNodeHead , menuNodeForListBooks);
                setFatherAndChild(this.menuNodeHead , menuNodeForCheckOutBooks);
                setFatherAndChild(this.menuNodeHead , menuNodeForReturnBooks);
                setFatherAndChild(this.menuNodeHead , menuNodeForListMovies);
                setFatherAndChild(this.menuNodeHead , menuNodeForCheckOutMovies);
                setFatherAndChild(this.menuNodeHead , menuNodeForShowUserInfo);
                setFatherAndChild(this.menuNodeHead , menuNodeForLogOut);
                setFatherAndChild(this.menuNodeHead , menuNodeForQuit);
                break;
            case "2":setFatherAndChild(this.menuNodeHead , menuNodeForListBooks);
                setFatherAndChild(this.menuNodeHead , menuNodeForListCheckOutBooks);
                setFatherAndChild(this.menuNodeHead , menuNodeForCheckOutBooks);
                setFatherAndChild(this.menuNodeHead , menuNodeForReturnBooks);
                setFatherAndChild(this.menuNodeHead , menuNodeForListMovies);
                setFatherAndChild(this.menuNodeHead , menuNodeForCheckOutMovies);
                setFatherAndChild(this.menuNodeHead , menuNodeForLogOut);
                setFatherAndChild(this.menuNodeHead , menuNodeForQuit);
                break;
        }
    }
    private void setFatherAndChild(MenuNode fartherNode , MenuNode childNode){
        fartherNode.setMyChild(childNode);
        childNode.setMyFarther(fartherNode);
    }
    private ManagerClass prepareData(MenuNode runMenuNodeObj){
        switch(runMenuNodeObj.dataNeeded){
            case "BookManager": return this.bookManager;
            case "MovieManager": return this.movieManager;
            case "UserManager": return this.userManager;
            default: return this.bookManager;
        }
    }
    void runMenu() throws IOException {
        MenuNode runMenuNodeObj = this.menuNodeHead;
        ManagerClass dataNeeded;
        while(runMenuNodeObj != null){
            dataNeeded = this.prepareData(runMenuNodeObj);
            runMenuNodeObj = runMenuNodeObj.menuFunction(dataNeeded , this.user);
        }
    }
}
