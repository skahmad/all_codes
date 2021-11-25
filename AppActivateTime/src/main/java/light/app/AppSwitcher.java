package light.app;

public class AppSwitcher {
	public static void main(String[] args) throws Exception {
		SwitchRobot switchRobot = new SwitchRobot();
		
		Arguments arguments = new Arguments("App Switch",args);
		arguments
			.setMandatory("time", "usage" );
		
		
		if (arguments.validate()) {
			int totalTime = 60*60*2;
			int useAgeTime = 10*60;
			
			try {
				totalTime = Integer.parseInt(arguments.getValueByArg("time").get(0));
			}
			catch ( NumberFormatException n) {
				throw new NumberFormatException("Please provide valid number in second in time, such as 10,20 or 220");
			}
			
			try {
				useAgeTime = Integer.parseInt(arguments.getValueByArg("usage").get(0));
			}
			catch ( NumberFormatException n) {
				throw new NumberFormatException("Please provide valid number in second in time, such as 10,20 or 220");
			}
			
			
			int timeCount = 0;
			
			do {
				timeCount += useAgeTime;
				
				int stime = useAgeTime/11;
				
				switchRobot.switchApp();
				switchRobot.wait(stime);
				
				switchRobot.changeTab();
				switchRobot.wait(stime);
				
				
				switchRobot.scrollApp(-10);
				switchRobot.wait(stime);
				
				
				switchRobot.scrollApp(1);
				switchRobot.wait(stime);
				
				switchRobot.scrollApp(1);
				switchRobot.wait(stime);
				
				switchRobot.scrollApp(1);
				switchRobot.wait(stime);
				
				
				switchRobot.changeTab();
				switchRobot.wait(stime);
				
				switchRobot.scrollApp(-10);
				switchRobot.wait(stime);
				
				
				switchRobot.scrollApp(1);
				switchRobot.wait(stime);
				
				switchRobot.scrollApp(1);
				switchRobot.wait(stime);
				
				switchRobot.scrollApp(1);
				switchRobot.wait(stime);
				
			}while(timeCount < totalTime);
			
		} else {
			arguments.info();
		}
	}
}
