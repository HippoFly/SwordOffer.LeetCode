package com.so.lc.Array;

/**
 * 描述
 *
 * @author FlyHippo
 * @version 1.0
 * @createDate 2024/5/4 11:20
 **/

public class Q74_Search2DMatrix {

    public static void main(String[] args) {
        Q74_Search2DMatrix search2DMatrix = new Q74_Search2DMatrix();
        int[][] ints = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        System.out.println(ints.length);
        System.out.println(ints[0].length);
        System.out.println(search2DMatrix.searchMatrix(ints,13));
    }

    /**  3  |   7     20    60
     *   2  |   5     16    34
     *   1  |   3     11    30
     *   0  |   1     10    23
     *   y/x,   0,    1,    2,
     *
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int row= matrix.length;
        int col = matrix[0].length;
        int y = col - 1, x = 0;
        while (  y >=0 &&x < row) {
                if(matrix[x][y]<target){
                    x++;
                }else if(matrix[x][y]>target){
                    y--;
                }else {
                    return true;
                }
        }
        return false;
    }
}
