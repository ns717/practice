package com.hackersearth;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Esko {

	private static final Scanner scanner = new Scanner(System.in);
	static Map<String, String> valueTableWithVars = new HashMap<>();
	private static String lowestUnit;

	public static void main(String[] args) {

		String[] names = scanner.nextLine().split(",");
		for (int tItr = 0; tItr < names.length - 1; tItr++) {
			String[] i = scanner.nextLine().split("=");
			String name = i[0];
			String value = i[1];
			valueTableWithVars.put(name.trim(), value.trim());			
		}
		scanner.close();

		Map<String, Integer> valueTableWithValueOnly = replaceVarWithTheirValues(names);
		Map<String, Integer> sortedMap = sortMapOnBasisOfValue(valueTableWithValueOnly);
		PrintAsPerNeed(sortedMap, names.length);
	}

	private static void PrintAsPerNeed(Map<String, Integer> sortedMap, int n) {

		int maxValue = sortedMap.entrySet().iterator().next().getValue();
		Iterator<Entry<String, Integer>> itr = sortedMap.entrySet().iterator();
		String str = "";
		while (itr.hasNext()) {
			Entry<String, Integer> entry = itr.next();
			str += maxValue / entry.getValue();
			str += entry.getKey();
			if (itr.hasNext()) {
				str += " = ";
			}
		}
		System.out.println(str);
	}

	private static Map<String, Integer> sortMapOnBasisOfValue(Map<String, Integer> valueTableWithValueOnly) {
		Map<String, Integer> sortedMap = new LinkedHashMap<>();

		valueTableWithValueOnly.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
				.forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));
		return sortedMap;
	}

	private static Map<String, Integer> replaceVarWithTheirValues(String[] names) {
		Map<String, Integer> sortedValueTable = new HashMap<>();
		for (String name : names) {
			int val = getValue(name);
			sortedValueTable.put(name, val);
		}
		return sortedValueTable;
	}

	private static int getValue(String name) {

		if (!valueTableWithVars.containsKey(name)) {
			lowestUnit = name;
			return 1;
		}

		String[] arr = valueTableWithVars.get(name).split(" ");
		int val = Integer.parseInt(arr[0]) * getValue(arr[1]);

		return val;
	}
}
