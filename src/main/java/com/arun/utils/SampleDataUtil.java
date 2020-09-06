package com.arun.utils;

import java.util.ArrayList;
import java.util.List;

import com.arun.pojos.Person;
import com.ticket.constants.Gender;

public class SampleDataUtil {

	public static List<Person> createPersonData() {
		List<Person> persons = new ArrayList<>();
		persons.add(new Person("Sai", Gender.MALE, "Hyderabad", 25001, 26));
		persons.add(new Person("Srinu", Gender.MALE, "Hyderabad", 25001, 23));
		persons.add(new Person("Rakshita", Gender.FEMALE, "Hyderabad", 25001, 29));
		persons.add(new Person("Reena", Gender.FEMALE, "Hyderabad", 25001, 28));
		persons.add(new Person("vishnu", Gender.MALE, "Bangalore", 25001, 24));
		persons.add(new Person("ram", Gender.MALE, "Bangalore", 25001, 26));
		persons.add(new Person("selvam", Gender.MALE, "Channai", 25001, 26));

		return persons;

	}

}
