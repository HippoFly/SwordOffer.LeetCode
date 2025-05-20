package com.so.lc.leetcode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 139. 单词拆分
 *
 * @author FlyHippo
 * @version 1.0
 * @created 2025-05-17 16:07
 * @tag
 * @link <a href=""></a>
 **/
public class Q139_WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        // 用 Set 提高查找效率
        Set<String> wordSet = new HashSet<>(wordDict);
        int n = s.length();
        // dp[i] 表示：s 的前 i 个字符（即 s[0..i-1]）是否可以由字典中的单词拼接出来
        boolean[] dp = new boolean[n + 1];
        dp[0] = true; // 空字符串可被拆分

        // n是单词长度，
        // 我们一个字符一个字符地考察 s 的前缀（即 s[0..i-1]），看看「前 i 个字符是否能拆成若干个字典单词」
        for (int i = 1; i <= n; i++) {
            //
            for (int j = 0; j < i; j++) {
                // dp[j] == true：说明 s[0..j-1] 这一段已经可以成功拆分了
                // s.substring(j, i)：从 j 到 i 的子串（也就是 s[j..i-1]）是否是一个单词？
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }
}
