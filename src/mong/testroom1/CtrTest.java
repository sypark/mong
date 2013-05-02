package mong.testroom1;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CtrTest {
	
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		if(args.length == 0){
			System.out.println("Argup[0] is must input");
			//return;
		}
		
		
		Thread t = new Thread(){
			public void run(){
				try {
					while (!Thread.interrupted()) {
						Thread.sleep(1000);
						System.out.print(".");
					}
				} catch (InterruptedException e) {
					// TODO: handle exception
				}
			}
		};
		
		t.setDaemon(true);
		t.start();
		
		
		String filePath = "/Users/acacia99/works/sy.park/search/";
		//String filePath = "/wiselog/rawdata/" + args[0] + "/";
		FileInputStream fis = null;
		DataInputStream in = null;
		BufferedReader br = null;
		
		File[] listFile = new File(filePath).listFiles(); 
		
		int searchCnt = 0;
		int lseq386749Cnt = 0;
		int lseq386750Cnt = 0;
		int prdaCnt = 0;
		int prdbCnt = 0;
	
		try {
			for (int i = 0; i < listFile.length; i++) {
				
				if(listFile[i].isFile() && listFile[i].getName().indexOf(".log") > -1){
				
					fis = new FileInputStream(filePath+listFile[i].getName());
					in = new DataInputStream(fis);
					br = new BufferedReader(new InputStreamReader(in));
					
					String strLine;
					int cnt = 0;
					
					while((strLine=br.readLine()) != null){
						if(cnt > 4)
							break;
						
						cnt++;
						
						//strLine = URLDecoder.decode(strLine, "utf-8");
						Pattern p1 = Pattern.compile("(GET|PUT|POST)\\s*(http|https|ftp)://[^\\s^\\.]+(\\.[^\\s^\\.]+)*\\s*HTTP");
						//Pattern p1 = Pattern.compile("GET\\s*(http|https|ftp)://[^\\s^\\.]+(.gsshop.com/search/main.gs)");
						Matcher m1 = p1.matcher(strLine);
						if(m1.find()){
							m1.group();
							searchCnt++;
						}
						Pattern p2 = Pattern.compile("GET\\s*(http|https|ftp)://[^\\s^\\.]+(.gsshop.com/jsp/dummylog.jsp\\?lseq=386749)");
						Matcher m2 = p2.matcher(strLine);
						if(m2.find()){
							
							lseq386749Cnt++;
						}
						Pattern p3 = Pattern.compile("GET\\s*(http|https|ftp)://[^\\s^\\.]+(.gsshop.com/jsp/dummylog.jsp\\?lseq=386750)");
						Matcher m3 = p3.matcher(strLine);
						if(m3.find()){
							
							lseq386750Cnt++;
						}
						Pattern p4 = Pattern.compile("GET\\s*(http|https|ftp)://[^\\s^\\.]+(.gsshop.com/prd/prd.gs\\?prdid=[0-9]+&ab=A)");
						Matcher m4 = p4.matcher(strLine);
						if(m4.find()){
							
							prdaCnt++;
						}
						Pattern p5 = Pattern.compile("GET\\s*(http|https|ftp)://[^\\s^\\.]+(.gsshop.com/prd/prd.gs\\?prdid=[0-9]+&ab=B)");
						Matcher m5 = p5.matcher(strLine);
						if(m5.find()){
							
							prdbCnt++;
						}
							
						//System.out.println(strLine);
						
					}
					
					System.out.println("listFile["+i+"].getName():"+listFile[i].getName());
					/*
					System.out.println("searchCnt:"+searchCnt);
					System.out.println("lseq386749Cnt:"+lseq386749Cnt);
					System.out.println("lseq386750Cnt:"+lseq386750Cnt);
					System.out.println("prdaCnt:"+prdaCnt);
					System.out.println("prdbCnt:"+prdbCnt);
					*/
				}
				
				
			}
				
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			br.close();
			in.close();
			fis.close();
		}
		StringBuffer stb = new StringBuffer()
		.append("======================").append("\n")
		.append("Search PV : " + searchCnt).append("\n")
		.append("======================").append("\n")
		.append("A Case dymmy : " + lseq386749Cnt).append("\n")
		.append("A Case PV : " + prdaCnt).append("\n")
		.append("A Reach Rate : " + (float)(lseq386749Cnt*100/(searchCnt*1.0))).append("\n")
		.append("A CTR : " + (float)(prdaCnt*100/(lseq386749Cnt*1.0))).append("\n")
		.append("A(Real) CTR : " + (float)(prdaCnt*100/(searchCnt*1.0))).append("\n")
		.append("======================").append("\n")
		.append("B Case dymmy : " + lseq386750Cnt).append("\n")
		.append("B Case PV : " + prdbCnt).append("\n")
		.append("B Reach Rate : " + (float)(lseq386750Cnt*100/(searchCnt*1.0))).append("\n")
		.append("B CTR : " + (float)(prdbCnt*100)/(lseq386750Cnt*1.0)).append("\n")
		.append("B(Real) CTR : " + (float)(prdbCnt*100)/(searchCnt*1.0)).append("\n");
		
		System.out.println(stb.toString());
		
		FileWriter writer = null;
		try {
			writer = new FileWriter("/wiselog/rawdata/" + args[0] + ".txt");
			writer.write(stb.toString());
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if(writer != null){
				writer.close();
			}
			t.interrupt();
		}
		
		
		
		
	}

}



