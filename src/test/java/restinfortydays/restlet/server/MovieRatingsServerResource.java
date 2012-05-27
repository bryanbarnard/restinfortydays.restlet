package restinfortydays.restlet.server;

import org.restlet.resource.ServerResource;
import restinfortydays.restlet.common.*;


import java.util.List;

public class MovieRatingsServerResource extends ServerResource implements MovieRatingsResource{


    @Override
    public List<MovieRating> represent() {
       return MovieRatingRepositoryImpl.getInstance().all();
    }

    @Override
    public MovieRating add(MovieRating movieRatingIn) {
       return MovieRatingRepositoryImpl.getInstance().store(movieRatingIn);
    }
}