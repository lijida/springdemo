package com.demo.lamda;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class StreamTest {
	public static void main(String[] args) {
		List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
		List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
		
		filtered.forEach(System.out::println);
		
		// 获取空字符串的数量
		long count = strings.parallelStream().filter(a -> a.isEmpty()).count();

		long conut2=strings.parallelStream().count();
		
		System.out.println(count);
		
		Random random = new Random(5);
		random.ints().limit(10).sorted().forEach(System.out::println);
		
		List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
		 
		IntSummaryStatistics stats = numbers.stream().mapToInt((x) -> x).summaryStatistics();

		System.out.println("列表中最大的数 : " + stats.getMax());
		System.out.println("列表中最小的数 : " + stats.getMin());
		System.out.println("所有数之和 : " + stats.getSum());
		System.out.println("平均数 : " + stats.getAverage());
		
		String aString="a";
		String bString="b";
		System.out.println(aString+bString);
				
		
	}
}
