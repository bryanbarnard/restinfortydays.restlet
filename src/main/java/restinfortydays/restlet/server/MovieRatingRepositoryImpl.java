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
        MovieRating movieRating = new MovieRating(1, "Goonies", "Comedy", 1987, 10);
        movies.add(movieRating);

        MovieRating movieRating1 = new MovieRating(2, "CaddyShack", "Comedy", 1978, 8);
        movies.add(movieRating1);
    }

    public static MovieRatingRepositoryImpl getInstance() {
        if (movieRatingRepository == null) {
            movieRatingRepository = new MovieRatingRepositoryImpl();
        }
        return movieRatingRepository;
    }

    public MovieRating find(Integer movieRatingIdIn) {
        for (int i = 0; i < this.movies.size(); i++) {
            if (this.movies.get(i).getId() == movieRatingIdIn) {
                return this.movies.get(i);
            }
        }
        return this.movies.get(0); /* default */
    }

    public List<MovieRating> all() {
        return this.movies;
    }

    public boolean update(MovieRating movieRating) {
        if (this.movies.size() <= 0) {
            this.movies.add(movieRating);
            return true;
        } else {
            for (int i = 0; i < this.movies.size(); i++) {
                if (this.movies.get(i).getId() == movieRating.getId()) {
                    this.movies.set(i, movieRating);
                    return true;
                }
            }
        }
        return false;
    }

    public MovieRating store(MovieRating movieRating) {
        this.movies.add(movieRating);
        return this.movies.get(movies.size());
    }

    @Override
    public boolean remove(Integer movieRatingIdIn) {
        if (this.movies.size() > 0) {
            for (int i = 0; i < this.movies.size(); i++) {
                if (this.movies.get(i).getId() == movieRatingIdIn) {
                    this.movies.remove(i);
                    return true;
                }
            }
            return false;
        }
        return false;
    }
}
