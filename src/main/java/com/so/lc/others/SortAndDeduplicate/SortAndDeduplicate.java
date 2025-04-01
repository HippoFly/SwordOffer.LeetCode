package com.so.lc.others.SortAndDeduplicate;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SortAndDeduplicate {
    public static void main(String[] args) {


    }
    public static void s(){
            Scanner in = new Scanner(System.in);
            Set<Integer> inputNumSet = new HashSet<Integer>();
            in.nextInt();
            // 获取到数组的数量
            while (in.hasNextInt()) {
                // 注意 while 处理多个 case
                inputNumSet.add(in.nextInt());
            }
            // int total = inputNumSet.size();
            Object[] list = inputNumSet.toArray();
            Arrays.sort(list);
            for(int i = 0;i<list.length;i++){
                System.out.println(list[i]);
            }

    }
}
