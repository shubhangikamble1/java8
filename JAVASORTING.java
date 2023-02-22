package com.yash.demo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.yash.Employee;

class Customer {
	String custName;
	String custCity;
	Integer custAge;
	Integer salary;

	public Customer(String custName, String custCity, Integer custAge, Integer salary) {
		super();
		this.custName = custName;
		this.custCity = custCity;
		this.custAge = custAge;
		this.salary = salary;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustCity() {
		return custCity;
	}

	public void setCustCity(String custCity) {
		this.custCity = custCity;
	}

	public Integer getCustAge() {
		return custAge;
	}

	public void setCustAge(Integer custAge) {
		this.custAge = custAge;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Customer [custName=" + custName + ", custCity=" + custCity + ", custAge=" + custAge + ", salary="
				+ salary + "]";
	}

}

public class JAVASORTING {

	public static void main(String[] args) {

		List<Customer> s = Arrays.asList(new Customer("Shalini", "Chennai", 60, 24000),
				new Customer("Sneha", "Pune", 73, 24400), new Customer("Hrushi", "Bangalore", 37, 890000),
				new Customer("Trisha", "Hyderabad", 52, 24007), new Customer("sneha", "chennai", 70, 25000),
				new Customer("Asmita", "Bangalore", 38, 27800), new Customer("Hrushi", "Mangalore", 45, 28900),
				new Customer("Asmita", "Pune", 22, 78900), new Customer("Shubhangi", "Chennai", 50, 87600),
				new Customer("Shubhangi", "pune", 50, 9000000)
				);

		// s.stream().map((a,a1)->a.getCustAge().compareTo(a1.getAge()));
		List<Customer> collect = s.stream().sorted((o1, o2) -> o1.custAge - o2.custAge).
								collect(Collectors.toList());

		List<Customer> collect2 = s.stream().sorted((s1, s2) -> s1.getSalary() - s2.getSalary())
				.collect(Collectors.toList());
		

		List<Customer> descNames = s.stream().sorted((s1, s2) -> s2.getCustName().
				compareToIgnoreCase(s1.getCustName())).distinct()
				.collect(Collectors.toList());
		
		
		
		System.out.println("desc names \n "+descNames +"\n \n");
		
		
		
		double asDouble = s.stream().mapToDouble(a -> a.getSalary()).max().getAsDouble();

		System.out.println("asdouble " + asDouble);
		System.out.println(collect + "");
		System.out.println(collect2 + "");

		Optional<Customer> customer = s.stream().max(Comparator.comparing(Customer::getSalary))
				          .filter(e->"shubhangi".equalsIgnoreCase(e.getCustName())).
				          filter(e->e.getCustCity().equalsIgnoreCase("pune"));
		System.out.println("Optional "+customer);

		Customer customer2 = s.stream().max(Comparator.comparing(Customer::getSalary)).get();
		System.out.println("max salary " + customer2);
		s.stream().map(s1 -> s1.getCustCity()).collect(Collectors.toList());
     
		
		//sort by particular name and print city
		
		Map<String, List<Customer>> collect3 = s.stream().filter(e -> "Sneha".equalsIgnoreCase(e.getCustName()))
				.collect(Collectors.groupingBy(Customer::getCustCity));
		collect3.forEach((name, city) -> System.out.println(name + "-> " + city));
		
		
		
		//get employee less than 45
		List<Customer> age = s.stream().filter(a->a.custAge<70).collect(Collectors.toList());
		
		 Map<String, Long> collect4 = s.stream().filter(sd->sd.getCustAge()<25).map(Customer::getCustName).
		                 filter(s1->s1.equalsIgnoreCase("Asmita")).
		                 collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));	
		
		System.out.println("list \n"+collect4+"\n");
	
		System.out.println(age);
		
		

	}

}
