package chapter.three.object;

public class TestTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Tree<String> t = new Tree<String>("Bing");
		
		t.addLeaf("Bing_1");
		t.addLeaf("Bing_2");
		t.addLeaf("Bing_3");
		t.addLeaf("Bing_1", "Bing_1_1");
		t.addLeaf("Bing_3", "Bing_3_1");
		t.addLeaf("Bing__2");
		t.addLeaf("Bing_3", "Bing_3_2");
		
		
		System.out.println(t.toString());
		
		
		
		

	}

}
