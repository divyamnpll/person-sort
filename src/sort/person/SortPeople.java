package sort.person;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortPeople {

	public static void main(String[] args) throws ParseException {

		List<Person> list = new ArrayList<Person>();

		Person person1 = new Person();
		person1.setSsn("576");
		person1.setFirstName("John");
		person1.setLastName("Grishman");
		person1.setDateOfBirth(new SimpleDateFormat("MM/dd/yyyy").parse("12/09/1984"));
		person1.setHeightIn(5.9);
		person1.setWeightLb(132.3);
		list.add(person1);

		Person person2 = new Person();
		person2.setSsn("0576");
		person2.setFirstName("andy");
		person2.setLastName("tool");
		person2.setDateOfBirth(new SimpleDateFormat("MM/dd/yyyy").parse("01/01/2000"));
		person2.setHeightIn(5.3);
		person2.setWeightLb(180.3);
		list.add(person2);

		Person person3 = new Person();
		person3.setSsn("88576");
		person3.setFirstName("foo");
		person3.setLastName("bar");
		person3.setDateOfBirth(new SimpleDateFormat("MM/dd/yyyy").parse("11/1/1900"));
		person3.setHeightIn(6.3);
		person3.setWeightLb(150.3);
		list.add(person3);

		// before sort
		System.out.println("before sort");
		for (Person person : list) {
			System.out.println(person.toString());
		}
		sort(list, "firstName", "true");
		// After sorted the list
		System.out.println("after sort");
		for (Person person : list) {
			System.out.println(person.toString());
		}
	}

	static List<Person> sort(List<Person> people, String sortField, String ascending) {
		boolean order = false;
		if (ascending.equals("true")) {
			order = true;
		}
		SortPersonComparator sortPerson = new SortPersonComparator(sortField, order);
		Collections.sort((List<Person>) people, sortPerson);
		return people;

	}

}
