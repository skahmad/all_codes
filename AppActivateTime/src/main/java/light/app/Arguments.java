package light.app;

import java.util.*;

/**
 * this class is used to manage command line argument
 */
public class Arguments {
	Map<String, ArrayList<String>> argsAndValue = new HashMap<>();
	
	String appName = "";
	String argName = "";
	ArrayList<String> values = new ArrayList<>();
	private List<String> mandatory = new ArrayList<>();
	
	StringBuilder stringBuilder = new StringBuilder();
	String note = "";
	String appDetails = "";
	//String allUsage = "";
	
	public Arguments(String appName, String[] args) throws Exception {
		if(appName == null || appName.length() == 0) {
			throw new Exception("App name should not empty!");
		}
		
		this.appName = appName;
		this.argName = appName;
		boolean flag = false;
		
		for(String s:args) {
			if(s.startsWith("-")) {
				argsAndValue.put(argName, values);
				
				values = new ArrayList<>();
				argName = s;
			} else {
				values.add(s);
			}
		}
		
		argsAndValue.put(argName, values);
	}
	
	public Arguments setMandatory(String... mandatory) {
		this.mandatory = Arrays.asList(mandatory);
		return this;
	}
	
	public boolean validate() throws Exception {
		if(!mandatory.isEmpty()) {
			List<String> args = this.getArguments();
			for(String m:this.mandatory) {
				if( !args.contains("-" + m) ){
					throw new Exception("argument missing -" + m);
				}
			}
		}
		return true;
	}
	
	public List<String> getValueByArg(String arg) {
		try {
			return this.argsAndValue.get(appName.equalsIgnoreCase(arg)? arg: ("-" + arg));
		}catch (Exception e)  {
			return new ArrayList<>();
		}
	}
	
	public List<String> getArguments() {
		return new ArrayList<>(this.argsAndValue.keySet());
	}
	
	public Map<String, ArrayList<String>> getArgAndValue() {
		return this.argsAndValue;
	}
	
	
	
	// for help
	public Arguments setAppDetails(String details) {
		this.appDetails = details;
		return this;
	}
	
	public Arguments setNote(String note) {
		this.note = note;
		return this;
	}
	
	public Arguments addAvailableAgrAndDetails(String arg, String description) {
		stringBuilder
			.append("-")
			.append(arg)
			.append("\t\t\t")
			.append(description)
			.append("\n");
		return this;
	}
	
	
	public boolean find(String arg) {
		return this.argsAndValue.containsKey(arg);
	}
	
	public void help() {
		System.out.println("\n" + appDetails);
		System.out.println(stringBuilder.toString());
		System.out.println(note);
	}
	
	public void info() {
		System.out.println(this.appName);
		System.out.println(this.appDetails);
		System.out.println("Mandatory : ");
		this.mandatory.forEach(m->{
			System.out.print("-" + m + " ");
		});
		
		System.out.println("\nArgument and value : ");
		this.argsAndValue.forEach((a,v)->{
			System.out.print(a + ": ");
			v.forEach(p -> {
				System.out.print(p + " ");
			});
			System.out.println("");
		});
		
		System.out.println("usage : ");
		System.out.println(this.stringBuilder.toString());
		System.out.println(this.note);
	}
}
