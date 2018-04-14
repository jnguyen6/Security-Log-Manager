package edu.ncsu.csc316.security_log.util;

import java.util.Comparator;
import java.util.Arrays;

/**
 * Class that sorts a list of elements. This sorter class is reused from the
 * Sorter class from CSC316 projects 1 and 3.
 * 
 * @author Jimmy Nguyen
 * @param <E> the generic element type
 */
public class Sorter<E> {

	/**
	 * Sorts the given collection using the merge sort algorithm. Note that the merge sort 
	 * algorithm is referenced from the algorithm provided in the Dictionary lecture slides
	 * on page 33 by instructor Jason King. The algorithm is also referenced on page 538 
	 * from the Data Structures and Algorithm textbook by Michael T. Goodrich, Roberto 
	 * Tamassia, and Michael H. Goldwasser.
	 * 
	 * @param list the list to sort
	 * @param c the Comparator used to help determine how each element in the list will be
	 * sorted
	 * @param <E> the generic element type
	 */
	public static <E> void mergeSort(E[] list, Comparator<E> c) {
		int n = list.length;
		if (n > 1) {
			int midVal = n / 2;
			E[] list1 = Arrays.copyOfRange(list, 0, midVal);
			E[] list2 = Arrays.copyOfRange(list, midVal, n);
			mergeSort(list1, c);
			mergeSort(list2, c);
			merge(list1, list2, list, c);
		} 
	}
	
	/**
	 * Merges the two newly created array lists with the original array list. Note that the
	 * merge algorithm is referenced from the algorithm provided in the Dictionary lecture
	 * slides on page 33 by instructor Jason King. The algorithm is also referenced on page 
	 * 537 from the Data Structures and Algorithm textbook by Michael T. Goodrich, Roberto 
	 * Tamassia, and Michael H. Goldwasser.
	 * 
	 * @param list1 the first list to merge
	 * @param list2 the second list to merge
	 * @param list the original list
	 * @param c the Comparator used to help determine how each element in the list will be
	 * sorted
	 * @param <E> the generic element type
	 */
	public static <E> void merge(E[] list1, E[] list2, E[] list, Comparator<E> c) {
		int lIndex = 0;
		int rIndex = 0;
		while (lIndex + rIndex < list.length) {
			if (rIndex == list2.length || (lIndex < list1.length && c.compare(list1[lIndex], list2[rIndex]) <= 0)) {
			    list[lIndex + rIndex] = list1[lIndex];
			    lIndex++;
			} else {
				list[lIndex + rIndex] = list2[rIndex];
				rIndex++;
			}
		}
	}
}
