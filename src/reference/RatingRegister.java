package reference;

import reference.domain.Film;
import reference.domain.Person;
import reference.domain.Rating;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RatingRegister {
    private Map<Film, List<Rating>> ratings;
    private Map<Person, Map<Film, Rating>> personalRatings;

    public RatingRegister() {
        //ArrayList<Rating> ratings = new ArrayList<>();
        this.ratings = new HashMap<>();
        this.personalRatings = new HashMap<>();
    }

    public void addRating(Film film, Rating rating) {
        if (ratings.containsKey(film)) {
            List<Rating> current = ratings.get(film);
            current.add(rating);
            ratings.put(film, current);
        } else {
            ArrayList<Rating> current = new ArrayList<>();
            current.add(rating);
            ratings.put(film, current);
        }
    }

    public void addRating(Person person, Film film, Rating rating) {
        addRating(film, rating);

        if (personalRatings.containsKey(person)) {
            Map<Film, Rating> personal = personalRatings.get(person);
            personal.put(film, rating);
            personalRatings.put(person, personal);
        } else {
            Map<Film, Rating> personal = new HashMap<>();
            personal.put(film, rating);
            personalRatings.put(person, personal);
        }

    }

    public Rating getRating(Person person, Film film) {
        if (personalRatings.containsKey(person)) {
            Map<Film, Rating> current = personalRatings.get(person);
            if (current.containsKey(film)) {
                return current.get(film);
            } else {
                return Rating.NOT_WATCHED;
            }
        } else {
            return Rating.NOT_WATCHED;
        }
    }

    public Map<Film, Rating> getPersonalRatings(Person person) {
        if (personalRatings.containsKey(person)) {
            return personalRatings.get(person);
        } else {
            return null;
        }
    }

    public List<Person> reviewers() {
        List<Person> l = new ArrayList<Person>(personalRatings.keySet());
        return l;
    }

    public List<Rating> getRatings(Film film) {
        return ratings.get(film);
    }

    public Map<Film, List<Rating>> filmRatings() {
        return ratings;
    }
}
