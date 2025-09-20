package com.so.leetcode;

import java.util.Stack;

/**
 *
 * 32. 最长有效括号
 *
 * @author FlyHippo
 * @version 1.0
 * @created 2025-05-21 16:15
 * @tag
 * @link <a href=""></a>
 **/
public class Q32_LongestValidParentheses {
    /**
     * 2. 从左往右扫描能解决一半问题
     *
     * 我们维护两个计数器：left = 左括号数，right = 右括号数。
     * 如果 left == right → 当前这一段是合法的。
     * 如果 right > left → 提前不合法（右括号太多），清零重新开始。
     * 👉 这样能找到所有“右括号没有超标”的最长串。
     * ⚠️ 但还有一种情况漏掉：左括号多余。
     * 例子 "(()"：
     * 从左到右：最后 left=2, right=1 → 没法更新。
     * 但实际答案是 2（最后两个括号 ()）。
     *
     *  3. 再来一遍从右往左
     *
     * 从右往左扫描时，同样维护 left 和 right，但逻辑对称：
     * 如果 left == right → 有效。
     * 如果 left > right → 左括号太多（因为我们是从右往左看），清零。
     * 👉 这样就能覆盖掉“左括号多余”的情况。
     * 在 "(()" 里，从右往左时，能找到长度为 2 的有效串。
     *
     *  4. 为什么“两遍结合”就覆盖所有情况？
     *
     * 第一遍（左→右）：能正确找出所有右括号不过量的最长合法段。
     * 第二遍（右→左）：能正确找出所有左括号不过量的最长合法段。
     * 二者结合，刚好涵盖了所有合法子串。
     *
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        int maxLen = 0, left = 0, right = 0;

        // 左->右
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') left++; else right++;
            if (left == right) maxLen = Math.max(maxLen, 2 * right);
            else if (right > left) left = right = 0;
        }

        // 右->左
        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') left++; else right++;
            if (left == right) maxLen = Math.max(maxLen, 2 * left);
            else if (left > right) left = right = 0;
        }
        return maxLen;
    }

}
