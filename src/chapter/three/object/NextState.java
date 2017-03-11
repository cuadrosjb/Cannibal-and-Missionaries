package chapter.three.object;

public class NextState {

	private State current;

	public NextState() {

	}

	public NextState(State current) {
		this.current = current;
	}
	
	public State createNewState(Person p1, Person p2, Boat going){
		
		if(going.isRight()){
			current.getLeftSide().add(p1);
			if(p2 != null)current.getLeftSide().add(p2);
			current.getRightSide().remove(p1);
			if(p2 != null)current.getRightSide().remove(p2);
		}else{
			current.getRightSide().add(p1);
			if(p2 != null)current.getRightSide().add(p2);
			current.getLeftSide().remove(p1);
			if(p2 != null)current.getLeftSide().remove(p2);
		}
		
		if(new Rules(current.getRightSide(), current.getLeftSide()).isItExpandable()){
			return current;
		}else{
			return null;
		}
	}
	

}
