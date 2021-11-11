import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

public class TestExample {
	@Test
	public void test() {
		LinkedHashMap<String, String> a = new LinkedHashMap<>();
		a.put("apple", "banana");
		a.put("mango", "orange");
		
		List<String> k = a.keySet().stream().map({ b -> b }).collect(Collectors.toList());

		k.each {
			println it
		}
	}
}
