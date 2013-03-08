package mong.testroom2;

public class Tester implements Runnable {

	int i = 0;
	
	public Tester(int i){
		this.i=i;
	}
	

	public void run() {
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		
		System.out.println(Thread.currentThread().getName()+":["+i+"]");
	}

}
