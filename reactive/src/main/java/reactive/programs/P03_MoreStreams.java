package reactive.programs;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import reactive.model.Person;

public class P03_MoreStreams {

	public static void main(String[] args) {
		List<Integer> nums = Arrays.asList(12, 31, 40, 50, 39, 22);
		
		List<Integer> evenNums = nums.stream()
			.filter(n -> n%2==0 )
			.collect(Collectors.toList());
		
		System.out.println(evenNums);
		
		String allNames = Person.getSampleData().stream()
			.map(p->p.getName())
			.collect(Collectors.joining(";"));
		
		System.out.println(allNames);
		
		
		System.out.println(nums);
		Integer total = nums.stream()
			.reduce(
				0,  
				(acc, cv) -> {
					System.out.println("acc=" + acc + ", cv=" +cv);
					return acc+cv;
				}
			);
		
		System.out.println("Total = " + total);
		
		total = nums.stream().reduce(Integer::sum).get();
		System.out.println("Total = " + total);
		
		total = nums.stream().mapToInt(n->n.intValue()).sum();
		System.out.println("Total = " + total);
	}
}








