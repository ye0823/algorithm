/*
 * https://leetcode.com/problems/find-k-th-smallest-pair-distance/
*/
package leetCode;

import java.util.Arrays;

public class Number719 {
	public static void main(String[] args) {
		int[] nums = {1,3,1};
		int k = 1;
		System.out.println(new Number719().smallestDistancePair(nums, k));
	}
	public int smallestDistancePair(int[] nums, int k) {
		Arrays.sort(nums);
		int high = nums[nums.length - 1] - nums[0];
		int low = 0;
		while (low < high) {
			int mid = (high + low) / 2;
			if (get(nums, k, mid) >= k) {
				high = mid;
			} else {
				low = mid + 1;
			}
		}
		return low;
	}

	private int get(int[] nums, int k, int midVal) {
		int cnt = 0;
		int len = nums.length;
		for (int leftIdx = 0; leftIdx < len; leftIdx++) {
			for (int rightIdx = leftIdx + 1; rightIdx < len; rightIdx++) {
				int val = nums[rightIdx] - nums[leftIdx];
				if (midVal >= val) {
					cnt++;
				} else {
					break;
				}
			}
		}
		return cnt;
	}
}
