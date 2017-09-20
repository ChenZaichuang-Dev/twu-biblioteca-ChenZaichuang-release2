package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.twu.biblioteca.ConsoleIOFunc.generateSpecificLengthOfString;

public class MovieManager extends ManagerClass {
    private List<MovieClass> movieList = new ArrayList<>();
    MovieManager(){
        String name = "Movie";
        String director = "Director";
        Integer year = 1970;
        Integer rate = 0;
        for(; year < 1975; year++ , rate++){
            MovieClass newMovie = new MovieClass(name + year.toString() , year ,director + year.toString() , rate.toString());
            movieList.add(newMovie);
        }
    }
    private int findIndexInMovieList(MovieClass movieObj){
        MovieClass movieTemp ;
        for(int index = 0; index < this.movieList.size(); index++){
            movieTemp = this.movieList.get(index);
            if(movieTemp.checkIfASameMovie(movieObj)){
                return index;
            }
        }
        return -1;
    }
    boolean checkOutAMovie(MovieClass movieObj ,UserClass user){
        int index = this.findIndexInMovieList(movieObj);
        if(index == -1){
            return false;
        }
        return this.movieList.get(index).checkOutTheMovie(user);
    }
    void printMovieListNotCheckedOut(int contentLength){
        String printInfo = "";
        MovieClass movieTemp;
        printInfo += generateSpecificLengthOfString(contentLength , "Movie Name") +
                    generateSpecificLengthOfString(contentLength , "Year") +
                    generateSpecificLengthOfString(contentLength , "Director") +
                    generateSpecificLengthOfString(contentLength , "Movie Rating") +
                        "\n";
        for(int index = 0; index < this.movieList.size(); index++){
            movieTemp = this.movieList.get(index);
            if(!movieTemp.isCheckedOut()) {
                printInfo += movieTemp.generatePrintInfoOfThisMovie(contentLength);
            }
        }
        System.out.println(printInfo);
    }
    static MovieClass generateMovieObjFromString(String movieInfo){
        String pattern = "([^,]+),(\\d+),([^,]+),([^,]+)";
        Pattern patternObj = Pattern.compile(pattern);
        Matcher matcherObj = patternObj.matcher(movieInfo);
        if (matcherObj.find() && matcherObj.groupCount() == 4){
            return new MovieClass(matcherObj.group(1) , Integer.parseInt(matcherObj.group(2)) , matcherObj.group(3) , matcherObj.group(4));
        } else {
            return null;
        }
    }
}
