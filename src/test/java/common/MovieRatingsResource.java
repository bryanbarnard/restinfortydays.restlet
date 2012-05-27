package common;

import org.restlet.resource.Get;
import org.restlet.resource.Post;

import java.util.List;

public interface MovieRatingsResource {

    @Get
    public List<MovieRating> represent();

    @Post
    public MovieRating add(MovieRating movieRatingIn);

}
