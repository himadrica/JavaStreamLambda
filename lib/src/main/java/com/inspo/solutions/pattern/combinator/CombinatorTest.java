package com.inspo.solutions.pattern.combinator;

import com.inspo.solutions.Person;
import static com.inspo.solutions.pattern.combinator.PersonValidator.*;

public class CombinatorTest {

	public static void main(String[] args) {
		Person person = new Person.Builder().setName("Abhik").setAge(0).setSalary(200000).build();
		ValidationResult result = PersonValidator
				.isNameValid()
				.and(isAgeValid())
				.and(isSalaryValid())
				.apply(person);

		System.out.println(result);
	}

}
