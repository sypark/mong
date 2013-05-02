package mong.testroom2;

public class TestSleep{

	public static void main(String args[]) throws InterruptedException{
		String count [] = {"1", "2", "3"};
		
		for (int i = 0; i < count.length; i++) {
			Thread.sleep(3000);
			System.out.println(count[i]);
		}
	}

}
