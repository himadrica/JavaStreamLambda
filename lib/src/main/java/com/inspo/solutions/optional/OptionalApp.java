package com.inspo.solutions.optional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;

import com.inspo.solutions.Helper;
import com.inspo.solutions.Person;

/**
 * @author himadri
 *
 *         It was introduced in Java 8 to cure the curse of NullPointerExceptions
 * 		   https://blogs.oracle.com/javamagazine/the-java-optional-class-11-more-recipes-for-preventing-null-pointer-exceptions
 * 
 *         1. Optional should not be used as a field type 
 *         2. Optional should not be used in the constructor argument 
 *         3. Optional should not be used in the method’s arguments. 
 *         4. Do not use Optional as an argument to setters. Don’t forget that Optional is not Serializable.
 *         5. Do not assert the emptiness of arrays or collections by using Optional. 
 *         6. It is better to use numeric Optional over generic Optional for numbers.
 *         7. Use the filter() method to filter a wrapped value.
 */
public class OptionalApp {
	
	private static List<Account> accounts = List.of(
				new Account("Abhik", 10000, Account.TYPE.CREDIT),
				new Account("Jaysen", 10000, Account.TYPE.DEBIT),
				new Account("Arithra", 10000, Account.TYPE.CREDIT),
				new Account("Adhishree", 10000, Account.TYPE.DEBIT),
				new Account("Thirtha", 10000, Account.TYPE.CREDIT)
			);

	// 5. Do not assert the emptiness of arrays or collections by using Optional. It is an anitpattern.
	public Optional<List<Person>> getPersonListWithOptional() {
		List<Person> persons = Helper.persons;
		return Optional.ofNullable(persons);
	}

	// for collections and arrays check emptiness or null before returning
	public List<Person> getPersonWithoutOptional() {
		return Helper.persons != null ? Helper.persons : Collections.emptyList();
	}

	// 6. It is better to use numeric Optional over generic Optional for numbers.
	// autoboxing hurts performance in some cases. Thus, it is better to use a
	// numeric version of Optional that is a wrapper for the primitive values such
	// as int, long, and double and that can be unwrapped with getAsInt(),
	// getAsLong(), and getAsDouble() as appropriate:
	public void returningGenericOptional() {
		// Optional<Integer> price = Optional.of(156);
		// Optional<Long> peopleCount = Optional.of(156_978_934_24L);
		// Optional<Double> finalPrice = Optional.of(230.17d);

		// better to use Wrapper optional
		OptionalInt price = OptionalInt.of(156);
		OptionalLong peopleCount = OptionalLong.of(156_978_934_24L);
		OptionalDouble finalPrice = OptionalDouble.of(230.17d);

	}
	
	// 7. Use the filter() method to filter a wrapped value.
	public Optional<Account> getAccount(int id){
		Account account = null;
		if(id >= 0 && id < accounts.size()) {
			 account = accounts.get(id);
		}
		return Optional.ofNullable(account);
	}
	
	/*
	 *  7. Use the filter() method to filter a wrapped value.
	 *  Check accountId for null and not being empty and follow account# schema
		Optional<Account> accountFiltered = getAccount(accountId);
		
		if (accountFiltered.isPresent()) {
		    Account account = accountFiltered.get();
		    if (!account.isOverdraftAllowed()) {
		        throw new IllegalStateException("Overdraft is not allowed for this account.");
		    }
		    
		    account.addToBalance(value);
		    updateAccount(account);
		}
	 */
	
	public void useFilterMethodOfOptional() {
		getAccount(9)
        .filter(account -> account.isOverdraftAllowed())
        .ifPresentOrElse(account -> {
            System.out.println("Perform some operation");
        }, () -> {
            throw new IllegalStateException("Overdraft is not allowed for this account.");
        });
	}
	
	// 8. Know when to use map() and flatMap() for extracting and transforming values.
	public void useMapAndFlatmapofOptional() {
		var names = getAccount(0)
				.filter(Account::isOverdraftAllowed)
				.map(Account::getName)
				.map(String::toUpperCase)
				.orElse("Name not found");
		
		System.out.println(names);
	}
	
	public void optionalEquality() {
		Optional<String> first = Optional.of("Abhik");
		Optional<String> second = Optional.of("Abhik");
		// check equality with equals of Optional 
		System.out.println(first == second); // will be false
		System.out.println(first.get().equals(second.get())); //would be true no need to unwrap the object, next one is recommended
		System.out.println(first.equals(second)); //would be true
	}
	
	public static void main(String[] args) {
		new OptionalApp().optionalEquality();
	}

}

class Account {

	enum TYPE {
		SAVINGS, CREDIT, DEBIT;
	}

	private String name;
	private TYPE type;
	private double balance;

	public Account(String name, double balance) {
		this.name = name;
		this.balance = balance;
	}

	public Account(String name, double balance, TYPE type) {
		this(name, balance);
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public TYPE getType() {
		return type;
	}

	public double getBalance() {
		return balance;
	}

	public Account setName(String name) {
		this.name = name;
		return this;
	}

	public Account setType(TYPE type) {
		this.type = type;
		return this;
	}

	public Account setBalance(double balance) {
		this.balance = balance;
		return this;
	}
	
	public boolean isOverdraftAllowed() {
		return true;
	}

}