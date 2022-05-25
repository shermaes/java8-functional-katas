package katas;

import model.BoxArt;
import model.Movie;
import util.DataUtil;

import java.util.List;

/*
    Goal: Retrieve the url of the largest boxart using map() and reduce()
    DataSource: DataUtil.getMovieLists()
    Output: String
*/
public class Kata6 {
    public static String execute() {
        List<Movie> movies = DataUtil.getMovies();

String urlLargestBoxart = movies.stream()
        .flatMap( m -> m.getBoxarts().stream())
        .reduce((a, b) -> a.getHeight()>b.getHeight()&&a.getWidth()>b.getWidth()?a:b)
                .map(m -> m.getUrl()).toString();

System.out.print(urlLargestBoxart);

        return urlLargestBoxart;
    }
}
