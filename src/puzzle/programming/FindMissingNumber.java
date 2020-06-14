package puzzle.programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindMissingNumber {

	public static void main(String[] args) {

		// System.out.println(findMissingSingleNumber(Arrays.asList(1, 2, 4, 6, 3, 7,
		// 8)));
		System.out.println(findAllMissingNumbers(Arrays.asList(9, 2, 3, 3, 4, 4, 6, 8, 9)));
	}

	// find all missing numbers from given array
	// {1,2,3,3,4,4,6,8,9} should return 5,7
	private static List<Integer> findAllMissingNumbers(List<Integer> list) {
		List<Integer> tempList = new ArrayList<>();
		boolean[] visited = new boolean[list.size() + 1];

		for(int i : list) {
			visited[i] = true;
		}
		
		for (int i = 1; i < visited.length; i++) {
			if (visited[i] == false) {
				tempList.add(i);
			}
		}
		return tempList;
	}

	// find single missing numbers from given array
	// {1, 2, 4, 6, 3, 7, 8} should return 5
	private static int findMissingSingleNumber(List<Integer> list) {

		int sum = 0;
		int n = list.size() + 1;
		int total = (n) * (n + 1) / 2;
		for (int i : list) {
			total -= i;
		}

		return total;
	}

}
