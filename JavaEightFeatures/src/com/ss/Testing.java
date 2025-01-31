package com.ss;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Testing  {

static Long getPalindrome(String str) {
		
		return str.chars()
        .boxed()
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
        .values()
        .stream()
        .filter(count -> count % 2 != 0)
        .count();
		}

	public static void main(String[] args) {
		
		
		List<Student> studentList = new ArrayList<Student>();
		studentList.add(new Student("Naresh", 29, "PVKK"));
		studentList.add(new Student("Lokesh", 28, "ALTS"));
		studentList.add(new Student("Radha", 29, "RGM"));
		studentList.add(new Student("Nanda", 2, "PVKK"));
		studentList.add(new Student("Nandaa", 3, "PVKK"));
		studentList.add(new Student("Nandaaaaa", 33, "PVKK"));
		
		//prints studentList
		studentList.stream().forEach(System.out::println);
		
		//filter student age gretaer than 28
		List<Integer> studentAGeFilter = studentList.stream().filter(student -> student.getAge() > 28).map(Student::getAge).collect(Collectors.toList());
		System.out.println("studentAGeFilter::"+studentAGeFilter);
		
		//sort the list using age
		List<Student> SortStudent = studentList.stream().sorted(Comparator.comparing(Student::getAge)).collect(Collectors.toList());
		System.out.println("SortStudent::"+SortStudent);
		
		//group the age and display names
		Map<Integer, List<String>> groupNames = studentList.stream().collect(Collectors.groupingBy(Student::getAge,Collectors.mapping(Student::getName, Collectors.toList())));
		System.out.println("groupNames::"+groupNames);
		
		//group college and get average age of student
		Map<String, Double> averageAge = studentList.stream().collect(Collectors.groupingBy(Student::getCollege,Collectors.averagingDouble(Student::getAge)));
		System.out.println("averageAge::"+averageAge);
		
		//group college and get max age of student
		 Map<String, Optional<Student>> maxStudent = studentList.stream()
				 .collect(Collectors.groupingBy(Student::getCollege,Collectors.maxBy(Comparator.comparing(Student::getAge))));
		System.out.println("maxStudent::"+maxStudent);
		
		//second highest age
		Entry<Integer, List<String>> entry = studentList.stream().collect(Collectors.groupingBy(Student::getAge,Collectors.mapping(Student::getName, Collectors.toList())))
		.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByKey())).collect(Collectors.toList()).get(1);
		System.out.println("entry::"+entry);
		
			//highest frequency
			String msg = "lokkkkkeeeshhhhhh";
			String words = "Hello Hello Naresh Naresh welcome";
			
			
			List<String> msgList = Arrays.asList(msg.split(""));
			Entry<String, Long> msgHighFrequency = msgList.stream()
					.collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
					.collect(Collectors.maxBy(Map.Entry.comparingByValue())).get();
			System.out.println("msgHighFrequency::"+msgHighFrequency);
			
			
			
			Map<Integer, String> customers = new HashMap<>();
			customers.put(1, "Jhon");
			customers.put(2, "Smith");
			customers.put(3, "Sally");
			
			//iterate map
			customers.forEach((id,name)->
			  {
				 System.out.println("key::"+id +" value::"+name); 
			  });
			  customers.entrySet().stream().forEach(e ->
			  {
				  System.out.println("key::"+e.getKey() +" value::"+e.getValue());
			  });
			  
			  //sort map
			  customers.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(System.out::println);

			  
			//remove duplicates numbers in the list 
			   List<Integer> duplicateNumbers = Arrays.asList(11,11,12,12,33,34,35,35);
			   List<Integer> duplicateValues = duplicateNumbers.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
			   					.entrySet().stream().filter(m -> m.getValue() > 1).map(Map.Entry::getKey).collect(Collectors.toList());
			   System.out.println("duplicateValues::"+duplicateValues);
			   
			   //highest lenth string among words
			   List<String> listString = Arrays.asList("sss","ddddd","wwwwwwwwwww","aaaaaaa");
				String string = listString.stream().reduce((word1,word2)-> word1.length() > word2.length()?word1:word2).get();
				System.out.println(string);
				
				
			   List<Integer> list = Arrays.asList(1,6,4,1,2,2,7,8,4);
				System.out.println("distinct::"+list.stream().filter(i -> i>4 && i%2==0).sorted(Collections.reverseOrder()).distinct().toList());
				
				//Reverse of String
				String str = "Naresh Radha Nandu";
				
				String reverseStr = Stream.of(str)
		                .map(br -> new StringBuilder(br).reverse())
		                .collect(Collectors.joining());
				System.out.println("reversed String ::"+reverseStr);
				
					//palindrome in list	
				List<String> palindromes = Arrays.asList("naresh","noon","radar","madam");
				List<String> plist = palindromes.stream().filter(p -> getPalindrome(p) <=1).collect(Collectors.toList());
				System.out.println(plist);
				
				//contains letter in string
				List<String> containsLetter = palindromes.stream().filter(i -> i.contains("n")).collect(Collectors.toList());
				System.out.println(containsLetter);
		
			
			// nth highest salary	
				Map<String,Integer> empMap = new HashMap<>();
				empMap.put("Jhon",1200);
				empMap.put("Smith",1300);
				empMap.put("Sally",1300);
				empMap.put("Jhon1",1200);
				empMap.put("Smith2",3300);
				empMap.put("Sally3",2400);
				
				
				 Entry<Integer, List<String>> nhighest = empMap.entrySet().stream()
				.collect(Collectors.groupingBy(Map.Entry::getValue,Collectors.mapping(Map.Entry::getKey, Collectors.toList())))
				.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByKey())).collect(Collectors.toList()).get(2);
				
				System.out.println("nhighest::"+nhighest);
				
				// skip and limit
				List<Integer> numberList = Arrays.asList(1,2,3,4,5,6,7,8,9);
				numberList.stream().skip(1).limit(3).forEach(System.out::println);
				
				// occurence in string
				String inputMessage = "ilovejavacoding";
				
				Entry<String, Long> highOccurence = Arrays.stream(inputMessage.split(""))
				.collect(Collectors.groupingBy(Function.identity(),Collectors.counting())).entrySet().stream().collect(Collectors.maxBy(Map.Entry.comparingByValue())).get();
				
				System.out.println("highOccurence::"+highOccurence);
				
				//print duplicates from string
				List<String> duplicateElements = Arrays.stream(inputMessage.split(""))
				.collect(Collectors.groupingBy(Function.identity(),Collectors.counting())).entrySet().stream()
				.filter(s -> s.getValue() > 1).map(Map.Entry::getKey).collect(Collectors.toList());
				System.out.println("duplicateElements::"+duplicateElements);
				
				//firtst non repeat element
				
				String nonRepeat = Arrays.stream(inputMessage.split(""))
				.collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new, Collectors.counting())).entrySet().stream()
				.filter(s -> s.getValue() ==1)
				.findFirst().get().getKey();
				System.out.println("nonRepeat::"+nonRepeat);
				
				//second highest number
				List<Integer> numbersList = Arrays.asList(2,5,1,5,9,10,11,20);
				Integer secondNumber = numbersList.stream().sorted(Collections.reverseOrder())
				.skip(1).findFirst().get();
				System.out.println("secondNumber::"+secondNumber);
				
				// print starts with 1
				List<String> startWithOne = numbersList.stream().map(s -> s+"").filter(s-> s.startsWith("1")).collect(Collectors.toList());
				System.out.println("startWithOne::"+startWithOne);
				
	}

	

	
}