package mong.testroom2;public class SyncMultiThread extends Thread{	String message;	SyncMultiThread key;		void get(SyncMultiThread k, String s){		key = k;		message = s;		start();	}		public void run(){		key.print(message);	}		synchronized void print(String message) {						System.out.print("["+message);			try{				Thread.sleep(1000);			}catch(Exception e){							}			System.out.println("]");	}		public static void main(String[] args) {		SyncMultiThread s1 = new SyncMultiThread();		SyncMultiThread s2 = new SyncMultiThread();		SyncMultiThread s3 = new SyncMultiThread();				SyncMultiThread key = new SyncMultiThread();		s1.get(key, "SyncMultiThread1");		s2.get(key, "SyncMultiThread2");		s3.get(key, "SyncMultiThread3");	}}