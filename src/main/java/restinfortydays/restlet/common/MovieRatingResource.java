package restinfortydays.restlet.common;

import org.restlet.representation.Representation;
import org.restlet.resource.Delete;
import org.restlet.resource.Get;
import org.restlet.resource.Put;

public interface MovieRatingResource {

    @Get
    public MovieRating represent();

    @Put
    public void store(Representation entity);

    @Delete
    public void remove(Integer movieRatingIdIn);
}
