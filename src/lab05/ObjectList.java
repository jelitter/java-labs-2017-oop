package lab05;

import java.util.ArrayList;
import java.io.Serializable;

public class ObjectList implements Serializable {

	private static final long serialVersionUID = 1L;
	private int size;
	private ArrayList<Object> list;
	

	public ObjectList(int size) {
		this.size = size;
		this.list = new ArrayList<Object>();
	}

	public String add(Object object) {
		if (!this.isFull()) {
			this.list.add(object);
			return object.toString() + " added to list:\n" + this + "\n";
		}
		return "List is full, item was not added.";
	}

	public Boolean isFull() { return this.list.size() == this.size;	}
	public Boolean isEmpty() { return this.list.size() == 0; }
	public ArrayList<Object> getList() { return this.list; }
	public int getTotal() { return this.list.size(); }
	public Object getObject(int i) { return this.list.get(i); }

	public void remove(int i) {
		if (!this.isEmpty()) {
			this.list.remove(i);
		}
	}
	
	public void remove(Object o) {
		this.list.remove(o);
	}
	
	public String toString() { return this.list.toString(); }
	public void print() { System.out.println(this);	}

}
