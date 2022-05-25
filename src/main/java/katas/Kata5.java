package katas;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import model.BoxArt;
import model.Movie;
import model.MovieList;
import util.DataUtil;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
    Goal: Retrieve the largest rating using reduce()
    DataSource: DataUtil.getMovies()
    Output: Double
*/
public class Kata5 {
    public static Double execute() {
        List<Movie> movies = DataUtil.getMovies();
        Double largestRating = movies.stream()
                .mapToDouble( m -> m.getRating())
                .reduce(0,(a,b) -> a>b?a:b);
             System.out.println(largestRating);

        return largestRating;
    }
    //1) I create a Double variable to store the largest rating
    //2) with movies.stream() I create a stream of movies objects
    //3)  I use mapToDouble() to return a list of Double Streams
    //4) I use reduce( identity, accumulator) my identity is 0 cause I don't really need it
    // and my accumulator is a lambda that will calculate the max valor
    //in this lambda I have a ternary operator that works as an if else
    //if the condition is true, I will receive a if it's not I will receive b
    //5) I print the value

}
