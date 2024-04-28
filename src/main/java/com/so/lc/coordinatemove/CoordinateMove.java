package com.so.lc.coordinatemove;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoordinateMove {


    public static void main(String[] args) {
        String s1 = "A10;S20;W10;D30;X;A1A;B10A11;;A10;";
        String[] strings = s1.split(";");
        List<Integer[]> coArr = new ArrayList<>();
        for (String s : strings) {
            if (s==null||s.length()<2) {
                continue;
            }
            //不用正则表达非常恶心
            if(!s.matches("^[ADWS]{1}[0-9]{1,2}$")){
                continue;
            }
            if (s.startsWith("W")) {
                coArr.add(new Integer[]{0, Integer.parseInt(s.substring(1))});
                continue;
            }
            if (s.startsWith("S")) {
                coArr.add(new Integer[]{0, Integer.parseInt("-"+s.substring(1))});
                continue;
            }
            if (s.startsWith("A")) {
                coArr.add(new Integer[]{ Integer.parseInt("-"+s.substring(1)),0});
                continue;
            }
            if (s.startsWith("D")) {
                coArr.add(new Integer[]{ Integer.parseInt(s.substring(1)),0});
                continue;
            }
        }
        Integer x=0,y=0;
        for (Integer[] integers : coArr) {
            x+=integers[0];
            y+=integers[1];
        }
        System.out.println(x+","+y);
    }
}
