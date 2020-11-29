package com.leetcode.greddyalgorithms;
//给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。
//
// 若可行，输出任意可行的结果。若不可行，返回空字符串。
//
// 示例 1:
//
//
//输入: S = "aab"
//输出: "aba"
//
//
// 示例 2:
//
//
//输入: S = "aaab"
//输出: ""
//
//
// 注意:
//
//
// S 只包含小写字母并且长度在[1, 500]区间内。
//
// Related Topics 堆 贪心算法 排序 字符串
// 👍 146 👎 0

import java.util.Scanner;

public class q767_重构字符串 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入一个字符串:");
        String s = input.nextLine();
        System.out.println(s + "重构字符串结果是:" + reorganizeString(s));
    }


    public static String reorganizeString(String S) {

        return null;
    }
}
