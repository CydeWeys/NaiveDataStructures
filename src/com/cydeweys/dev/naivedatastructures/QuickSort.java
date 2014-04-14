package com.cydeweys.dev.naivedatastructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class QuickSort {

	public static void main(String[] args) {
		List<Integer> unsorted = Arrays.asList(6, 1, 72, 24, 12, 67, 17, 6, 79, 753, 822, 255, -5, -2, 246);
		System.out.println("Quicksort: " + StringUtils.join(Quicksort(unsorted), ", "));
	}
	
	public static List<Integer> Quicksort(List<Integer> list) {
		if (list.size() <= 1) {
			return list;
		}
		else {
			int pivot = list.get(list.size() - 1);
			List<Integer> lesser = new ArrayList<Integer>();
			List<Integer> greater = new ArrayList<Integer>();
			for (int i = 0; i < list.size() - 1; i++) {
				int curr = list.get(i);
				if (curr <= pivot) {
					lesser.add(curr);
				}
				else {
					greater.add(curr);
				}
			}
			List<Integer> sorted = new ArrayList<Integer>();
			sorted.addAll(Quicksort(lesser));
			sorted.add(pivot);
			sorted.addAll(Quicksort(greater));
			return sorted;
		}
	}
}
