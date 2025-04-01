package com.so.lc.others.SumInArray;


import java.util.HashMap;
import java.util.Map;

/**
 * 给出一个整数数组，请在数组中找出两个加起来等于目标值的数，
 *
 * 你给出的函数twoSum 需要返回这两个数字的下标（index1，index2），需要满足 index1 小于index2.。注意：下标是从1开始的
 *
 * 假设给出的数组中只存在唯一解
 *
 * 例如：
 *
 * 给出的数组为 {20, 70, 110, 150},目标值为90
 * 输出 index1=1, index2=2
 * 复制
 * 示例1
 *
 * 输入：
 *
 * [3,2,4],6
 *
 * 返回值：
 *
 * [2,3]
 */
public class TwoSumExist {
    public static void main(String[] args) {

        twoSum(new int[]{40,22,12,33,60},100);
    }
    public static void twoSum(int[] arr,int sum){
        Map<Integer, Integer> temp = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            Integer preIndex = temp.get(sum - arr[i]);
            if (preIndex !=null) {
                System.out.println("index1:"+preIndex+", index2:"+i);
            }else {
                temp.put(arr[i], i);
            }
        }

    }
}
