package com.yash;

import java.util.Map;
import java.util.stream.Collectors;

public class Occurence {
	public static void main(String[] args) {
		String str = "zaabbcccd";

	Map<Character, Long> collect = str.chars().mapToObj(c->(char)c).filter(ch->!Character.isWhitespace(ch))
	.collect(Collectors.groupingBy(ch->ch,Collectors.counting()));
		
		System.out.println(collect);
		char[] chq = str.toCharArray();

		for (int i = 0; i < str.length(); i++) {
			int count = 1;
			for (int j = i + 1; j < str.length(); j++) {
				if (chq[i] == chq[j]) {
					count++;
					chq[j] = 0;
				}
			}
			if (count > 0 && chq[i] != 0) {
				System.out.println(chq[i] + "=" + count);
			}

		}
		
	}

}
