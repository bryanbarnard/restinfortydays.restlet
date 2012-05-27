package restinfortydays.restlet.common;

import org.restlet.resource.Delete;
import org.restlet.resource.Get;
import org.restlet.resource.Put;

public interface MovieRatingResource {

    @Get
    public MovieRating represent(Integer movieRatingIdIn);

    @Put
    public void store(MovieRating movieRatingIn);

    @Delete
    public void remove(Integer movieRatingIdIn);
}
