package chapter.three.object;

import java.util.ArrayList;
import java.util.List;

/**
 * State class holds all the details about the current state 
 * of the environment
 * 
 * Note:
 * After been stuck for few days, noticed that my Tree Class 
 * was not working as it should, instead I tried the Pointer to the 
 * parent. Idea from: https://github.com/marianafranco/missionaries-and-cannibals
 * 
 * 
 * @author Jeffrey B Cuadros
 * @version 1.0
 * @since 2017/03/17
 *
 */
public class State {
	
	private List<Person> rightSide;
	private List<Person> leftSide;
	
	private Boat boat;
	
	private State parent;
	
	/**
	 * Empty-Constructor that sets up the initial state
	 */
	public State(){
		leftSide = new ArrayList<Person>();
		leftSide.add(new Cannibal());
		leftSide.add(new Cannibal());
		leftSide.add(new Cannibal());
		leftSide.add(new Missionary());
		leftSide.add(new Missionary());
		leftSide.add(new Missionary());
		
		boat = new Boat();
		
		rightSide = new ArrayList<Person>();
		
		
	}
	
	/**
	 * Constructor that sets up the state from the parameters given
	 * 
	 * @param rightSide List of Objects inside the Right list
	 * @param leftSide List of Objects inside the Left list
	 */
	public State(List<Person> rightSide, List<Person> leftSide) {
		this.rightSide = rightSide;
		this.leftSide = leftSide;
		boat = new Boat();
	}
	
	/**
	 * Constructor that sets up the state from the parameters given
	 * 
	 * @param rightSide List of Objects inside the Right list
	 * @param leftSide List of Objects inside the Left list
	 * @param boat Set the Boat to the assign location
	 */
	public State(List<Person> rightSide, List<Person> leftSide, Boat boat) {
		this.rightSide = rightSide;
		this.leftSide = leftSide;
		this.boat = boat;
	}
	
	
	/**
	 * @param list
	 * @return number of missionaries
	 */
	public int getNumberOfMissionaries(List<Person> list){
		int counter = 0;
		for(Person p : list){
			if(p instanceof Missionary){
				counter++;
			}
		}
		
		return counter;
	}
	/**
	 * @param list
	 * @return number of cannibals
	 */
	public int getNumberOfCannibals(List<Person> list){
		int counter = 0;
		for(Person p : list){
			if(p instanceof Cannibal){
				counter++;
			}
		}
		
		return counter;
	}
	
	/**
	 * @return Boat location
	 */
	public String getBoatLocation(){
		if(boat.isRight() == true && boat.isLeft() == false){
			return "Right";
		}else{
			return "Left";
		}
	}
	
	public List<Person> getRightSide() {
		return rightSide;
	}

	public void setRightSide(List<Person> rightSide) {
		this.rightSide = rightSide;
	}

	public List<Person> getLeftSide() {
		return leftSide;
	}

	public void setLeftSide(List<Person> leftSide) {
		this.leftSide = leftSide;
	}

	public Boat getBoat() {
		return boat;
	}

	public void setBoat(Boat boat) {
		this.boat = boat;
	}
	
	

	public State getParent() {
		return parent;
	}

	public void setParent(State parent) {
		this.parent = parent;
	}

	/**
	 * main function to test functionality
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		State s = new State();
		
		
		
		List<Person> left = new ArrayList<Person>();
		
		List<Person> right = new ArrayList<Person>();
		right.add(new Missionary());
		right.add(new Missionary());
		right.add(new Cannibal());
		right.add(new Cannibal());
		right.add(new Cannibal());
		
		right.add(new Missionary());
		
		s.setRightSide(right);
		s.getBoat().setRight(true);
		s.getBoat().setLeft(false);
		
		s.setLeftSide(left);
		
		State goal = new State(right, left);
		
		goal.getBoat().setRight(true);
		goal.getBoat().setLeft(false);
		
		System.out.println(s.equals(goal));
		

	}

	/**
	 * Function to test if the two states are equal
	 * @param s
	 * @return true if the two states are the same
	 */
	public boolean equals(State s) {
		if(s.getBoat().isLeft() && this.getBoat().isLeft()
				|| s.getBoat().isRight() && this.getBoat().isRight()){
			if(s.getLeftSide().size() == this.getLeftSide().size() 
					&& s.getRightSide().size() == this.getRightSide().size()){
				int numCann = 0;
				int numMiss = 0;
				
				int numCannT = 0;
				int numMissT = 0;
				
				for(Person p : s.getLeftSide()){
					if(p instanceof Cannibal){
						numCann++;
					}else{
						numMiss++;
					}
				}
				
				for(Person p : getLeftSide()){
					if(p instanceof Cannibal){
						numCannT++;
					}else{
						numMissT++;
					}
				}
				
				
				int numCannL = 0;
				int numMissL = 0;
				
				int numCannTL = 0;
				int numMissTL = 0;
				
				for(Person p : s.getRightSide()){
					if(p instanceof Cannibal){
						numCannL++;
					}else{
						numMissL++;
					}
				}
				
				for(Person p : getRightSide()){
					if(p instanceof Cannibal){
						numCannTL++;
					}else{
						numMissTL++;
					}
				}
				
				
				if(numCann == numCannT && numMissT==numMiss 
						&& numCannL == numCannTL && numMissTL==numMissL){
					return true;
				}else{
					return false;
				}
				
			}else{
				return false;
			}
		}else{
			return false;
		}
	}

	@Override
	public String toString() {
		return "State: [Left contains " + getNumberOfCannibals(getLeftSide()) + " Cannibals and " + getNumberOfMissionaries(getLeftSide()) + " Missionaries]"  
	+  " [Right contains " + getNumberOfCannibals(getRightSide()) + " Cannibals and " + getNumberOfMissionaries(getRightSide()) + " Missionaries] [Boat is located: " + getBoatLocation()+"]";
	}

}
