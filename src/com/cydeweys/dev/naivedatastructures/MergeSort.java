package com.cydeweys.dev.naivedatastructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;


public class MergeSort {

	public static void main(String[] args) {
		List<Integer> one = Arrays.asList(1, 2, 4, 6, 10, 15, 19, 44);
		List<Integer> two = Arrays.asList(1, 3, 7, 11, 17, 22, 31, 101);
		System.out.println("Simple merge: " + StringUtils.join(MergeTwoSortedLists(one, two), ", "));
		
		List<Integer> unsorted = Arrays.asList(6, 1, 72, 24, 12, 67, 17, 6, 79, 753, 822, 255, -5, -2, 246);
		System.out.println("Merge sort: " + StringUtils.join(RunMergeSort(unsorted), ", "));
	}
	
	public static List<Integer> RunMergeSort(List<Integer> list) {
		List<List<Integer>> merges = new ArrayList<List<Integer>>();
		for (int i : list) {
			merges.add(Arrays.asList(i));
		}
		while (merges.size() > 1) {
			List<List<Integer>> newMerges = new ArrayList<List<Integer>>();
			for (int i = 0; i < merges.size(); i += 2) {
				if (i == merges.size() - 1) {
					newMerges.add(merges.get(i));
				}
				else {
					newMerges.add(MergeTwoSortedLists(merges.get(i), merges.get(i + 1)));
				}
			}
			merges = newMerges;
		}
		return merges.get(0);
	}

	public static List<Integer> MergeTwoSortedLists(List<Integer> one, List<Integer> two) {
		List<Integer> mergedList = new ArrayList<Integer>();
		int i1 = 0, i2 = 0, s1 = one.size(), s2 = two.size();
		while (i1 < s1 || i2 < s2) {
			if (i1 < s1 && i2 < s2) {
				if (one.get(i1) < two.get(i2)) {
					mergedList.add(one.get(i1++));
				}
				else {
					mergedList.add(two.get(i2++));
				}
			}
			else if (i1 < s1) {
				mergedList.add(one.get(i1++));
			}
			else if (i2 < s2) {
				mergedList.add(two.get(i2++));
			}
		}
		return mergedList;
	}
}
