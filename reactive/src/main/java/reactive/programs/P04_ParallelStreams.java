package reactive.programs;

import java.util.Arrays;
import java.util.List;

public class P04_ParallelStreams {
	public static void main(String[] args) {
		
		List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		
		nums.parallelStream()
			.forEach(n -> {
				System.out.printf("n= %d, thread = %s\n",
						n, Thread.currentThread().getName());
			});
		
		System.out.println("End of main!");
		
	}
}
