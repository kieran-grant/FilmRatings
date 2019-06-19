package reference;

import reference.comparator.FilmComparator;
import reference.domain.Film;
import reference.domain.Person;
import reference.domain.Rating;

import java.util.*;

public class Reference {
    private RatingRegister register;

    public Reference(RatingRegister register) {
        this.register = register;
    }

    public Film recommendFilm(Person person) {
        Map<Film, List<Rating>> filmRatings = register.filmRatings();
        List<Film> films = new ArrayList<Film>(filmRatings.keySet());
        Collections.sort(films, new FilmComparator(filmRatings));
        return films.get(0);
    }
}
