package mong.testroom2;

import junit.framework.TestCase;

import org.junit.Test;

public class TestThread extends TestCase{

	@Test
	public void testM(){
		for (int i = 0; i < 20; i++) {
			new Thread(new Tester(i)).start();
		}
		
		System.out.println("main end.......");
	}

}
