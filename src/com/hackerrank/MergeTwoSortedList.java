package com.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MergeTwoSortedList {
	public static void main(String[] args) {
		List<Integer> list1 = Arrays.asList(1, 2, 4, 5, 6);
		List<Integer> list2 = Arrays.asList(1, 3, 5, 7, 8, 9);
		if (list1.size() >= list2.size()) {
			mergeList(list1, list2);
		} else {
			mergeList(list2, list1);
			Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		}		
		
	}

	private static List<Integer> mergeList(List<Integer> bigList, List<Integer> shortList) {
		List<Integer> resultList = new ArrayList<Integer>(shortList.size() + bigList.size());
		int shortListIndex = 0;
		int bigListIndex = 0;
		while (shortList.size() > shortListIndex) {
			int currentShort = shortList.get(shortListIndex);
			int currentBig = bigList.get(bigListIndex);
			if (currentShort < currentBig) {
				resultList.add(currentShort);
				shortListIndex++;
			} else {
				resultList.add(currentBig);
				bigListIndex++;
			}
		}
		while(bigList.size() > bigListIndex) {
			resultList.add(bigList.get(bigListIndex++));
		}
		return resultList;
	}

}
