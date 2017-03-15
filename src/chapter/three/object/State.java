package chapter.three.object;

import java.util.ArrayList;
import java.util.List;

public class State {
	
	private List<Person> rightSide;
	private List<Person> leftSide;
	
	private Boat boat;
	
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
	
	public State(List<Person> rightSide, List<Person> leftSide) {
		this.rightSide = rightSide;
		this.leftSide = leftSide;
	}
	
	public void print(){
		System.out.println("Right side");
		for(Person p : rightSide){
			p.speak();
		}
		
		System.out.println("Left side");
		for(Person p : leftSide){
			p.speak();
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

	public static void main(String[] args) {
		
		State s = new State();
		s.print();
		

	}

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
				
				if(numCann == numCannT && numMissT==numMiss){
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

}
