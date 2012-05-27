package restinfortydays.restlet.server;

import org.restlet.data.Status;
import org.restlet.resource.ServerResource;
import restinfortydays.restlet.common.MovieRating;
import restinfortydays.restlet.common.MovieRatingResource;

public class MovieRatingServerResource extends ServerResource implements MovieRatingResource {

    @Override
    public MovieRating represent(Integer movieRatingIdIn) {
        /* get(id) */
        setStatus(Status.SUCCESS_OK);
        return MovieRatingRepositoryImpl.getInstance().find(movieRatingIdIn);
    }

    @Override
    public void store(MovieRating movieRatingIn) {
        MovieRatingRepositoryImpl.getInstance().update(movieRatingIn);
        setStatus(Status.CLIENT_ERROR_NOT_FOUND, movieRatingIn.getId().toString());
    }

    @Override
    public void remove(Integer movieRatingIdIn) {
        /* delete */

        setStatus(Status.SERVER_ERROR_INTERNAL, movieRatingIdIn.toString());
    }
}
