package chapter.three.search;

import java.util.ArrayList;
import java.util.List;

import chapter.three.object.Cannibal;
import chapter.three.object.Person;
import chapter.three.object.Rules;
import chapter.three.object.State;
import chapter.three.object.Tree;

public class DepthFirst implements Search{

	private State initialState;
	private State goal;
	private Tree<State> tree;
	
	
	
	public DepthFirst(){
		initialState = new State();
	}
	
	public DepthFirst(Tree<State> tree, State goal){
		this.initialState = new State();
		this.tree = tree;
		this.goal = goal;
		
	}
	
	
	public DepthFirst(State initialState){
		this.initialState = initialState;
	}
	
	public State findGoalState(){
		State head = tree.getHead();
		List<State> temp = allPossibleMoves(head);
		
		for(State s : temp){
			if((new Rules(s).isItExpandable())){
				
				tree.addLeaf(head, s);
				
			}
		}
		
		
//		while(current.equals(goal)){
//			
//		}
		
		return null;
	}
	
	
	
	
	
	public List<State> allPossibleMoves(State current) {

		List<State> moves = new ArrayList<State>();
		
		List<Person> lstCannibal = new ArrayList<Person>();
		List<Person> lstMissionary = new ArrayList<Person>();
		

		if (current.getBoat().isRight()) {
			// one person
			//List broken down into two list
			//one list for cannibal, the other for missionaries
			
			for(Person p : current.getRightSide()){
				if (p instanceof Cannibal) {
					lstCannibal.add(p);
				} else {
					lstMissionary.add(p);
				}
			}
			
			List<Person> nRL;
			List<Person> nLL;
			State s;

			
			if(!lstCannibal.isEmpty()){
				nRL = new ArrayList<Person>(current.getRightSide());
				nLL = new ArrayList<Person>(current.getLeftSide());
				
				nRL.remove(lstCannibal.get(0));
				nLL.add(lstCannibal.get(0));
				
				s = new State(nRL, nLL);
				s.getBoat().setLeft(true);
				s.getBoat().setRight(false);
				
				moves.add(s);
				
			}
			
			if(!lstMissionary.isEmpty()){
				nRL = new ArrayList<Person>(current.getRightSide());
				nLL = new ArrayList<Person>(current.getLeftSide());
				
				nRL.remove(lstMissionary.get(0));
				nLL.add(lstMissionary.get(0));
				
				s = new State(nRL, nLL);
				
				s.getBoat().setLeft(true);
				s.getBoat().setRight(false);
				
				moves.add(s);
			}
			
			if(!lstMissionary.isEmpty() && !lstCannibal.isEmpty()){
				nRL = new ArrayList<Person>(current.getRightSide());
				nLL = new ArrayList<Person>(current.getLeftSide());
				
				nRL.remove(lstCannibal.get(0));
				nLL.add(lstCannibal.get(0));
				nRL.remove(lstMissionary.get(0));
				nLL.add(lstMissionary.get(0));
				
				s = new State(nRL, nLL);
				
				s.getBoat().setLeft(true);
				s.getBoat().setRight(false);
				
				moves.add(s);
				
			}
			
			if(lstMissionary.size()>1){
				nRL = new ArrayList<Person>(current.getRightSide());
				nLL = new ArrayList<Person>(current.getLeftSide());
				
				nRL.remove(lstMissionary.get(0));
				nLL.add(lstMissionary.get(0));
				nRL.remove(lstMissionary.get(1));
				nLL.add(lstMissionary.get(1));
				
				s = new State(nRL, nLL);
				
				s.getBoat().setLeft(true);
				s.getBoat().setRight(false);
				
				moves.add(s);
			}
			if(lstCannibal.size()>1){
				nRL = new ArrayList<Person>(current.getRightSide());
				nLL = new ArrayList<Person>(current.getLeftSide());
				
				nRL.remove(lstCannibal.get(0));
				nLL.add(lstCannibal.get(0));
				nRL.remove(lstCannibal.get(1));
				nLL.add(lstCannibal.get(1));
				
				s = new State(nRL, nLL);
				
				s.getBoat().setLeft(true);
				s.getBoat().setRight(false);
				
				moves.add(s);
			}
			
			

		} else {
			
			
			for(Person p : current.getLeftSide()){
				if (p instanceof Cannibal) {
					lstCannibal.add(p);
				} else {
					lstMissionary.add(p);
				}
			}
			
			List<Person> nRL;
			List<Person> nLL;
			State s;

			
			if(!lstCannibal.isEmpty()){
				nRL = new ArrayList<Person>(current.getRightSide());
				nLL = new ArrayList<Person>(current.getLeftSide());
				
				nRL.add(lstCannibal.get(0));
				nLL.remove(lstCannibal.get(0));
				
				s = new State(nRL, nLL);
				s.getBoat().setLeft(false);
				s.getBoat().setRight(true);
				
				moves.add(s);
				
			}
			
			if(!lstMissionary.isEmpty()){
				nRL = new ArrayList<Person>(current.getRightSide());
				nLL = new ArrayList<Person>(current.getLeftSide());
				
				nRL.add(lstCannibal.get(0));
				nLL.remove(lstCannibal.get(0));
				
				s = new State(nRL, nLL);
				
				s.getBoat().setLeft(false);
				s.getBoat().setRight(true);
				
				moves.add(s);
			}
			
			if(!lstMissionary.isEmpty() && !lstCannibal.isEmpty()){
				nRL = new ArrayList<Person>(current.getRightSide());
				nLL = new ArrayList<Person>(current.getLeftSide());
				
				nRL.add(lstCannibal.get(0));
				nLL.remove(lstCannibal.get(0));
				nRL.add(lstCannibal.get(0));
				nLL.remove(lstCannibal.get(0));
				
				s = new State(nRL, nLL);
				
				s.getBoat().setLeft(false);
				s.getBoat().setRight(true);
				
				moves.add(s);
				
			}
			
			if(lstMissionary.size()>1){
				nRL = new ArrayList<Person>(current.getRightSide());
				nLL = new ArrayList<Person>(current.getLeftSide());
				
				nRL.add(lstMissionary.get(0));
				nLL.remove(lstMissionary.get(0));
				nRL.add(lstMissionary.get(1));
				nLL.remove(lstMissionary.get(1));
				
				s = new State(nRL, nLL);
				
				s.getBoat().setLeft(false);
				s.getBoat().setRight(true);
				
				moves.add(s);
			}
			if(lstCannibal.size()>1){
				nRL = new ArrayList<Person>(current.getRightSide());
				nLL = new ArrayList<Person>(current.getLeftSide());
				
				nRL.add(lstCannibal.get(0));
				nLL.remove(lstCannibal.get(0));
				nRL.add(lstCannibal.get(1));
				nLL.remove(lstCannibal.get(1));
				
				s = new State(nRL, nLL);
				
				s.getBoat().setLeft(false);
				s.getBoat().setRight(true);
				
				moves.add(s);
			}
			
			

		}

		return moves;

	}

	public State getInitialState() {
		return initialState;
	}

	public void setInitialState(State initialState) {
		this.initialState = initialState;
	}

	public State getGoal() {
		return goal;
	}

	public void setGoal(State goal) {
		this.goal = goal;
	}

	public Tree<State> getTree() {
		return tree;
	}

	public void setTree(Tree<State> tree) {
		this.tree = tree;
	}
	
	
}
