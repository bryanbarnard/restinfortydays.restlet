package restinfortydays.restlet.server;

import org.restlet.data.Form;
import org.restlet.data.MediaType;
import org.restlet.data.Status;
import org.restlet.representation.Representation;
import org.restlet.resource.ServerResource;
import restinfortydays.restlet.common.MovieRating;
import restinfortydays.restlet.common.MovieRatingsResource;

import java.util.List;

public class MovieRatingsServerResource extends ServerResource implements MovieRatingsResource {


    @Override
    public List<MovieRating> represent() {
        return MovieRatingRepositoryImpl.getInstance().all();
    }

    @Override
    public void add(Representation entity) {
        /* Post */

        /* Sample Post Form Values
            title=GrapesOfWrath
            genre=drama
            releaseyear=1967
            id=6
            rating=10
         */

        /* URL ENCODED: genre=comedy&id=8&releaseyear=1978&rating=10&title=CaddyShack&= */

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
            MovieRatingRepositoryImpl.getInstance().store(movieRating);

            setStatus(Status.SUCCESS_OK);
        } else {
            setStatus(Status.CLIENT_ERROR_BAD_REQUEST);
        }
    }
}
