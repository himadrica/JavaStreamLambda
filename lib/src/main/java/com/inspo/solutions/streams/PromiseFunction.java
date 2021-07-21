package com.inspo.solutions.streams;

import java.util.Objects;
import java.util.function.Function;

public class PromiseFunction {

	public static void main(String[] args) {
		Function<String, String> promise = value -> "calling with " + value;

		String hello = promise.andThen(first -> {
			System.out.println("first promise call " + first);
			return "first promise call " + first;
		}).andThen(second -> {
			System.out.println("second promise call " + second);
			return "second promise call " + second;
		}).apply("Abhik");

		System.out.println(hello);

	}

}