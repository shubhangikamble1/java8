package com.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;

public class MapExample {
	public static void main(String[] args) {
		Map<Integer,String> map=new HashMap<Integer,String>();          
	     map.put(100,"Amit");    
	      map.put(101,"Vijay");    
	      map.put(102,"Rahul"); 
	      map.put(103, "Aniket");
	      map.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);
	      
	      Optional<Entry<Integer, String>> s=map.entrySet().stream().findFirst();
	      System.out.println(s);
	}

}
