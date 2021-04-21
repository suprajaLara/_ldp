package javaAssignment.Movies;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javaAssignment.OTT.OttDisplay;
import javaAssignment.OTT.OttFilterGenres;
import javaAssignment.OTT.OttFilterLanguages;

public class MoviesWithoutActorFilter implements OttDisplay, OttFilterGenres, OttFilterLanguages {
	HashMap<String,List<String>> moviesGenreMap = new HashMap<String,List<String>>();
	HashMap<String,List<String>> moviesLanguageMap = new HashMap<String,List<String>>();
	public MoviesWithoutActorFilter() {
		
	}
	
	public void intializeMovies() {
		moviesGenreMap.put("Scifi",new ArrayList<String>(Arrays.asList("IronMan","Anthariksham","Krrish")));
		moviesGenreMap.put("Comedy",new ArrayList<String>(Arrays.asList("Oh baby","3 idiots","Mr.Bean's Holiday")));
		moviesLanguageMap.put("Telugu",new ArrayList<String>(Arrays.asList("Anthariksham","Oh baby")));
		moviesLanguageMap.put("Hindi",new ArrayList<String>(Arrays.asList("Krrish","3 idiots")));
		moviesLanguageMap.put("English",new ArrayList<String>(Arrays.asList("IronMan","Mr.Bean's Holiday")));
		
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