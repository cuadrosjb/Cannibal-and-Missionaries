package chapter.three.object;

import java.util.ArrayList;
import java.util.List;

public class State {
	
	List<Person> rightSide;
	List<Person> leftSide;
	
	public State(){
		leftSide = new ArrayList<Person>();
		leftSide.add(new Cannibal());
		leftSide.add(new Cannibal());
		leftSide.add(new Cannibal());
		leftSide.add(new Missionary());
		leftSide.add(new Missionary());
		leftSide.add(new Missionary());
		
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

	public static void main(String[] args) {
		
		State s = new State();
		s.print();
		

	}

}
