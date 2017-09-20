package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.twu.biblioteca.ConsoleIOFunc.generateSpecificLengthOfString;

class BookManager extends ManagerClass{
    private List<BookClass> bookList = new ArrayList<BookClass>();
    BookManager(){
        String bookName = "Book";
        String author = "Author";
        Integer year = 1970;
        for(; year < 1975; year++){
            BookClass newBook = new BookClass(bookName + year.toString() , author + year.toString() , year);
            bookList.add(newBook);
        }
    }
    private int findIndexInBookList(BookClass bookObj){
        BookClass bookTemp ;
        for(int index = 0; index < this.bookList.size(); index++){
            bookTemp = this.bookList.get(index);
            if(bookTemp.checkIfASameBook(bookObj)){
                return index;
            }
        }
        return -1;
    }
    boolean checkOutABook(BookClass bookObj , UserClass user){
        int index = this.findIndexInBookList(bookObj);
        if(index == -1){
            return false;
        }
        return this.bookList.get(index).checkOutTheBook(user);
    }
    boolean returnABook(BookClass bookObj , UserClass user){
        int index = findIndexInBookList(bookObj);
        if(index == -1){
            return false;
        }
        return this.bookList.get(index).returnTheBook(user);
    }
    void printBookListNotCheckedOut(int contentLength){
        String printInfo = "";
        BookClass bookTemp;
        printInfo += generateSpecificLengthOfString(contentLength , "Book Name") +
                generateSpecificLengthOfString(contentLength , "Author/Year Published") + "\n";
        for(int index = 0; index < this.bookList.size(); index++){
            bookTemp = this.bookList.get(index);
            if(!bookTemp.isCheckedOut()) {
                printInfo += bookTemp.generatePrintInfoOfThisBookWithoutUserInfo(contentLength);
            }
        }
        System.out.println(printInfo);
    }
    void printBookListIsCheckedOut(int contentLength){
        String printInfo = "";
        BookClass bookTemp;
        printInfo += generateSpecificLengthOfString(contentLength , "Book Name") +
                generateSpecificLengthOfString(contentLength , "Author/Year Published") +
                generateSpecificLengthOfString(contentLength , "User Id") +
                generateSpecificLengthOfString(contentLength , "User Name") +
                generateSpecificLengthOfString(contentLength , "Email Address") +
                generateSpecificLengthOfString(contentLength , "Phone Number") + "\n";
        for(int index = 0; index < this.bookList.size(); index++){
            bookTemp = this.bookList.get(index);
            if(bookTemp.isCheckedOut()) {
                printInfo += bookTemp.generatePrintInfoOfThisBookWithUserInfo(contentLength);
            }
        }
        System.out.println(printInfo);
    }
    static BookClass generateBookObjFromString(String bookInfo){
        String pattern = "([^,]+),([^,]+),(\\d+)";
        Pattern patternObj = Pattern.compile(pattern);
        Matcher matcherObj = patternObj.matcher(bookInfo);
        if (matcherObj.find() && matcherObj.groupCount() == 3){
            return new BookClass(matcherObj.group(1) , matcherObj.group(2) , Integer.parseInt(matcherObj.group(3)));
        } else {
            return null;
        }
    }
}
