package com.leetcode.贪心算法;

//给定一个非负整数 N，找出小于或等于 N 的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。
//
// （当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。）
//
// 示例 1:
//
// 输入: N = 10
//输出: 9
//
//
// 示例 2:
//
// 输入: N = 1234
//输出: 1234
//
//
// 示例 3:
//
// 输入: N = 332
//输出: 299
//
//
// 说明: N 是在 [0, 10^9] 范围内的一个整数。
// Related Topics 贪心算法
// 👍 91 👎 0
public class q738_单调递增数字 {

    public static void main(String[] args) {
        int N = 332;
        int ans = monotoneIncreasingDigits(N);
        System.out.println("单调递增:"+ans);
    }

    public static int monotoneIncreasingDigits(int N) {
        char[] strN = Integer.toString(N).toCharArray();
        int flag = strN.length;
        for (int i = strN.length - 1; i > 0; i--) {
            if (strN[i - 1] > strN[i]) {
                strN[i - 1]--;
                flag = i;
            }
        }

        for (int i = flag; i < strN.length; i++) {
            strN[i]='9';
        }
        return Integer.parseInt(new String(strN));
    }
}
