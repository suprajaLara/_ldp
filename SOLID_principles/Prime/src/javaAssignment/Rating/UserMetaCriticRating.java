package javaAssignment.Rating;

public class UserMetaCriticRating implements UserRating{
	public int currentuserRate;
	@Override
	public void displayUserRating() {
		System.out.println("current user meta critic rating is : "+currentuserRate);	
	}

}
