package ultravision.user;
import ultravision.interfaces.MembershipCardInterface;

public class MembershipCard implements MembershipCardInterface{

	   private int points;
	   private boolean freeRentAllowed;
	   
	   public void addPoints(int points){
			this.points += points;
			setRentAllowed();
	   }
	   
	   public boolean availFreeRent(){
			if(this.isfreeRentAllowed()){
				this.points -= 100;
				setRentAllowed();
				return true;
			} else {
				return false;
			}
	   }
	   
	   private void setRentAllowed(){
			if (this.points >= 100){
				this.freeRentAllowed = true;
			} else {
				this.freeRentAllowed = false;
			}
	   }
	   
	   public int getPoints() {
			return  points;
       }
	   
	   public boolean isfreeRentAllowed(){
			return freeRentAllowed;
	   
	   }
	   
	   
}