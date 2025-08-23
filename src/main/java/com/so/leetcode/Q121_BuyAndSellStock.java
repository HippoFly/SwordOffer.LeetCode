package com.so.leetcode;

/**
 *
 * 121. 买卖股票的最佳时机
 *
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 *
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 *
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[7,1,5,3,6,4]
 * 输出：5
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 * 示例 2：
 *
 * 输入：prices = [7,6,4,3,1]
 * 输出：0
 * 解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
 *
 * @author FlyHippo
 * @version 1.0
 * @created 2025-05-27 09:08
 * @tag
 * @link <a href=""></a>
 **/
public class Q121_BuyAndSellStock {
    /**
     * 计算最大利润
     *
     * @param prices 代表股票价格的整数数组，其中每个元素表示某一天的股票价格
     * @return 返回从股票交易中能得到的最大利润
     */
    public int maxProfit(int[] prices) {
        // 检查输入数组是否为空或长度为0，如果是，则返回0，表示没有交易发生
        if (prices == null || prices.length == 0) return 0;

        // 初始化最低买入价格为整型最大值，方便在遍历过程中更新最低价格
        int minPrice = Integer.MAX_VALUE;
        // 初始化最大利润为0，表示如果没有交易或无法获利，则利润为0
        int maxProfit = 0;

        // 遍历价格数组，寻找最低的买入价格和最大的利润
        for (int price : prices) {
            // 如果当前价格低于已记录的最低买入价格，则更新最低买入价格
            if (price < minPrice) {
                minPrice = price; // 更新最低买入价格
            } else {
                // 如果当前价格高于最低买入价格，则计算当前利润，并更新最大利润
                maxProfit = Math.max(maxProfit, price - minPrice); // 更新最大利润
            }
        }

        // 返回计算得到的最大利润
        return maxProfit;
    }

}
