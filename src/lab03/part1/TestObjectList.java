package lab03.part1;

/**
 * Write a description of class TestObjectList here.
 * 
 * @author (Isaac Sanchez) 
 * @version (1.0.0)
 */
public class TestObjectList {
	public ObjectList itsObjectList;

	public static void main(String[] args) {
		ObjectList ol = new ObjectList(3);

		String s = "Im Happy";
		Dog d = new Dog();
		DVD v = new DVD();
		Integer i = 1234;

		System.out.println(ol.add(s));
		System.out.println(ol.add(d));
		System.out.println(ol.add(v));
		System.out.println(ol.add(i));

		ol.remove(0);
		System.out.println(ol.add(i));

		System.out.println("Is the list full? " + ol.isFull());
		System.out.println("Is the list empty? " + ol.isEmpty());

		System.out.println("Total number of objects in the list: " + ol.getTotal());

		Object g = ol.getObject(0);
		((Dog) g).bark();

	}
}
