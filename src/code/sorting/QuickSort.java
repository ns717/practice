package code.sorting;

public class QuickSort {

	public static void main(String[] args) {
		int[] arr = new int[] { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		applyQuickSort(arr);
		for (int i : arr) {
			System.out.println(i);
		}
	}

	private static void applyQuickSort(int[] arr) {
		boolean isSorted = false;
		int lastUnsortedPoint = arr.length-1;
		while (!isSorted) {
			isSorted = true;
			for(int i=0; i<lastUnsortedPoint;i++) {
				if(arr[i]>arr[i+1]) {
					int temp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = temp;
					isSorted = false;
				}
			}
			lastUnsortedPoint--;
		}		
	}

}
