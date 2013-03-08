package mong.testroom1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputBufferTest {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		String fileName = "";
		String outputPath = "";
		File f = new File(fileName);
		
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		try {
			
			fis = new FileInputStream(f);
			fos = new FileOutputStream(outputPath);
		
			byte[] buffer = new byte[1024];
			int readcount = 0;
		
			while((readcount=fis.read(buffer)) != -1){
				
				fos.write(buffer, 0, readcount);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			fos.close();
			fis.close();
		}
		
	}

}



