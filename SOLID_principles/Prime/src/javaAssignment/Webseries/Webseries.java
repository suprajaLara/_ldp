package javaAssignment.Webseries;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javaAssignment.OTT.OttDisplay;
import javaAssignment.OTT.OttFilterGenres;
import javaAssignment.OTT.OttFilterLanguages;

public class Webseries implements OttDisplay, OttFilterGenres, OttFilterLanguages{

	HashMap<String,ArrayList<ArrayList<String>>> webseriesGenreMap = new HashMap<String,ArrayList<ArrayList<String>>>();
	HashMap<String,ArrayList<ArrayList<String>>>  webseriesLanguageMap = new HashMap<String,ArrayList<ArrayList<String>>>();
	public Webseries() {
		this.intializeWebseries();
	}
	
	public void intializeWebseries() {
		webseriesGenreMap.put("Scifi",new ArrayList<ArrayList<String>>(Arrays.asList(
				new ArrayList<String>(Arrays.asList("Lost in space","20")),
				new ArrayList<String>(Arrays.asList("Dark","26")),
				new ArrayList<String>(Arrays.asList("Titans","24"))
				)));
		webseriesGenreMap.put("Thriller",new ArrayList<ArrayList<String>>(Arrays.asList(
				new ArrayList<String>(Arrays.asList("The Family Man","10")),
				new ArrayList<String>(Arrays.asList("Mindhunter","19"))
				)));
		webseriesLanguageMap.put("Hindi",new ArrayList<ArrayList<String>>(Arrays.asList(
				new ArrayList<String>(Arrays.asList("The Family Man","10")),
				new ArrayList<String>(Arrays.asList("Titans","24"))
				)));
		webseriesLanguageMap.put("English",new ArrayList<ArrayList<String>>(Arrays.asList(
				new ArrayList<String>(Arrays.asList("Lost in space","20")),
				new ArrayList<String>(Arrays.asList("Dark","26")),
				new ArrayList<String>(Arrays.asList("Mindhunter","19"))
				)));
	}
	
	@Override
	public List<String> filterByGenres(String genre) {
		List<String> list = new ArrayList<String> ();
		ArrayList<ArrayList<String>> arrlist = webseriesGenreMap.get(genre);
		for(int index=0;index<arrlist.size();index++) {
			list.add(arrlist.get(index).get(0));
		}
		return list;
	}

	@Override
	public List<String> filterByLanguages(String language) {
		List<String> list = new ArrayList<String> ();
		ArrayList<ArrayList<String>> arrlist = webseriesLanguageMap.get(language);
		for(int index=0;index<arrlist.size();index++) {
			list.add(arrlist.get(index).get(0));
		}
		return list;
	}

	@Override
	public List<String> displayGenres() {
		return new ArrayList<String>(webseriesGenreMap.keySet());
	}

	@Override
	public List<String> displayLanguages() {
		return new ArrayList<String>(webseriesLanguageMap.keySet());
	}
	
	

}
