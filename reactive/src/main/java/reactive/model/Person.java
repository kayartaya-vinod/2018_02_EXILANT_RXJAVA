package reactive.model;

import java.util.Arrays;
import java.util.List;

public class Person {
	private String name;
	private int age;
	private Gender gender;
	
	public static List<Person> getSampleData() {
		return Arrays.asList(
			new Person("vinod", 25, Gender.MALE),
			new Person("Anu", 43, Gender.FEMALE),
			new Person("Khushi", 15, Gender.FEMALE),
			new Person("Karishma", 8, Gender.FEMALE),
			new Person("ramesh", 37, Gender.MALE),
			new Person("harish", 55, Gender.MALE),
			new Person("suresh", 28, Gender.MALE),
			new Person("john", 82, Gender.MALE),
			new Person("jane", 58, Gender.FEMALE)
		);
	}

	public Person() {
	}

	public Person(String name, int age, Gender gender) {
		this.name = name;
		this.age = age;
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", gender=" + gender + "]";
	}

}
