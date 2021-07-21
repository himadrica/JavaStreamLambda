package com.inspo.solutions.pattern.combinator;

import java.util.function.Function;
import com.inspo.solutions.Location;
import com.inspo.solutions.Person;

public interface PersonValidator extends Function<Person, ValidationResult> {
	static PersonValidator isNameValid() {
		return person -> person.getName().length() < 3 ? ValidationResult.NAME_NOT_VALID : ValidationResult.SUCESS;
	}

	static PersonValidator isAgeValid() {
		return person -> person.getAge() < 2 ? ValidationResult.AGE_NOT_VALID : ValidationResult.SUCESS;
	}

	static PersonValidator isLocationValid() {
		return person -> person.getLocation() == Location.CHITTAGONG ? ValidationResult.LOCATION_NOT_VALID
				: ValidationResult.SUCESS;
	}

	static PersonValidator isSalaryValid() {
		return person -> person.getSalary() < 100 ? ValidationResult.SALARY_NOT_VALID : ValidationResult.SUCESS;
	}

	default PersonValidator and(PersonValidator other) {
		return person -> {
			ValidationResult result = this.apply(person);
			return result.equals(ValidationResult.SUCESS) ? other.apply(person) : result;
		};
	}
}
