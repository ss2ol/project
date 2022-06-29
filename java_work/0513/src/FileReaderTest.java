
import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest {

	public static void main(String[] args) {
		FileReader fis = null;

		
		try {
			fis = new FileReader("news.txt");
			int data;
			while((data = fis.read()) != -1) {
				System.out.print((char)data);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(fis != null) fis.close();
			} catch (IOException e2) {
				
			}
		}
	}

}
