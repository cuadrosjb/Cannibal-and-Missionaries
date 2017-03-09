package chapter.three.object;

import java.util.ArrayList;
import java.util.List;

public class Environment {
	
	Tree<State> tree;
	State goalState;
	
	public Environment(){
		
		tree = new Tree<State>(new State());
		
		setGoalState();
	}
	
	public void findGoal(){
		
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
	}
	
	public static void main(String[] args){
		
		Environment env = new Environment();
		env.findGoal();
		
	}
	

}
