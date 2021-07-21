package com.inspo.solutions.streams;

import java.util.function.Function;

public class Callback {
	
	public static void CallbackWithFunction(int a, Function<Integer,Integer> callback) {
		if(callback == null) {
			System.out.println("no callback call");
		}else {
			int result = callback.apply(a);
			System.out.println("callback is calling...");
			System.out.println(result);
		}
		
	}

	public static void main(String[] args) {
		CallbackWithFunction(10, a -> {
			System.out.println("Call back method inside");
			return a + 1;
		});
	}

}
