package com.leetcode.滑动窗口;

//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
//
//
//
// 示例 1:
//
//
//输入: s = "abcabcbb"
//输出: 3
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
//
//
// 示例 2:
//
//
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
//
//
// 示例 3:
//
//
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
//
//
// 示例 4:
//
//
//输入: s = ""
//输出: 0
//
//
//
//
// 提示：
//
//
// 0 <= s.length <= 5 * 104
// s 由英文字母、数字、符号和空格组成
//
// Related Topics 哈希表 双指针 字符串 Sliding Window
// 👍 4639 👎 0

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class q3_无重复字符的最长子串 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入一个字符串:");
        String s = input.nextLine();
        System.out.println(s + "无重复字符的最长子串的长度是:" + lengthOfLongestSubstring(s));
    }

    /**
     *
     * @param s  abcabcbb
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<Character>();
        int max = 0, rk = -1, len = s.length();
        for (int i = 0; i < len; i++) {
            if (i >= 1) {
                set.remove(s.charAt(i - 1));
            }
            while (rk + 1 < len && !set.contains(s.charAt(rk + 1))) {
                set.add(s.charAt(rk + 1));
                rk++;
            }
            max = Math.max(max, rk - i + 1);
        }
        return max;
    }
}
