package com.arun.codechallenge;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.OptionalDouble;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.arun.pojos.Person;
import com.arun.utils.SampleDataUtil;
import com.ticket.constants.Gender;

/*
* Person has 5 Attributes Age ,Salary , Location , Gender , Name
*
* Create Sufficient amount of Person Data to meet following Requirements
*
* 1. Average Salary of Persons who meet following criterion
* - Age > 25
* - Salary > 25000
* - Location = Hyderabad
* - Gender = Female
* - Name starting with "R"
*
* 2. Segregate the Persons based on Locations
*
*  output : Hyderabad
*                    Sai
*                    Srinu
*                    Rakshita
*                    Reena
*           Bangalore
*                    vishnu
*                    ram
*           Chennai
*                    Selvam
* Note : Use on Java 8 features like STreams , Method reference , optional , Functional Interface etc
*
*/
public class ArunCodeChallenge1 {

	public static void main(String[] args) {
		List<Person> persons = SampleDataUtil.createPersonData();
		OptionalDouble avgSalary = persons.stream().filter(filter).mapToDouble(p -> p.getSalary()).average();
		System.out.println("AvgSalary : " + avgSalary.getAsDouble());

		Map<String, List<String>> groupedMap = persons.stream().collect(
				Collectors.groupingBy(p -> p.getLocation(), Collectors.mapping(p -> p.getName(), Collectors.toList())));
		for (Entry<String, List<String>> entry : groupedMap.entrySet()) {
			System.out.println("Locations : " + entry.getKey() + ", Persons " + entry.getValue());
		}
	}

	static Predicate<Person> filter = (Person p) -> {
		if (p.getAge() > 25 && p.getSalary() > 25000 && p.getLocation().equals("Hyderabad")
				&& p.getGender().equals(Gender.FEMALE) && p.getName().startsWith("R")) {
			return true;
		} else {
			return false;
		}

	};

}
