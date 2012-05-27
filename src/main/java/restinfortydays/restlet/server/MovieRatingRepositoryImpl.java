package restinfortydays.restlet.server;

import restinfortydays.restlet.common.MovieRating;
import restinfortydays.restlet.common.MovieRatingRepository;
import java.util.ArrayList;
import java.util.List;

public class MovieRatingRepositoryImpl implements MovieRatingRepository {

    private static MovieRatingRepositoryImpl movieRatingRepository;
    private List<MovieRating> movies;

    private MovieRatingRepositoryImpl() {
        movies = new ArrayList<MovieRating>();

        /* build our data */
        MovieRating movieRating = new MovieRating(1,"Goonies","Comedy",1987,10);
        movies.add(movieRating);

        MovieRating movieRating1 = new MovieRating(2,"CaddyShack","Comedy",1978,8);
        movies.add(movieRating1);
    }

    public static MovieRatingRepositoryImpl getInstance() {
        if (movieRatingRepository == null) {
            movieRatingRepository = new MovieRatingRepositoryImpl();
        }
        return movieRatingRepository;
    }

    public MovieRating find(Integer movieRatingIdIn) {
        return movies.get(movieRatingIdIn);
    }

    public List<MovieRating> all() {
        return movies;
    }

    public MovieRating update(MovieRating movieRating) {
        return null;
    }

    public MovieRating store(MovieRating movieRating) {
       movies.add(movieRating);
       return movies.get(movies.size());
    }
}
