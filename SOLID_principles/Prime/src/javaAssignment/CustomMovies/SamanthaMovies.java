package javaAssignment.CustomMovies;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javaAssignment.Movies.MoviesWithoutActorFilter;

public class SamanthaMovies extends MoviesWithoutActorFilter{
	HashMap<String,List<String>> moviesGenreMap = new HashMap<String,List<String>>();
	HashMap<String,List<String>> moviesLanguageMap = new HashMap<String,List<String>>();	
	public SamanthaMovies() {
		super.intializeMovies();
		this.intializeMovies();
	}
	
	@Override
	public void intializeMovies() {
		this.moviesGenreMap.put("Thriller",new ArrayList<String>(Arrays.asList("Super Deluxe","Uturn")));
		this.moviesGenreMap.put("Comedy",new ArrayList<String>(Arrays.asList("Oh baby","Seemaraja")));
		this.moviesLanguageMap.put("Telugu",new ArrayList<String>(Arrays.asList("Uturn","Oh baby")));
		this.moviesLanguageMap.put("Tamil",new ArrayList<String>(Arrays.asList("Super Deluxe","Seemaraja")));
	}
	
	@Override
	public List<String> filterByGenres(String genre) {
		System.out.println("method call from samantha movies");
		return moviesGenreMap.get(genre);
	}

	@Override
	public List<String> filterByLanguages(String language) {
		System.out.println("method call from samantha movies");
		return moviesLanguageMap.get(language);
	}

	@Override
	public List<String> displayGenres() {
		System.out.println("method call from samantha movies");
		return new ArrayList<String>(moviesGenreMap.keySet());
	}

	@Override
	public List<String> displayLanguages() {
		System.out.println("method call from samantha movies");
		return new ArrayList<String>(moviesLanguageMap.keySet());
	}
	
}