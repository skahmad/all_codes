package light.network;

import java.util.concurrent.CountDownLatch;

public class ThreadExample {
	public static void main(String[] args) throws InterruptedException {
		Application app1 = new Application();
		app1.create();
		
		Application app2 = new Application();
		app2.create();
		
		Application app3 = new Application();
		app3.create();
		
		Application app4 = new Application();
		app4.create();
		
		Application app5 = new Application();
		app5.create();
		
		Application app6 = new Application();
		app6.create();
		
		System.out.println("@@@ print name : ");
		System.out.println("App 1 : " + app1.getAppName());
		System.out.println("App 2 : " + app2.getAppName());
		System.out.println("App 3 : " + app3.getAppName());
		System.out.println("App 4 : " + app4.getAppName());
		System.out.println("App 5 : " + app5.getAppName());
		System.out.println("App 6 : " + app6.getAppName());
	}
	
	
	static class Application extends Thread{
		private String name;
		CountDownLatch latch = new CountDownLatch(1);
		
		public synchronized String getAppName() throws InterruptedException {
			latch.await();
			return name;
		}
		
		public void create() {
			start();
		}
		
		@Override
		public synchronized void run() {
			try {
				this.name = "App_" + System.currentTimeMillis();
				
				System.out.println("@@@ creating application");
				sleep(5000);
				latch.countDown();
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

