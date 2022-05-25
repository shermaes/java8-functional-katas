package katas;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import model.Movie;
import util.DataUtil;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
    Goal: Chain filter() and map() to collect the ids of videos that have a rating of 5.0
    DataSource: DataUtil.getMovies()
    Output: List of Integers
*/
public class Kata2 {
    public static List<Integer> execute() {
        List<Movie> movies = DataUtil.getMovies();

        List<Integer> videos = movies.stream()
        .filter(i -> i.getRating()==5)
        .map(m->m.getId())
            .collect(Collectors.toList());
        System.out.println(videos);
        return videos;
    }
    //1) I create a list of Integer objects
    //2) with movies.stream() I create a stream of movies objects
    //3) I use filter to get the objects with rating 5 using the condition passed on the lambda
    //4)  I use .map to return a stream consisting of the results of applying the given function
    //5)with collect(Collectors.toList()) I accumulate the results into a list
}
