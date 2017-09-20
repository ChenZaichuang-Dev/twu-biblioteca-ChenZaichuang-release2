package com.twu.biblioteca;

import java.util.Map;

import static com.twu.biblioteca.ConsoleIOFunc.generateSpecificLengthOfString;

public class MovieClass{
    private String name;
    private Integer year;
    private String director;
    private String rate;
    private boolean isCheckedOut = false;
    private UserClass checkedUser;
    public MovieClass(String name, Integer year , String director , String rate) {
        this.name = name;
        this.year = year;
        this.director = director;
        this.rate = rate.equals("0") ? "unrated" : rate;
    }
    public boolean checkOutTheMovie(UserClass checkedUser){
        if(this.isCheckedOut){
            return false;
        }
        this.isCheckedOut = true;
        this.checkedUser = checkedUser;
        return true;
    }
    public boolean isCheckedOut(){
        return this.isCheckedOut;
    }
    public boolean checkIfASameMovie(MovieClass movieObj){
        return (movieObj.name.equals(this.name) && movieObj.director.equals(this.director) && movieObj.rate.equals(this.rate) && movieObj.year.equals(this.year));
    }
    public String generatePrintInfoOfThisMovie(int contentLength){
        return generateSpecificLengthOfString(contentLength , this.name) +
                generateSpecificLengthOfString(contentLength , this.year.toString()) +
                generateSpecificLengthOfString(contentLength , this.director) +
                generateSpecificLengthOfString(contentLength , this.rate.toString()) + "\n";
    }
}
