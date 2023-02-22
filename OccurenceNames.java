package com.yash.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class OccurenceNames {
	public static void main(String[] args) {
		
		  
		 List<String> names = new ArrayList<>();
		 
		 names.add("anm");
		 names.add("a"); 
		 names.add("an");
		 names.add("anm");
		 names.add("an"); names.add("anm"); names.add("an");
		 
		 List<String> words = Arrays.asList("hello", "hello", "mighty","shubhra","Shubhra");
		 
		 Map<String, Long> collect = words.stream().map(String::toLowerCase).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		 System.out.println(collect);
		 
		 Map<String, Long> wordOcuurence = names.stream().
				                         collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		 
		 	System.out.println(wordOcuurence);
	}
}
