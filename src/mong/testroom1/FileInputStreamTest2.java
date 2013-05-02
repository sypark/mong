package mong.testroom1;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileInputStreamTest2 {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		//String fileNm = "/Users/acacia99/works/sy.park/search/eshop2_13030701.log";
		String filePath = "/Users/acacia99/works/sy.park/search/";
		FileInputStream fis = null;
		DataInputStream in = null;
		BufferedReader br = null;
		int lseqSum = 0;
		int gsidSum = 0;
		int mediaSum = 0;
		int cntSum = 0;
		int viewCnt386749Sum = 0;
		int viewCnt386750Sum = 0;
		
		File[] listFile = new File(filePath).listFiles(); 
		
		try {
			for (int i = 0; i < listFile.length; i++) {
				int lseqCnt = 0;
				int gsidCnt = 0;
				int mediaCnt = 0;
				int cnt = 0;
				int viewCnt386749 = 0;
				int viewCnt386750 = 0;
				if(listFile[i].isFile() && listFile[i].getName().indexOf(".log") > -1){
					
				
					fis = new FileInputStream(filePath+listFile[i].getName());
					in = new DataInputStream(fis);
					br = new BufferedReader(new InputStreamReader(in));
					
					String strLine;
					cnt = 0;
					
					String searchStr = "/search/main.gs?tq=";
					String lseq386749 = "/dummylog.jsp?lseq=386749";
					String lseq386750 = "/dummylog.jsp?lseq=386750";
					String prdStr = "/prd/prd.gs?prdid={*}&ab=*";
					
					while((strLine=br.readLine()) != null){
						if(cnt > 2)
							break;
						
						String [] strs = strLine.split(" ");
						
						for (int j = 0; j < strs.length; j++) {
							System.out.println("["+j+"]strs:" + strs[j]);
						}
						
						cnt++;
						
					}
					
				}
				
			}
				
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			br.close();
			in.close();
			fis.close();
		}
		
	}

}



