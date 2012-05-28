package restinfortydays.restlet.common;

import org.restlet.representation.Representation;
import org.restlet.resource.Get;
import org.restlet.resource.Post;

import java.util.List;

public interface MovieRatingsResource {

    @Get
    public List<MovieRating> represent();

    @Post
    public void add(Representation entity);
}
