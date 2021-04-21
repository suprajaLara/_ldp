package javaAssignment.Rating;

public class MetaCriticRating implements Rating{
	int avgRate=69,maxRate=92;
	
	@Override
	public void displayAvgRating() {
		System.out.println("The meta critic average rating is: "+avgRate);
	}

	@Override
	public void displayMaxRating() {
		System.out.println("The meta critic maximum rating is: "+maxRate);
	}

}
