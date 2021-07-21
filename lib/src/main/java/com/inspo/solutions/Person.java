package com.inspo.solutions;

public class Person {
	private String name;
	private int age;
	private Location location;
	private double salary;

	public Person(String name, int age, Location location, double salary) {
		this.name = name;
		this.age = age;
		this.location = location;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public Location getLocation() {
		return location;
	}

	public double getSalary() {
		return salary;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", location=" + location + ", salary=" + salary + "]";
	}

	public static class Builder {
		private String name;
		private int age;
		private Location location;
		private double salary;

		public Builder setName(String name) {
			this.name = name;
			return this;
		}

		public Builder setAge(int age) {
			this.age = age;
			return this;
		}

		public Builder setLocation(Location location) {
			this.location = location;
			return this;
		}

		public Builder setSalary(double salary) {
			this.salary = salary;
			return this;
		}

		public Person build() {
			return new Person(this.name, this.age, this.location, this.salary);
		}
	}
}
