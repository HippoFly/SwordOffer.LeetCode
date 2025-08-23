package com.so.leetcode;

import java.util.Arrays;

/**
 *
 * 455. 分发饼干
 *
 * 对每个孩子 i，都有一个胃口值 g[i]，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j，都有一个尺寸 s[j] 。如果 s[j] >= g[i]，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是满足尽可能多的孩子，并输出这个最大数值。
 *
 *
 * 示例 1:
 *
 * 输入: g = [1,2,3], s = [1,1]
 * 输出: 1
 * 解释:
 * 你有三个孩子和两块小饼干，3 个孩子的胃口值分别是：1,2,3。
 * 虽然你有两块小饼干，由于他们的尺寸都是 1，你只能让胃口值是 1 的孩子满足。
 * 所以你应该输出 1。
 *
 * 示例 2:
 *
 * 输入: g = [1,2], s = [1,2,3]
 * 输出: 2
 * 解释:
 * 你有两个孩子和三块小饼干，2 个孩子的胃口值分别是 1,2。
 * 你拥有的饼干数量和尺寸都足以让所有孩子满足。
 * 所以你应该输出 2。
 *
 * @author FlyHippo
 * @version 1.0
 * @created 2025-05-26 09:56
 * @tag
 * @link <a href=""></a>
 **/
public class Q455_AssignCookies {
    public static int findContentChildren(int[] g, int[] s) {
        // 1. 排序孩子的胃口和饼干的尺寸
        Arrays.sort(g); // 孩子胃口升序
        Arrays.sort(s); // 饼干尺寸升序

        // child：表示当前要满足的孩子索引，从第一个孩子开始（索引为0）。
        // cookie：表示当前尝试分配的饼干索引，从第一块饼干开始（索引为0）。
        int child = 0, cookie = 0;
        // 用来记录已经满足的孩子数量
        int count = 0;

        // 2. 双指针遍历
        // while循环中， 饼干数组元素从小到大，每次饼干数组递增，每次
        // 一旦有一个饼干满足胃口，则儿童数组++（同时计数++）
        while (child < g.length && cookie < s.length) {

            // 如果当前饼干满足当前孩子，则满足孩子，并移动到下一个孩子
            if (s[cookie] >= g[child]) {
                // 当前饼干能满足当前孩子
                count++;
                child++; // 满足后移动到下一个孩子
            }
            cookie++; // 无论是否满足，都要尝试下一个饼干
        }

        return count;
    }


    public static void main(String[] args) {
        // 测试用例
        int[] g1 = {1, 2, 3};
        int[] s1 = {1, 1};
        System.out.println(findContentChildren(g1, s1)); // 输出: 1

        int[] g2 = {1, 2};
        int[] s2 = {1, 2, 3};
        System.out.println(findContentChildren(g2, s2)); // 输出: 2
    }
}
