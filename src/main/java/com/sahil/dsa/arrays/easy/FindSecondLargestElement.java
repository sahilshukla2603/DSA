package com.sahil.dsa.arrays.easy;

import java.util.Arrays;
import java.util.Collections;

/**
 * 
 * Given an array of integers, our task is to write a program that efficiently
 * finds the second-largest element present in the array.
 * 
 * Examples:
 * 
 * Input: arr[] = {12, 35, 1, 10, 34, 1}
 * Output: The second largest element is 34.
 * Explanation: The largest element of the array is 35 and the second largest
 * element is 34
 * 
 * Input: arr[] = {10, 5, 10}
 * Output: The second largest element is 5.
 * Explanation: The largest element of the array is 10 and the second largest
 * element is 5
 * 
 * Input: arr[] = {10, 10, 10}
 * Output: The second largest does not exist.
 * Explanation: Largest element of the array is 10 there is no second largest
 * element
 * 
 * 
 * 
 */
public class FindSecondLargestElement {

	public static void main(String[] args) {
		Integer[] arr = { 1, 5, 6, 8, 9, 6, 3, 2, 0, 7 };
		// Multiple methods have been created
		findSecondLargestElement1(arr);
		findSecondLargestElement2(arr);
		findSecondLargestElement3(arr);
	}

	// First approach using sorting
	// Time complexity => O(nlog(n))
	// Space complexity => O(n) (Because it is using an Integer array rather than
	// primitive array)
	private static void findSecondLargestElement1(Integer[] arr) {
		if (arr.length < 2) {
			throw new IllegalArgumentException("The array's length should be greate than or equal to 2");
		}
		Arrays.sort(arr, Collections.reverseOrder());
		int max = arr[0];
		for (int i : arr) {
			if (i < max) {
				System.out.println("The second largest element using sorting :" + i);
				break;
			}
		}
	}

	/**
	 * Second approach using two pass
	 * Time complexity => O(n) (even though we are using two loops ultimately time
	 * complexity will be O(n) only.
	 * Space complexity => O(1) (Nothing is stored)
	 */

	private static void findSecondLargestElement2(Integer[] arr) {
		if (arr.length < 2) {
			throw new IllegalArgumentException("The array's length should be greate than or equal to 2");
		}
		int max = Integer.MIN_VALUE;
		for (int i : arr) {
			if (i > max) {
				max = i;
			}
		}
		int secondMax = Integer.MIN_VALUE;
		for (int i : arr) {
			if (i != max) {
				secondMax = Math.max(i, secondMax);
			}
		}
		if (secondMax == Integer.MIN_VALUE) {
			System.out.println("There's no second max value");
		} else {
			System.out.println("The second largest element using two pass is :" + secondMax);
		}
	}

	/**
	 * Third approach using two pass
	 * Time complexity => O(n)
	 * Space complexity => O(1) (Nothing is stored)
	 */
	private static void findSecondLargestElement3(Integer[] arr) {
		if (arr.length < 2) {
			throw new IllegalArgumentException("The array's length should be greate than or equal to 2");
		}
		int max = Integer.MIN_VALUE;
		int secondMax = Integer.MIN_VALUE;
		for (int i : arr) {
			if (i > max) {
				secondMax = max;
				max = i;
			} else if (i > secondMax && i != max) {
				secondMax = i;
			}
		}
		if (secondMax != max) {
			System.out.println("The second max element from single pass is :" + secondMax);
		} else {
			System.out.println("There's no second max element in the array");
		}

	}

}
