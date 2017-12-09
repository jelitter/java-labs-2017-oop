package lab05;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileStorage {

	public static void storeObject(Object o, String filename) {
		try {
			FileOutputStream fileOut = new FileOutputStream(filename);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(o);
			out.close();
			fileOut.close();
			System.out.println("  Data saved in: "+filename);
		} catch (IOException i) {
			storeObject(i,"IOException.ser");
		}
	}

	public static Object readObject(String filename) {
		Object obj = null;
		try {
		
			FileInputStream fileIn = new FileInputStream(filename);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			obj = in.readObject();
			in.close();
			fileIn.close();
		} catch (FileNotFoundException a) {
			storeObject(a,"FileNotFound.ser");
		} catch (IOException i) {
			storeObject(i,"IOException.ser");
		} catch (ClassNotFoundException c) {
			storeObject(c,"ClassNotFoundException.ser");
		}
		return obj;
	}
}
