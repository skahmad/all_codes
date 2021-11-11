import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.*;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

public class NetTest {
	
	@Test
	public void get_ip_from_url() throws UnknownHostException {
		InetAddress address = InetAddress.getByName("www.oreilly.com");
		System.out.println(address);
		
		
		InetAddress address1 = InetAddress.getByName("www.google.com");
		System.out.println(address1);
		
		InetAddress address2 = InetAddress.getByName("localhost");
		System.out.println(address2);
		
		InetAddress[] addresses = InetAddress.getAllByName("www.google.com");
		
		for (InetAddress inetAddress : addresses) {
			System.out.println(inetAddress);
		}
	}
	
	
	@Test
	public void get_host_name_from_ip() throws UnknownHostException {
		//InetAddress address1 = InetAddress.getByName("142.250.194.132");
		//InetAddress address1 = InetAddress.getByName("192.168.96.21");
		//System.out.println(address1.getHostName());
		//System.out.println(address1.getCanonicalHostName());
		
		checkHost("192.168.96");
	}
	
	@Test
	public void get_host_by_address() throws UnknownHostException {
		InetAddress address = InetAddress.getByAddress(new byte[]{(byte)142,(byte)250,(byte)194,(byte)132});
		System.out.println(address);
	}
	
	
	@Test
	public void get_all_network_interfaces() throws SocketException {
		Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
		while (interfaces.hasMoreElements()) {
			NetworkInterface ni = interfaces.nextElement();
			System.out.println(ni);
		}
	}
	
	@Test
	public void get_single_interface_info_by_name() throws SocketException {
		NetworkInterface eth0 = NetworkInterface.getByName("eth0");
		Enumeration addresses = eth0.getInetAddresses();
		while (addresses.hasMoreElements()) {
			System.out.println(addresses.nextElement());
			
		}
	}
	
	
	@Test
	public void read_content_from_url() {
		try {
			URL u = new URL("http://192.168.96.56");
			System.out.println("port : " + u.getDefaultPort());
			InputStream in = u.openStream();
			int c;
			while ((c = in.read()) != -1)
				System.out.write(c);
			in.close();
		} catch (IOException ex) {
			System.err.println(ex);
		}
	}
	
	private void checkHost(String ip) throws UnknownHostException {
		for (int i=0;i<255;i++) {
			InetAddress address = InetAddress.getByName(ip + '.' + i);
			System.out.println(address.getHostName());
			System.out.println(address.getHostAddress());
		}
	}
	
	
	
	@Test
	public void another_test() {
		LinkedHashMap<String, String> a = new LinkedHashMap<>();
		a.put("apple", "banana");
		a.put("mango", "orange");
		
		List<String> k = a.keySet().stream().map(b->b).collect(Collectors.toList());
		
		k.forEach(System.out::println);
	}
}
