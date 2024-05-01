package com.so.lc.NonrepeatNum;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class NonRepeatNum {
    public static void main(String[] args) {

    }

    public static void s(){
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String inStr= in.nextLine() ;
        int length=inStr.length();
        Set<Character> set=new HashSet();
        for(int i=0;i<length;i++){
            set.add(inStr.charAt(i));
        }
        System.out.println(set.size());
    }
}
