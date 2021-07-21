package com.inspo.solutions;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {

	public static void main(String[] args) {
		String input = "Tree,Cat,Tree,Bob Cat, Maple Tree, Tree, Cat, Dog, Amberr, Black lab, Tree, Maple Tree, Water, Amber, Cat, Dog, Maple Tree";

		Map<String, Long> result = Stream.of(input.split(","))
				.collect(Collectors.groupingBy(a -> a.trim(), Collectors.counting())).entrySet().stream().sorted(Map.Entry.comparingByKey())
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (old, newvalue) -> old,
						LinkedHashMap::new));

		result.forEach((key, value) -> {
			System.out.println(String.format("Data: %s >%d< times.", key, value));
		});
	}

}
