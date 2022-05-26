package katas;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import model.Bookmark;
import model.Movie;
import model.MovieList;
import util.DataUtil;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
    Goal: Retrieve each video's id, title, middle interesting moment time, and smallest box art url
    DataSource: DataUtil.getMovies()
    Output: List of ImmutableMap.of("id", 5, "title", "some title", "time", new Date(), "url", "someUrl")
*/
public class Kata9 {
    public static List<Map> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();

        List<Map> newList = movieLists.stream()
                .flatMap( m -> m.getVideos().stream())
                .map(n -> ImmutableMap.of("id", n.getId(), "title", n.getTitle(), "time", n.getInterestingMoments().stream().map(l-> l.getTime()).collect(Collectors.toList()), "url", n.getBoxarts().stream()
                        .reduce((a,b) -> a.getWidth() < a.getHeight()? a:b).map(p -> p.getUrl()))).collect(Collectors.toList());

        System.out.println(newList);

        return newList;
    }
}
