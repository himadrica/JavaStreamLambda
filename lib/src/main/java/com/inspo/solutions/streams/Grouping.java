package com.inspo.solutions.streams;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

import com.inspo.solutions.Helper;
import com.inspo.solutions.Location;
import com.inspo.solutions.Person;
import com.inspo.solutions.Tuple;

public class Grouping {

	// Simple Grouping by a Single Column
	public static void simpleGrouping() {
		Map<Location, List<Person>> result = Helper.persons.stream()
				.collect(Collectors.groupingBy(Person::getLocation));
		result.forEach((key, value) -> {
			System.out.println("Key = " + key);
			System.out.println("Value = ");
			value.forEach(System.out::println);
		});
	}

	// groupingBy with a Complex Map Key Type
	public static void groupingWithKeyMap() {
		Map<Tuple, Set<Person>> result = Helper.persons.stream().collect(
				Collectors.groupingBy(person -> new Tuple(person.getName(), person.getAge()), Collectors.toSet()));

		result.forEach((key, value) -> {
			System.out.println("Key = " + key);
			System.out.println("Value = ");
			value.forEach(System.out::println);
		});

	}

	// Grouping by Multiple Fields
	public static void groupingByMultipleFields() {
		Map<Location, Map<Double, List<Person>>> result = Helper.persons.stream()
				.collect(Collectors.groupingBy(Person::getLocation, Collectors.groupingBy(Person::getSalary)));

		result.forEach((location, gmap) -> {
			System.out.println(location);
			gmap.forEach((salary, list) -> {
				System.out.println("   " + salary);
				list.forEach(person -> {
					System.out.println("       " + person);
				});
			});
		});
	}

	// Getting the Average from Grouped Results
	public static void averageFromGroupBy() {
		Map<Location, Double> avg = Helper.persons.stream()
				.collect(Collectors.groupingBy(Person::getLocation, Collectors.averagingDouble(Person::getSalary)));

		avg.forEach((key, value) -> {
			System.out.println(key + " -> " + value);
		});
	}

	public static void gettingMaxMin() {
		Map<Location, Optional<Person>> maxAgaebyLocation = Helper.persons.stream().collect(
				Collectors.groupingBy(Person::getLocation, Collectors.maxBy(Comparator.comparingInt(Person::getAge))));

		maxAgaebyLocation.forEach((location, personOptional) -> {
			System.out.println("Location: " + location);
			if (personOptional.isPresent()) {
				System.out.println("      " + personOptional.get());
			}
		});
	}
	
	/*
	 * The IntSummaryStatistics object for each type contains the count, sum, average, min and max values for 
	 * the likes attribute. Additional summary objects exist for double and long values.
	 */
	public static void intSummaryStatistic() {
		Map<Location, IntSummaryStatistics> summary = Helper.persons
				.stream()
				.collect(
						Collectors.
						groupingBy(Person::getLocation, Collectors.summarizingInt(Person::getAge)));
		summary.forEach((location, sum) -> {
			System.out.println("Location: " + location);
			System.out.println("     summary: " + sum.toString() );
		});
	}
	
	public static void groupToADifferentResult() {
		Map<Location, String> result = Helper.persons.stream()
				  .collect(Collectors.groupingBy(Person::getLocation, 
				  Collectors.mapping(Person::getName, Collectors.joining(", ", "Names: [", "]"))));
		
		result.forEach((key, value) -> {
			System.out.println(key + " -> " + value);
		});
	}
	
	public static void concurrentGrouping() {
		ConcurrentMap<Location, List<Person>> groupList = Helper.persons.parallelStream()
				  .collect(Collectors.groupingByConcurrent(Person::getLocation));
		
		groupList.forEach((key, value) -> {
			System.out.println("Key = " + key);
			System.out.println("Value = ");
			value.forEach(System.out::println);
		});
	}
	
	public static void main(String[] args) {
		concurrentGrouping();
	}
}
