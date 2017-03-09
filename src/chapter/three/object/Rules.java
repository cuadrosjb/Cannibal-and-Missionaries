package chapter.three.object;

import java.util.List;

public class Rules {

	List<Person> rightSide;
	List<Person> leftSide;

	public Rules() {

	}

	public Rules(List<Person> rightSide, List<Person> leftSide) {
		this.rightSide = rightSide;
		this.leftSide = leftSide;
	}

	public State nextState(State state) {

		return null;
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
