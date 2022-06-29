import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataStreamTest {
	public static void drawWrite() {

		int age = 20;
		String name = "heo";
		double weight = 50;
		
		FileOutputStream fos = null;
		DataOutputStream dos = null;

		try {
			fos = new FileOutputStream("info.dat");
			dos = new DataOutputStream(fos);
			dos.writeInt(age);
			dos.writeUTF(name);
			dos.writeDouble(weight);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (dos != null)
					dos.close();
			} catch (IOException e2) {

			}
		}
	}

	public static void main(String[] args) {
		drawWrite();
		
		FileInputStream fis = null;
		DataInputStream dis = null;
		
		try {
			fis = new FileInputStream("info.dat");
			dis = new DataInputStream(fis);
			int age = dis.readInt();
			String name = dis.readUTF();
			double weight = dis.readDouble();
			System.out.println(age);
			System.out.println(name);
			System.out.println(weight);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (dis != null)
					dis.close();
			} catch (IOException e2) {

			}
		}
	}

}
