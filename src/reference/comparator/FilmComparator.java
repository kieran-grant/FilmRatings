package reference.comparator;
import reference.domain.Film;
import reference.domain.Rating;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class FilmComparator implements Comparator<Film> {
    private Map<Film, List<Rating>> ratings;

    public FilmComparator(Map<Film, List<Rating>> ratings) {
        this.ratings = ratings;
    }

    @Override
    public int compare(Film o1, Film o2) {
        if (o1 == null || o2 == null) {
            return 0;
        }

        int total1 = 0;
        int total2 = 0;

        for (Rating rating : ratings.get(o1)) {
            total1 += rating.getValue();
        }

        for (Rating rating : ratings.get(o2)) {
            total2 += rating.getValue();
        }

        int film1Avg = total1/ratings.get(o1).size();
        int film2Avg = total2/ratings.get(o2).size();

        return film2Avg - film1Avg;

    }


}
