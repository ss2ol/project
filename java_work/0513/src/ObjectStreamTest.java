import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectStreamTest {

	public static void main(String[] args) {
		
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		try {
			fis = new FileInputStream("person.ser");
			ois = new ObjectInputStream(fis);
			Person p = (Person)ois.readObject();
			System.out.println(p);
		} catch (IOException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e2){
			e2.printStackTrace();
		}finally {
			try {
				if(ois != null)ois.close();
			} catch (IOException e) {
				
			}
		}
		
		
		
//		FileOutputStream fos = null;
//		ObjectOutputStream oos =null;
//		try {
//			fos = new FileOutputStream("person.ser");
//			oos = new ObjectOutputStream(fos);
//			oos.writeObject(new Person(10,"heo"));
//		} catch (IOException e) {
//			e.printStackTrace();
//		}finally {
//			try {
//				if(oos != null) oos.close();
//			} catch (IOException e) {
//				
//			}
//		}
	}

}
