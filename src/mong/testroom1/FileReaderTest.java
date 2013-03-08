package mong.testroom1;

import java.io.BufferedReader;
import java.io.FileReader;

public class FileReaderTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String fileName = "/Users/acacia99/Documents/sy.park/ip info.txt";
		try {
			BufferedReader br = new BufferedReader(
					new FileReader(fileName));
			String str;
			while((str = br.readLine()) != null){
				if(str.indexOf(",") > -1){
					String [] innerStr = str.split(",");
				}
				System.out.println(str);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}