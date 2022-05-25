package katas;

import com.google.common.collect.ImmutableMap;
import model.Movie;
import util.DataUtil;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
    Goal: use map() to project an array of videos into an array of {id, title}-pairs
    DataSource: DataUtil.getMovies()
    Output: List of ImmutableMap.of("id", "5", "title", "Bad Boys")
*/
public class Kata1 {
    public static List<Map> execute() {
        List<Movie> movies = DataUtil.getMovies();
// .map() -> 	map(Function<? super T,? extends R> mapper)
//Returns a stream consisting of the results of applying the given function to the elements of this stream.

        List<Map> newMovies = movies.stream()
                .map(m -> ImmutableMap.of("id", m.getId(), "title", m.getTitle()))
                .collect(Collectors.toList());
        System.out.println(newMovies);

        //1)I create a list of "mappable" objects
        //2) with movies.stream() I create a stream of movies objects
        //What's a stream? A sequence of elements supporting sequential and parallel aggregate operations.
        //3) I use .map to return a stream consisting of the results of applying the given function (the lambda in this case)
        // to the elements of this stream.
        //4) with collect(Collectors.toList()) I accumulate the results into a list
        return newMovies;
    }
}
