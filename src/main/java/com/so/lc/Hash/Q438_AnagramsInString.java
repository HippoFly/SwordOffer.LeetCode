package com.so.lc.Hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 描述
 *
 * @author FlyHippo
 * @version 1.0
 * @createDate 2024/5/1 16:07
 **/

public class Q438_AnagramsInString {
    public static List<Integer> findAnagrams(String sample, String target) {
        int sampleLen = sample.length(), targetLen = target.length();

        if (sampleLen < targetLen) {
            return new ArrayList<Integer>();
        }

        List<Integer> ans = new ArrayList<Integer>();
        int[] sampleHash = new int[26];
        int[] targetHash = new int[26];
        for (int i = 0; i < targetLen; ++i) {
            ++sampleHash[sample.charAt(i) - 'a'];
            ++targetHash[target.charAt(i) - 'a'];
        }
        // 已经初始化target对应，可以比较第一位，符合加序列0
        if (Arrays.equals(sampleHash, targetHash)) {
            ans.add(0);
        }

        for (int i = 0; i < sampleLen - targetLen; ++i) {
            --sampleHash[sample.charAt(i) - 'a']; // 窗口左字符移除Hash数列统计
            ++sampleHash[sample.charAt(i + targetLen) - 'a']; //窗口右字符加入Hash统计

            // 由于此题要求完全同长度，不是求最短包含子串，所以每窗口移动一位就可以比较
            if (Arrays.equals(sampleHash, targetHash)) {
                ans.add(i + 1);
            }
        }

        return ans;
    }



    public static String  hash(String str){
        int[] hashArr = new int[26];
        for (int i = 0; i < str.length(); i++) {
            hashArr[(str.charAt(i)-'a')]++;
        }
        return Arrays.toString(hashArr);
    }

    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd","abc"));
    }
}
