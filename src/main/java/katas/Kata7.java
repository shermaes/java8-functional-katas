package katas;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import model.Bookmark;
import model.Movie;
import model.MovieList;
import util.DataUtil;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
    Goal: Retrieve the id, title, and smallest box art url for every video
    DataSource: DataUtil.getMovieLists()
    Output: List of ImmutableMap.of("id", "5", "title", "Bad Boys", "boxart": "url)
*/
public class Kata7 {
    public static List<Map> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();


       List<Map> newVideos = movieLists.stream()
               .flatMap(m -> m.getVideos().stream())
                .map(m->
                     ImmutableMap.of("id", m.getId().toString(), "title", m.getTitle(), "boxart", m.getBoxarts().stream()
                            .reduce((a,b) -> a.getWidth() < a.getHeight()? a:b).map(l -> l.getUrl()))
                )
               .collect(Collectors.toList());
        System.out.println(newVideos);
        return newVideos;
    }
}
