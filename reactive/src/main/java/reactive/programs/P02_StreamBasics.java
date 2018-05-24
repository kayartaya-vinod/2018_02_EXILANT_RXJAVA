package reactive.programs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import reactive.model.Gender;
import reactive.model.Person;

public class P02_StreamBasics {
	public static void main(String[] args) {

		List<Person> persons = Person.getSampleData();

		// for(Person p: persons) {
		// System.out.println(p.getName());
		// }

		// Iterator<Person> it = persons.iterator();
		// while(it.hasNext()) {
		// Person p = it.next();
		// System.out.println(p.getName());
		// }

//		persons.forEach(new Consumer<Person>() {
//			@Override
//			public void accept(Person p) {
//				System.out.println(p.getName());
//			}
//		});
		
		persons.forEach( p ->System.out.println(p.getName()) );
		
		line();
		
		List<Integer> nums = Arrays.asList(12, 30, 51, 303, 40);
		nums.stream()
			.filter(num -> num%2==0)
			.map(Math::sqrt) // .map(num -> Math.sqrt(num))
			.forEach(System.out::println);
		
		line();
		
		
		// list names in uppercase of all female less than 30 years
		Stream<Object> str = persons.stream()	
			.filter(p->p.getGender()==Gender.FEMALE)
			.filter(p->p.getAge()<30)
			.peek(p->{
				System.out.println("Peeking this object: " + p);
			})
			.map(p->p.getName().toUpperCase());
		
		
		str.forEach(System.out::println);
		line();
		
		// use of final in lambda (pure function)
		// functional programming rules:
		// 1. pure functions should not change the input
		// 2. pure function should not depend on somthing that changes
		final Integer []factor = {4};
		Stream<Integer> str1 = nums.stream()
			.map(num->num*factor[0]);
		
		factor[0] = 2;
		str1.forEach(System.out::println);
		line();
		
		int totalAge = persons.stream()
			.mapToInt(p->p.getAge())
			.sum();
		
		System.out.println("Total age of all = " + totalAge);
		line();
		
		
		// youngest person
		Person yp = persons.stream()
			.min((p1, p2) -> p1.getAge() - p2.getAge())			
			.get();
		
		System.out.println("Youngest person is: "+yp);
		line();
		
		Comparator<Person> comp1 = (p1, p2) -> p1.getAge() - p2.getAge();
		Comparator<String> comp2 = (s1, s2) -> s1.length() - s2.length();

		List<String> names = Arrays.asList("vinod", "vinay kymar", "ajay");
		Test<String> t1 = new Test<>();
		Test<Person> t2 = new Test<>();
		String maxName = t1.getMax(names.stream(), comp2);
		Person oldPerson = t2.getMax(persons.stream(), comp1);
		
		System.out.println(maxName);
		System.out.println(oldPerson);
	}

	static void line() {
		System.out.println("------------------");
	}
	
	static class Test<T> {
		public T getMax(Stream<T> stream, Comparator<T> cmp) {
			return stream
					.max(cmp)
					.get();
		}

	}
	
	
}











