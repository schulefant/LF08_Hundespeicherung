package hund;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class MainHundetest {

	public static void main(String[] args) {
		List<Hund> dogs = new ArrayList<>();
//		dogs.add(new Hund("Bob", 60, 20, "Promenadenmischung"));
//		dogs.add(new Hund("Chia", 80, 40.8, "Collie"));
////		Hund bob = 	laden();
//		for (Hund h : dogs)
//			h.ausgabe();
//
//		speichern(dogs);
		dogs = laden();

		for (Hund h : dogs)
			h.ausgabe();

	}

	public static void speichern(List<Hund> dogs) {

		try (OutputStream os = new FileOutputStream("hunde.data");
				ObjectOutputStream oos = new ObjectOutputStream(os)) {
//			for (Hund h : dogs)
				oos.writeObject(dogs);
			oos.flush();
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static List<Hund> laden() {

		try (InputStream is = new FileInputStream("hunde.data");
				ObjectInputStream ois = new ObjectInputStream(is)) {

				return (List<Hund>) ois.readObject();

		}
		catch (FileNotFoundException | ClassNotFoundException e) {

		}
		catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return null;
	}

}
