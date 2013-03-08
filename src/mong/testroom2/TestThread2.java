package mong.testroom2;

import junit.framework.TestCase;
import junit.textui.TestRunner;

import org.junit.Test;


public class TestThread2 extends TestCase{
	@Test
	public void testM() throws Throwable{
		TestRunner [] t = new TestRunner[20];
		
		for (int i = 0; i < t.length; i++) {
			t[i] = new Tester2(i);
		}
		
		
	}
}
