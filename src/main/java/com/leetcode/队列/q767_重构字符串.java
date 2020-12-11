package com.leetcode.队列;
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

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class q767_重构字符串 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入一个字符串:");
        String s = input.nextLine();
        System.out.println(s + "重构字符串结果是:" + reorganizeString(s));
    }


    public static String reorganizeString(String S) {
        if (S.length() < 2) return S;

        char[] chars = S.toCharArray();
        int len = chars.length;

        int[] counts = new int[26];
        int maxCount = 0;

        // 1. 字母出现次数不能超过 (len+1)/2
        for (int i = 0; i < len; i++) {
            char ch = chars[i];
            counts[ch - 'a']++;
            maxCount = Math.max(maxCount, counts[ch - 'a']);
        }

        if (maxCount > (len + 1) / 2) {
            return "";
        }

        // 2. 出现的字母放入队列（出现次数倒序）
        PriorityQueue<Character> queue = new PriorityQueue<>(Comparator.comparingInt(c -> counts[(char) c - 'a']).reversed()); //默认升序

        for (char c = 'a'; c <= 'z'; c++) {
            if (counts[c - 'a'] > 0) {
                queue.offer(c);
            }
        }

        // 3. 遍历队列依次拼接
        StringBuilder sb = new StringBuilder();
        while (queue.size() > 1) {
            char c1 = queue.poll();
            char c2 = queue.poll();
            sb.append(c1).append(c2);

            if (--counts[c1 - 'a'] > 0) {
                queue.offer(c1);
            }

            if (--counts[c2 - 'a'] > 0) {
                queue.offer(c2);
            }
        }

        if (queue.size() > 0) {
            sb.append(queue.poll());
        }
        return sb.toString();
    }
}
