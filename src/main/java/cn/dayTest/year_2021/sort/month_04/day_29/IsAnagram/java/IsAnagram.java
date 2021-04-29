package cn.dayTest.year_2021.sort.month_04.day_29.IsAnagram.java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IsAnagram {
    public static void main (String[] args) {
        boolean anagram = Solution.isAnagram("abc", "cba");
        System.out.println(anagram);
    }
}

class Solution {
    public static boolean isAnagram(String s, String t) {
        if (s.length()!=t.length()){
            return false;
        }
        char[] chars = s.toCharArray();
        char[] chars1 = t.toCharArray();
        Arrays.sort(chars);
        Arrays.sort(chars1);
        for (int i = 0; i < s.length(); i++) {
            if (chars[i]!=chars1[i]){
                return false;
            }
        }
        return true;
    }
}

class Solution1{
    public static boolean isAnagram(String s, String t) {
        int length=s.length();
        if (length!=t.length()) return false;
        Map<Character,Integer> map=new HashMap<>();
        char[] chars = s.toCharArray();
        char[] chars1 = t.toCharArray();
        for (char c:chars){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        for (char c:chars1){
            map.put(c,map.getOrDefault(c,0)-1);
            if (map.get(c)<0) return false;
        }
        return true;
    }
}
