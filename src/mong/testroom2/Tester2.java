package mong.testroom2;

import junit.textui.TestRunner;

public class Tester2 extends TestRunner{

	int i = 0;
	public Tester2(int i){
		this.i = i;
	}
	
	public void runTest(){
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		System.out.println(Thread.currentThread().getName() + ":[i"+i+"]");
	}
}
