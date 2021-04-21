package javaAssignment;
import java.util.Scanner;

import javaAssignment.CustomMovies.KidsMovies;
import javaAssignment.CustomMovies.SamanthaMovies;
import javaAssignment.OTT.OttDisplay;
import javaAssignment.Rating.UserImdbRating;

public class NetflixUser{
	public static void main(String args[]) {
		SamanthaMovies samMovies = new SamanthaMovies();
		KidsMovies kidsmovies = new KidsMovies();
		System.out.println("Hi, I am user of : "+OttDisplay.ottName);
		System.out.println("Samantha's movies filtered by thriller genre: "+samMovies.filterByGenres("Thriller"));
		System.out.println("Languages of Samantha's movies: "+samMovies.displayLanguages());
		System.out.println("Kid's movies filtered by actor, Rowan Atkinson:"+kidsmovies.filterByActors("Rowan Atkinson"));
		System.out.println("Genres of Kid's movies: "+kidsmovies.displayGenres());
		UserImdbRating imdbrate = new UserImdbRating();
		System.out.println("enter rating of Mr. Bean: ");
		Scanner s = new Scanner(System.in);
		imdbrate.currentuserRate=s.nextDouble();
		s.close();
		kidsmovies.takeRating("Mr. Bean", imdbrate);
	}
}
