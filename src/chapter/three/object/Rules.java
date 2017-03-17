package chapter.three.object;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that validates every possible move 
 * by from state to state 
 * 
 * @author Jeffrey B Cuadros
 *
 */
public class Rules {

	private List<Person> rightSide;
	private List<Person> leftSide;
	
	private State state;

	public Rules() {
		
		rightSide = new ArrayList<Person>();
		leftSide = new ArrayList<Person>();

	}
	
	public Rules(State state){
		this.rightSide = state.getRightSide();
		this.leftSide = state.getLeftSide();
	}
	

	public Rules(List<Person> rightSide, List<Person> leftSide) {
		this.rightSide = rightSide;
		this.leftSide = leftSide;
	}


	/**
	 * @return true If the new move complies with the set of rules 
	 */
	public boolean isItExpandable() {

		int numberOfCann = 0;
		int numberOfMiss = 0;

		for (Person p : rightSide) {
			if (p instanceof Cannibal)
				numberOfCann++;
			else
				numberOfMiss++;
		}

		if (numberOfCann > numberOfMiss && numberOfMiss > 0)
			return false;

		numberOfCann = 0;
		numberOfMiss = 0;

		for (Person p : leftSide) {
			if (p instanceof Cannibal)
				numberOfCann++;
			else
				numberOfMiss++;
		}

		if (numberOfCann > numberOfMiss && numberOfMiss > 0)
			return false;
		else
			return true;

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

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

}
