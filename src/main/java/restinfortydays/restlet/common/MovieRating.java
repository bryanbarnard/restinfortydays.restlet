package restinfortydays.restlet.common;

public class MovieRating {

 /* properties */
 Integer id;
 String title;
 String genre;
 Integer releaseYear;
 Integer rating;



 /* default constructor */
 public MovieRating( Integer idIn, String titleIn, String genreIn, Integer releaseYearIn, Integer ratingIn) {
     setId(idIn);
     setTitle(titleIn);
     setGenre(genreIn);
     setReleaseYear(releaseYearIn);
     setRating(ratingIn);
 }


 /* methods */

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }
}
