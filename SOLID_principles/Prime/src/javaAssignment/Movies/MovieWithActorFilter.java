package javaAssignment.Movies;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javaAssignment.OTT.OttDisplay;
import javaAssignment.OTT.OttFilterGenres;
import javaAssignment.OTT.OttFilterLanguages;

public class MovieWithActorFilter implements OttDisplay, OttFilterGenres, OttFilterLanguages {
	HashMap<String,List<String>> moviesGenreMap = new HashMap<String,List<String>>();
	HashMap<String,List<String>> moviesLanguageMap = new HashMap<String,List<String>>();
	HashMap<String,List<String>> moviesActorMap = new HashMap<String,List<String>>();	
	public MovieWithActorFilter() {
		
	}
	public void intializeMovies() {
		moviesGenreMap.put("Scifi",new ArrayList<String>(Arrays.asList("IronMan","Anthariksham","Krrish")));
		moviesGenreMap.put("Comedy",new ArrayList<String>(Arrays.asList("Oh baby","3 idiots","Mr.Bean's Holiday","Marakathamani")));
		moviesGenreMap.put("Thriller",new ArrayList<String>(Arrays.asList("Uturn","Abhimanyudu","Don't breathe")));
		moviesLanguageMap.put("Telugu",new ArrayList<String>(Arrays.asList("Anthariksham","Oh baby","Uturn","Abhimanyudu")));
		moviesLanguageMap.put("Hindi",new ArrayList<String>(Arrays.asList("Krrish","3 idiots")));
		moviesLanguageMap.put("English",new ArrayList<String>(Arrays.asList("IronMan","Mr.Bean's Holiday","Don't breathe")));
		moviesActorMap.put("Samantha",new ArrayList<String>(Arrays.asList("Oh baby","Uturn","Abhimanyudu")));
		moviesActorMap.put("Aadhi", new ArrayList<String>(Arrays.asList("Marakathamani","Oh baby")));
	}

	public List<String> filterByActors(String actor) {
		return moviesActorMap.get(actor);
	}

	@Override
	public List<String> filterByGenres(String genre) {
		return moviesGenreMap.get(genre);
	}

	@Override
	public List<String> filterByLanguages(String language) {
		return moviesLanguageMap.get(language);
	}

	@Override
	public List<String> displayGenres() {
		return new ArrayList<String>(moviesGenreMap.keySet());
	}

	@Override
	public List<String> displayLanguages() {
		return new ArrayList<String>(moviesLanguageMap.keySet());
	}
} 