package restinfortydays.restlet.common;

public interface MovieRatingRepository {

    /**
     * find a movieRating by id
     * @param movieRatingIdIn
     * @return
     */
    MovieRating find(Integer movieRatingIdIn);

    /**
     * update an existing movieRating
     * @param movieRating
     * @return
     */
    MovieRating update(MovieRating movieRating);

    /**
     * add a movieRating to the repo
     * @param movieRating
     */
    MovieRating store(MovieRating movieRating);

}
