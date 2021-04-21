package javaAssignment.Rating;

public class ImdbRating implements Rating{
	public double avgRate=7.2,maxRate=9.9;
	
	@Override
	public void displayAvgRating() {
		System.out.println("average imdb rating is : "+avgRate);
	}

	@Override
	public void displayMaxRating() {
		System.out.println("maximum imdb rating is : "+maxRate);
	}

}
