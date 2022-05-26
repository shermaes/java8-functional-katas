package katas;

import com.codepoetics.protonpack.StreamUtils;
import model.Bookmark;
import model.Movie;
import util.DataUtil;

import java.util.List;
import java.util.stream.Collectors;

/*
    Goal: Combine videos and bookmarks by index (StreamUtils.zip) (https://github.com/poetix/protonpack)
    DataSource: DataUtil.getMovies()
    Output: List of ImmutableMap.of("videoId", "5", "bookmarkId", "3")
*/
public class Kata8 {
    public static List<String> execute() {
        List<Movie> movies = DataUtil.getMovies();
        List<Bookmark> bookMarks = DataUtil.getBookMarks();

  var list1 = movies.stream().map(x -> x.getId().intValue());
  var list2 = bookMarks.stream().map(m -> m.getId().intValue());

  List<String> zipped = StreamUtils.zip(list1,
                  list2,
                  (a, b) -> a + " is for " + b)
          .collect(Collectors.toList());
        System.out.println(zipped);

        return zipped;
    }
}
