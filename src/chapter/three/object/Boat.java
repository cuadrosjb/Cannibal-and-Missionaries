package chapter.three.object;

public class Boat {
	
	private boolean right;
	private boolean left;
	
	public Boat(){
		left = true;
		right = false;
	}

	public boolean isRight() {
		return right;
	}

	public void setRight(boolean right) {
		this.right = right;
	}

	public boolean isLeft() {
		return left;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}

}
