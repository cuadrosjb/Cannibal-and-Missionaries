package chapter.three.object;

import java.util.ArrayList;
import java.util.List;

import chapter.three.search.Search;
import chapter.three.search.DepthFirst;

public class Environment {
	
	State goalState;
	
	public Environment(){
		setGoalState();
	}
	
	public void findGoal(){
		Search depthFirst = new DepthFirst(goalState);
		System.out.println(depthFirst.findGoalState().toString());
	}
	
	
	public void setGoalState(){
		List<Person> left = new ArrayList<Person>();
		
		List<Person> right = new ArrayList<Person>();
		right.add(new Cannibal());
		right.add(new Cannibal());
		right.add(new Cannibal());
		right.add(new Missionary());
		right.add(new Missionary());
		right.add(new Missionary());
		
		goalState = new State(right, left);
		goalState.getBoat().setRight(true);
		goalState.getBoat().setLeft(false);
	}
	
	public static void main(String[] args){
		
		Environment env = new Environment();
		env.findGoal();
		
	}
	

}
