package mong.testroom1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileReaderTest {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		String fileName = "/Users/acacia99/works/sy.park/search/wiselog_ab_data.txt";
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		
		FileReader fr = null;
		BufferedReader br = null;
		
		String stdDate = "20130407";
		String endDate = "20130408";
		try {
			fr = new FileReader(fileName);
			br = new BufferedReader(fr);
			String str;
			while((str = br.readLine()) != null){
				String data[] = str.split("\t");
				
				String ymd = "20" + data[0];
				if(ymd.compareTo(stdDate) >= 0 && ymd.compareTo(endDate) <= 0){
					Map<String, String> m = new HashMap<String, String>();
					m.put("date", new String(ymd));
					m.put("apageView", new String(data[1]));
					m.put("apageClick", new String(data[2]));
					m.put("apageCtr", new String(data[3]));
					m.put("bpageView", new String(data[4]));
					m.put("bpageClick", new String(data[5]));
					m.put("bpageCtr", new String(data[6]));
					
					list.add(m);
				}
			}
		} catch (Exception e) {
			System.out.println("Error:"+e.getMessage());
		} finally {
			if(br != null){
				br.close();
			}
			
			if(fr != null){
				fr.close();
			}
		}
		
		Collections.sort(list ,itemComparator);
		if(list != null && list.size() > 0){
			for (int i = 0; i < list.size(); i++) {
				Map<String, String> m = (Map<String, String>)list.get(i);
				StringBuffer stb = new StringBuffer()
				.append((String)m.get("date")).append("\t")
				.append((String)m.get("apageView")).append("\t")
				.append((String)m.get("apageClick")).append("\t")
				.append((String)m.get("apageCtr")).append("\t")
				.append((String)m.get("bpageView")).append("\t")
				.append((String)m.get("bpageClick")).append("\t")
				.append((String)m.get("bpageCtr")).append("\t");
				
				System.out.println(stb.toString());
			}
		}
	}
	
	
	private final static Comparator<Map<String, String>> itemComparator= new Comparator<Map<String, String>>() {

    	private final Collator collator = Collator.getInstance();

    	public int compare(Map<String, String> item1, Map<String, String> item2) {
    		return collator.compare((String)item2.get("date"), (String)item1.get("date"));
    	}
    };

}