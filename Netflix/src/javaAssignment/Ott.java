package javaAssignment;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public interface Ott{
	static final String ottName = "Netflix";
	public ArrayList<String> getGenres();
	//showList(); displayAds();
}

class genreCount{
	protected HashMap<String,Integer> genreCountMap = new HashMap<String,Integer>();
	protected int totalCount(String genreType){
		return genreCountMap.get(genreType);
	}
	public int totalCount(){
		int count=0;
		for(Entry<String, Integer> m : genreCountMap.entrySet()){
			count+=(int)m.getValue();
		}
		return count;
	}
}

abstract class Movies extends genreCount implements Ott{
	public abstract ArrayList<String> getGenres();
	public void intializeGenres() {
		super.genreCountMap.put("Scifi",5);
		super.genreCountMap.put("Comedy",6); 
		super.genreCountMap.put("Thriller",7);
		
	}
}

abstract class WebSeries extends genreCount implements Ott{
	public abstract ArrayList<String> getGenres();
	protected void initializeGenres(){
		super.genreCountMap.put("Action",6);
		super.genreCountMap.put("Comedy",4); 
		super.genreCountMap.put("Thriller",10);
	}
}