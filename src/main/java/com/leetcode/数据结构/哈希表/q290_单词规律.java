package com.leetcode.数据结构.哈希表;
//给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
//
// 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
//
// 示例1:
//
// 输入: pattern = "abba", str = "dog cat cat dog"
//输出: true
//
// 示例 2:
//
// 输入:pattern = "abba", str = "dog cat cat fish"
//输出: false
//
// 示例 3:
//
// 输入: pattern = "aaaa", str = "dog cat cat dog"
//输出: false
//
// 示例 4:
//
// 输入: pattern = "abba", str = "dog dog dog dog"
//输出: false
//
// 说明:
//你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。
// Related Topics 哈希表
// 👍 229 👎 0

import java.util.HashMap;
import java.util.Map;

public class q290_单词规律 {

    public static void main(String[] args) {
        String pattern = "abba", str = "dog cat cat dog";
        boolean b = wordPattern(pattern, str);
        System.out.println("是否遵循相同规律:" + b);
    }

    public static boolean wordPattern(String pattern, String s) {
        int len = pattern.length();
        String[] arr = s.split(" ");

        if (len != arr.length) {
            return false;
        }
        Map<Character, String> map = new HashMap<>();

        for (int i = 0; i < len; i++) {
            if(map.containsKey(pattern.charAt(i))){
                if(!map.get(pattern.charAt(i)).equals(arr[i])){
                    return false;
                }
            }else{
                if(map.containsValue(arr[i])){
                    return false;
                }
                map.put(pattern.charAt(i),arr[i]);
            }

        }
        return true;
    }

}
