package chapter.three.search;

import chapter.three.object.State;

/**
 * 
 * Interface that helps us use a single identifier to 
 * call different classes
 * 
 * @author Jeffrey B Cuadros
 * @version 1.0
 * @since 2017/03/17
 *
 */
public interface Search {
	
	/**
	 * @return State The Goal state that we are looking for
	 */
	public State findGoalState();

	

}
