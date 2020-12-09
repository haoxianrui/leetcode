package com.leetcode.二分法;


//给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
//
// 你可以假设数组中无重复元素。
//
// 示例 1:
//
// 输入: [1,3,5,6], 5
//输出: 2
//
//
// 示例 2:
//
// 输入: [1,3,5,6], 2
//输出: 1
//
//
// 示例 3:
//
// 输入: [1,3,5,6], 7
//输出: 4
//
//
// 示例 4:
//
// 输入: [1,3,5,6], 0
//输出: 0
//
// Related Topics 数组 二分查找
// 👍 756 👎 0

import java.util.Arrays;
import java.util.Scanner;

public class q35_搜索插入位置 {


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("请输入一组从小到大的数字，使用空格分割:");

        String[] strArr = input.nextLine().split("\\s+");
        int[] intArr = Arrays.stream(strArr).mapToInt(Integer::valueOf).toArray();

        int i = searchInsert2(intArr, 5);

        System.out.println("插入位置:" + i);
    }


    public static int searchInsert1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }
        return nums.length;
    }


    public static int searchInsert2(int[] nums, int target) {

        if (nums[nums.length - 1] < target) {
            return nums.length;
        }

        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
