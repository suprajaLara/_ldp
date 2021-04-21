package javaAssignment;
import java.util.ArrayList;

class Rating{
	int highestRate,avgRate;
	public Rating() {}
	public Rating(int highestRate,int avgRate){
		this.highestRate=highestRate;
		this.avgRate=avgRate;
	}
}

class EnglishWebSeries extends WebSeries{
	public ArrayList<String> genresList =  new ArrayList<String>();  
	Rating rating = new Rating(); 
	public EnglishWebSeries(Rating rating) {
		initializeGenres();   
		this.rating=rating;
	}
	@Override
	public void initializeGenres() {
		super.initializeGenres();
		System.out.println("initializing genres of english webseries..!");
	}
	@Override
	public ArrayList<String> getGenres() {
		setGenres();
		return genresList;
	}
	public void setGenres() {
		genresList.add("Thriller");
		genresList.add("Action");
	}
}

class KoreanMovies extends Movies{
	public ArrayList<String> genresList =  new ArrayList<String>();
	public KoreanMovies() {
		super.intializeGenres();
	}
	@Override
	public ArrayList<String> getGenres() { 
		setGenres();
		return genresList;
	}
	
	public void setGenres() {
		genresList.add("Thriller");
		genresList.add("Action");
	}
	
}

public class NetflixUser{
	public static void main(String args[]) {
		Rating rating = new Rating(10,7);
		EnglishWebSeries englishWebSeries = new EnglishWebSeries(rating);
		System.out.println("Hi, I am user of : "+Ott.ottName);
		System.out.println("Total count of webseries is : "+englishWebSeries.totalCount());
		System.out.println("Total count of Thriller in webseries is : "+englishWebSeries.totalCount("Thriller"));
		System.out.println("List of Genres for english webseries is: "+englishWebSeries.getGenres());
		System.out.println("highest and avg rating of english webseries are :"+rating.highestRate+" "+rating.avgRate);
	}
}
