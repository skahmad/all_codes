package light.app;

import java.awt.*;
import java.awt.event.KeyEvent;

public class SwitchRobot {
	private Robot robot;
	
	public SwitchRobot() throws AWTException {
		robot = new Robot();
	}
	
	public void switchApp() {
		//System.out.println("@@@ switch");
		robot.keyPress(KeyEvent.VK_ALT);
		robot.keyPress(KeyEvent.VK_TAB);
		
		robot.keyRelease(KeyEvent.VK_ALT);
		robot.keyRelease(KeyEvent.VK_TAB);
	}
	
	public void scrollApp(int count) {
		//System.out.println("@@@ scroll");
		robot.mouseWheel(count);
	}
	
	public void changeTab() {
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_TAB);
		
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_TAB);
	}
	
	public void wait(int sec) {
		try {
			//System.out.println("@@@ wait : " +sec + " seconds");
			Thread.sleep(sec * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
