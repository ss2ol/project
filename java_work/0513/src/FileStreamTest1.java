import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileStreamTest1 {

	public static void main(String[] args) {
		FileOutputStream fos = null;
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null; 
				

		try {
			fis = new FileInputStream("news.txt");
			bis = new BufferedInputStream(fis);
			fos = new FileOutputStream("cpy_news.txt");
			bos = new BufferedOutputStream(fos);

//			int data;
//			while ((data=fis.read()) != -1) {
//				fos.write(data);
//			}

			byte[] buff = new byte[1024];
			int len;
			while ((len = fis.read(buff)) > 0) {
				bos.write(buff, 0, len);
			} 

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bis != null)
					bis.close();
				if (bos != null)
					bos.close();
			} catch (IOException e2) {

			}
		}
	}

}
