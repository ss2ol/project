import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class URLTest {

	public static void main(String[] args) {
		URL url = null;
		String address = "https://t1.daumcdn.net/daumtop_chanel/op/20200723055344399.png";
		FileOutputStream fos = null;
		InputStream is = null;
		try {
			url = new URL(address);
			fos = new FileOutputStream("daum.png");
			is = url.openStream();
			byte[] buff = new byte[1024];
			int len;
			while((len = is.read(buff))>0) {
				fos.write(buff,0,len);
			}
		} catch (IOException e) {
			
		}finally {
			try {
				if(fos != null) fos.close();
			} catch (Exception e2) {
				
			}
		}
	}

}
