package LinkedHashedMap;

public class LHMimplement {
	public static void main(String args[]) {
		System.out.println("Linked List Implementation");
		LHM<Integer,String> obj = new LHM<Integer,String>();
		obj.put(1, "one");
		obj.put(2, "two");
		System.out.println("Initial list");
		obj.display();
		String value = obj.get(1);
		System.out.println("Value of 1: "+value);
		obj.remove(2);
		System.out.println("After deletion");
		obj.display();
		
	}
}
