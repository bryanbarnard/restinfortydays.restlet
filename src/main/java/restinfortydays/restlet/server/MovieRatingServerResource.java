package restinfortydays.restlet.server;

import org.restlet.data.Form;
import org.restlet.data.MediaType;
import org.restlet.data.Status;
import org.restlet.representation.Representation;
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
    public void store(Representation entity) {
        /* Post */
        if (entity.getMediaType().equals(MediaType.APPLICATION_WWW_FORM,
                true)) {
            Form form = new Form(entity);
            String movieRatingTitle = form.getFirstValue("title");
            String movieRatingId = form.getFirstValue("id");
            String movieRatingGenre = form.getFirstValue("genre");
            String movieRatingReleaseYear = form.getFirstValue("releaseyear");
            String movieRatingValue = form.getFirstValue("rating");

            MovieRating movieRating = new MovieRating(Integer.parseInt(movieRatingId), movieRatingTitle, movieRatingGenre,
                    Integer.parseInt(movieRatingReleaseYear), Integer.parseInt(movieRatingValue));

            if (MovieRatingRepositoryImpl.getInstance().update(movieRating) == true) {
                setStatus(Status.SUCCESS_OK);
            } else {
                setStatus(Status.CLIENT_ERROR_BAD_REQUEST);
            }
        } else {
            setStatus(Status.CLIENT_ERROR_BAD_REQUEST);
        }
    }

    @Override
    public void remove(Integer movieRatingIdIn) {
        /* DELETE */
        MovieRatingRepositoryImpl.getInstance().remove(movieRatingIdIn);

        setStatus(Status.SUCCESS_OK);
    }
}
