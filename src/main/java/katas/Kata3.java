package katas;

import com.google.common.collect.ImmutableList;
import model.Movie;
import model.MovieList;
import util.DataUtil;

import java.util.List;
import java.util.stream.Collectors;

/*
    Goal: Use map() and flatMap() to project and flatten the movieLists into an array of video ids (flatMap(c -> c.stream()))
    DataSource: DataUtil.getMovieLists()
    Output: List of Integers
*/
public class Kata3 {
    public static List<Integer> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();

        List<Integer> videoIds = movieLists.stream()
                .flatMap(videos -> videos.getVideos().stream())
                .map(id -> id.getId().intValue())
                .collect(Collectors.toList());
        System.out.println(videoIds);

        return videoIds;

        //1)I create a list of Integers
        //2) with movieLists.stream() I create a stream of movies objects
        //3) what does flatMap do?
        //Oracle:Returns a stream consisting of the results of replacing each element of the stream I created in 1)
        // with the contents of a mapped stream produced by applying the provided mapping function to each element.
        //Me: Grabs two flux and flats them into one. It even breaks the hierarchy of teh flux that contains these 2 fluxes.
        //4) I get the int value of the id using .map()
        //5) with collect(Collectors.toList()) I accumulate the results into a list
    }

}
