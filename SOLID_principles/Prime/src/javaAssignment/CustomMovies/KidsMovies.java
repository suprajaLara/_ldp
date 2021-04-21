package javaAssignment.CustomMovies;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javaAssignment.Movies.MovieWithActorFilter;
import javaAssignment.Rating.UserRating;

public class KidsMovies extends MovieWithActorFilter{
	UserRating rating;
	String moviename;
	public KidsMovies() {
		super.intializeMovies();
		this.intializeMovies();
	}
	public void takeRating(String moviename, UserRating rating) {
		this.moviename=moviename;
		this.rating=rating;
	}
	
	HashMap<String,List<String>> moviesGenreMap = new HashMap<String,List<String>>();
	HashMap<String,List<String>> moviesLanguageMap = new HashMap<String,List<String>>();
	HashMap<String,List<String>> moviesActorMap = new HashMap<String,List<String>>();	
	
	@Override
	public void intializeMovies() {
		moviesGenreMap.put("Adventure",new ArrayList<String>(Arrays.asList("The lion king","Frozen","Little hero")));
		moviesGenreMap.put("Comedy",new ArrayList<String>(Arrays.asList("Despicable me","Tom and jerry","Mr.Bean","Mr.Bean's Holiday")));
		moviesLanguageMap.put("Telugu",new ArrayList<String>(Arrays.asList("Little hero","The lion king")));
		moviesLanguageMap.put("Hindi",new ArrayList<String>(Arrays.asList("Tom and jerry","Despicable me")));
		moviesLanguageMap.put("English",new ArrayList<String>(Arrays.asList("Frozen","Mr.Bean","Mr.Bean's Holiday")));
		moviesActorMap.put("Rowan Atkinson",new ArrayList<String>(Arrays.asList("Mr.Bean","Mr.Bean's Holiday")));
	}
	
	@Override
	public List<String> filterByActors(String actor) {
		System.out.println("method call from kids movies");
		return moviesActorMap.get(actor);
	}

	@Override
	public List<String> filterByGenres(String genre) {
		System.out.println("method call from kids movies");
		return moviesGenreMap.get(genre);
	}

	@Override
	public List<String> filterByLanguages(String language) {
		System.out.println("method call from kids movies");
		return moviesLanguageMap.get(language);
	}

	@Override
	public List<String> displayGenres() {
		System.out.println("method call from kids movies");
		return new ArrayList<String>(moviesGenreMap.keySet());
	}

	@Override
	public List<String> displayLanguages() {
		System.out.println("method call from kids movies");
		return new ArrayList<String>(moviesLanguageMap.keySet());
	}
	
}
