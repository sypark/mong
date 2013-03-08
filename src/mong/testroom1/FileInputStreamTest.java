package mong.testroom1;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileInputStreamTest {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		String filePath = "/Users/acacia99/Documents/sy.park/ip info.txt";
		FileInputStream fis = null;
		DataInputStream in = null;
		BufferedReader br = null;
		
		try {
			fis = new FileInputStream(filePath);
			in = new DataInputStream(fis);
			br = new BufferedReader(new InputStreamReader(in));
			
			String strLine;
			while((strLine=br.readLine()) != null){
				System.out.println(strLine);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			br.close();
			in.close();
			fis.close();
		}
	}

}

