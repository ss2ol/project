import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesTest {

	public static void main(String[] args) {
		Properties props = new Properties();
		props.setProperty("age", "20");
		props.setProperty("name", "홍길동");
		props.setProperty("height", "180.4");
		props.setProperty("weight", "70");
		
		FileOutputStream out = null;
		
		try {
			out = new FileOutputStream("info.txt");
			props.store(out, "person info");
		} catch (IOException e) {
			
		}finally {
			try {
				if(out != null)out.close();
			}catch (IOException e) {
				
			}
		}
		
	}

}
