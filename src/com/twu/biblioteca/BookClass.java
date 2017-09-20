package com.twu.biblioteca;

import static com.twu.biblioteca.ConsoleIOFunc.generateSpecificLengthOfString;

public class BookClass {
    private String bookName;
    private String author;
    private Integer yearPublished;
    private boolean isCheckedOut = false;
    private UserClass checkedUser;
    public BookClass(String bookName, String author , Integer yearPublished) {
        this.bookName = bookName;
        this.author = author;
        this.yearPublished = yearPublished;
    }
    public boolean checkIfASameBook(BookClass bookObj){
        return (bookObj.bookName.equals(this.bookName) && bookObj.author.equals(this.author) && bookObj.yearPublished.equals(this.yearPublished));
    }
    public boolean checkOutTheBook(UserClass checkedUser){
        if(this.isCheckedOut){
            return false;
        }
        this.isCheckedOut = true;
        this.checkedUser = checkedUser;
        return true;
    }
    public boolean returnTheBook(UserClass checkedUser){
        if(!this.isCheckedOut || !UserClass.checkIfTwoUsersAreSame(this.checkedUser , checkedUser)){
            return false;
        }
        this.isCheckedOut = false;
        return true;
    }
    public boolean isCheckedOut(){
        return this.isCheckedOut;
    }
    public String generatePrintInfoOfThisBookWithoutUserInfo(int contentLength){
        return generateSpecificLengthOfString(contentLength , this.bookName) +
                generateSpecificLengthOfString(contentLength , this.author + "/" + this.yearPublished.toString()) + "\n";
    }
    public String generatePrintInfoOfThisBookWithUserInfo(int contentLength){
        return generateSpecificLengthOfString(contentLength , this.bookName) +
                generateSpecificLengthOfString(contentLength , this.author + "/" + this.yearPublished.toString()) +
                generateSpecificLengthOfString(contentLength , this.checkedUser.userInfo.get("id")) +
                generateSpecificLengthOfString(contentLength , this.checkedUser.userInfo.get("name")) +
                generateSpecificLengthOfString(contentLength , this.checkedUser.userInfo.get("emailAddress")) +
                generateSpecificLengthOfString(contentLength , this.checkedUser.userInfo.get("phoneNumber")) + "\n";
    }
}
