package com.inspo.solutions;

public class Test {

	public static void main(String[] args) {
		Person person = new Person.Builder()
				.setName("Abhik")
				.setAge(7)
				.setLocation(Location.TORONTO)
				.setSalary(200000.00)
				.build();
		System.out.println(person);
	}

}
