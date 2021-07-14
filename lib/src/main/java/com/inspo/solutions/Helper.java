package com.inspo.solutions;

import java.util.List;

public class Helper {
	public static List<Person> persons = List.of(
			new Person.Builder().setName("Abhik").setAge(7).setLocation(Location.TORONTO).setSalary(250000.00).build(),
			new Person.Builder().setName("Jaysen").setAge(2).setLocation(Location.TORONTO).setSalary(200000.00).build(),
			new Person.Builder().setName("Arithra").setAge(5).setLocation(Location.SUNAMGANJ).setSalary(200000.00).build(),
			new Person.Builder().setName("Adhishree").setAge(1).setLocation(Location.SUNAMGANJ).setSalary(100000.00).build(),
			new Person.Builder().setName("Thirtha").setAge(15).setLocation(Location.SYLHET).setSalary(300000.00).build(),
			new Person.Builder().setName("Pinaki").setAge(23).setLocation(Location.SYLHET).setSalary(300000.00).build(),
			new Person.Builder().setName("Thrisha").setAge(18).setLocation(Location.SYLHET).setSalary(300000.00).build(),
			new Person.Builder().setName("Dip").setAge(11).setLocation(Location.SYLHET).setSalary(150000.00).build(),
			new Person.Builder().setName("Dibbo").setAge(12).setLocation(Location.SYLHET).setSalary(150000.00).build(),
			new Person.Builder().setName("Rai").setAge(7).setLocation(Location.SYLHET).setSalary(200000.00).build(),
			new Person.Builder().setName("Argho").setAge(13).setLocation(Location.SYLHET).setSalary(200000.00).build(),
			new Person.Builder().setName("Bivan").setAge(3).setLocation(Location.LIVERPOOL).setSalary(200000.00).build(),
			new Person.Builder().setName("Janvi").setAge(5).setLocation(Location.LIVERPOOL).setSalary(200000.00).build()
		);
}
