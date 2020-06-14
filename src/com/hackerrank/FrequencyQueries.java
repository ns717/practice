package com.hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

// solution of hackerRank hashMap puzzle
//https://www.hackerrank.com/challenges/frequency-queries/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps
public class FrequencyQueries {

	// Complete the freqQuery function below.
	static List<Integer> freqQuery(List<List<Integer>> queries) {
		List<Integer> answerList = new ArrayList<Integer>();
		Map<Integer, Integer> map = new HashMap<>();
		Map<Integer, Integer> frequncyMap = new HashMap<>();

		for (List<Integer> list : queries) {
			int operation = list.get(0);
			int key = list.get(1);
			if (operation == 1) { // insert
				if (map.containsKey(key)) {
					map.put(key, 1 + map.get(key));
				} else {
					map.put(key, 1);
				}
				addUpdateFrequency(frequncyMap, map.get(key));
				removeUpdateFrequency(frequncyMap, map.get(key) - 1);
			} else if (operation == 2) {// delete
				if (map.containsKey(key)) {
					int value = map.get(key);
					if (value > 1) {
						map.put(key, value-1);
					} else {
						map.remove(key);
					}
					addUpdateFrequency(frequncyMap, value-1);
					removeUpdateFrequency(frequncyMap, value);
				}
			} else if (operation == 3) {// get count
				if (frequncyMap.containsKey(key)) {
					answerList.add(1);
				} else {
					answerList.add(0);
				}
			}
		}
		return answerList;
	}

	static void addUpdateFrequency(Map<Integer, Integer> frequencyMap, int key) {
		// add updated frquency
		if (frequencyMap.containsKey(key)) {
			frequencyMap.put(key, frequencyMap.get(key) + 1);
		} else {
			if(key>0) {
				frequencyMap.put(key, 1);
			}			
		}
	}

	static void removeUpdateFrequency(Map<Integer, Integer> frequencyMap, int key) {
		if (frequencyMap.containsKey(key)) {
			if (frequencyMap.get(key) > 1) {
				frequencyMap.put(key, frequencyMap.get(key) - 1);
			} else {
				frequencyMap.remove(key);
			}
		}

	}

	public static void main(String[] args) throws IOException {

		List<List<Integer>> list = Arrays.asList(Arrays.asList(3, 4), // 0
				Arrays.asList(2, 16), Arrays.asList(1, 16), Arrays.asList(1, 16), Arrays.asList(1, 16),
				Arrays.asList(3, 3), // 1
				Arrays.asList(2, 16), Arrays.asList(2, 16), Arrays.asList(2, 16), Arrays.asList(3, 3)// 0
		);
		List<Integer> ans = freqQuery(list);

		ans.forEach(System.out::println);
	}

}
