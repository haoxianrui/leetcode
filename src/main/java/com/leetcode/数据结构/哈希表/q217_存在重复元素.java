package com.leetcode.数据结构.哈希表;

//给定一个整数数组，判断是否存在重复元素。
//
// 如果任意一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
//
//
//
// 示例 1:
//
// 输入: [1,2,3,1]
//输出: true
//
// 示例 2:
//
// 输入: [1,2,3,4]
//输出: false
//
// 示例 3:
//
// 输入: [1,1,1,3,3,4,3,2,4,2]
//输出: true
// Related Topics 数组 哈希表
// 👍 321 👎 0

import java.util.HashSet;

public class q217_存在重复元素 {

    public static void main(String[] args) {

        int[] nums = new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2};

        boolean ans = containsDuplicate_哈希表(nums);

        System.out.println("是否存在重复元素：" + ans);

    }

    public static boolean containsDuplicate_数组(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = i; i < len - 1; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean containsDuplicate_哈希表(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            } else {
                set.add(nums[i]);
            }
        }
        return false;
    }
}
