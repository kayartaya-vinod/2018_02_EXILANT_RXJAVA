package reactive.programs;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class P01_LambdaFunctions {
	public static void main(String[] args) {
		List<String> names = Arrays.asList("vinod", "shyam sundar", "satyanarayan", "mohan kumar", "dayananda",
				"vinay");

		System.out.println("Before sorting: " + names);
		Collections.sort(names);
		System.out.println("After sorting: " + names);

		// Comparator<String> cmp = new Comparator<String>() {
		// @Override
		// public int compare(String s1, String s2) {
		// return s2.length()-s1.length();
		// }
		// };

		Collections.sort(names, (s1, s2) -> s2.length() - s1.length());
		
		System.out.println("After sorting: " + names);

	}
}



