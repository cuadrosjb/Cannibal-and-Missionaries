package chapter.three.object;

import java.util.ArrayList;
import java.util.List;

public class Rules {

	List<Person> rightSide;
	List<Person> leftSide;

	public Rules() {
		
		rightSide = new ArrayList<Person>();
		leftSide = new ArrayList<Person>();

	}

	public Rules(List<Person> rightSide, List<Person> leftSide) {
		this.rightSide = rightSide;
		this.leftSide = leftSide;
	}


	public boolean isItExpandable() {

		int numberOfCann = 0;
		int numberOfMiss = 0;

		for (Person p : rightSide) {
			if (p instanceof Cannibal)
				numberOfCann++;
			else
				numberOfMiss++;
		}

		if (numberOfCann > numberOfMiss)
			return false;

		numberOfCann = 0;
		numberOfMiss = 0;

		for (Person p : leftSide) {
			if (p instanceof Cannibal)
				numberOfCann++;
			else
				numberOfMiss++;
		}

		if (numberOfCann > numberOfMiss)
			return false;
		else
			return true;

	}

}
