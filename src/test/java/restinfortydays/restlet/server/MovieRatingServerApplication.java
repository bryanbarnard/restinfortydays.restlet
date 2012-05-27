package restinfortydays.restlet.server;

import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;

public class MovieRatingServerApplication extends Application {

    public MovieRatingServerApplication() {
        setName("RESTful Movie Rating Application");
        setDescription("RESTFul Movie Rating Application");
        setOwner("Bryan Barnard");
        setAuthor("Bryan Barnard");

        /* instantiate the repo */
        MovieRatingRepositoryImpl movieRatingsRepo = MovieRatingRepositoryImpl.getInstance();
    }

    @Override
    public Restlet createInboundRoot() {
        Router router = new Router(getContext());

        /* localhost:8111/api/ */
        router.attach("/api", RootServerResource.class);

        /* localhost:8111/api/ratings */
        router.attach("/api/ratings", MovieRatingsServerResource.class);

        /* localhost:8111/api/ratings/12 */
        router.attach("/api/ratings/{ratingId}", MovieRatingServerResource.class);

        return router;
    }
}
