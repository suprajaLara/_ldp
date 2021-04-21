package javaAssignment.Rating;

public class UserImdbRating implements UserRating{

	public double currentuserRate;
	@Override
	public void displayUserRating() {
		System.out.println("current user imdb rating is : "+currentuserRate);
	}

}
