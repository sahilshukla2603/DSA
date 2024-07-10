package com.sahil.dsa.arrays.easy;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 
 * Move all zeroes to end of array
 * 
 * Given an array of random numbers, Push all the zero’s of a given array to the
 * end of the array. For example, if the given arrays is {1, 9, 8, 4, 0, 0, 2,
 * 7, 0, 6, 0}, it should be changed to {1, 9, 8, 4, 2, 7, 6, 0, 0, 0, 0}. The
 * order of all other elements should be same.
 * Expected time complexity is O(n)
 * and extra space is O(1).
 * 
 * Example:
 * 
 * Input : arr[] = {1, 2, 0, 4, 3, 0, 5, 0};
 * Output : arr[] = {1, 2, 4, 3, 5, 0, 0, 0};
 * 
 * Input : arr[] = {1, 2, 0, 0, 0, 3, 6};
 * Output : arr[] = {1, 2, 3, 6, 0, 0, 0};
 */
public class MoveAllZeroesToEnd {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 0, 5, 0, 7, 8, 9, 0, 0 };
		// Two different approaches

		// Naive approach 1
		System.out.println(Arrays.stream(moveAllZeroesToEnd1(arr)).boxed().collect(Collectors.toList()));

		// optimized approach 2
		arr = new int[] { 1, 2, 3, 0, 5, 0, 7, 8, 9, 0, 0 };
		System.out.println(Arrays.stream(moveAllZeroesToEnd2(arr)).boxed().collect(Collectors.toList()));
	}

	/**
	 * Naive approach by using two pointers
	 * 
	 * @param arr
	 * @return
	 */
	private static int[] moveAllZeroesToEnd1(int[] arr) {
		if (arr.length == 0) {
			throw new IllegalArgumentException("The array can't be empty");
		}
		if (arr.length == 1) {
			return arr;
		}
		int first = 0;
		int second = 1;

		while (second < arr.length && first < arr.length) {
			if (arr[first] == 0) {
				if (arr[second] == 0) {
					second++;
					continue;
				}
				arr[first] = arr[second];
				arr[second] = 0;
			}
			first++;
			second++;
		}
		return arr;
	}

	/**
	 * Optimized approach without using two pointers
	 */
	private static int[] moveAllZeroesToEnd2(int[] arr) {
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {
				arr[count++] = arr[i];
			}
		}
		while (count < arr.length) {
			arr[count++] = 0;
		}
		return arr;
	}

}
