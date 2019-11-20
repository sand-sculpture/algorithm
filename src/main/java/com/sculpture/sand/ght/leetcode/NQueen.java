package com.sculpture.sand.ght.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @description: N皇后
 *
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 *
 *
 * 上图为 8 皇后问题的一种解法。
 *
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 *
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 *
 * 示例:
 *
 * 输入: 4
 * 输出: [
 *  [".Q..",  // 解法 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *
 *  ["..Q.",  // 解法 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 * 解释: 4 皇后问题存在两个不同的解法。
 *
 * @author: haitao.gao
 * @create: 2019-09-08 15:38
 */
public class NQueen {

    /**
     * 暴力解法
     */
//    int[][] tepmResult = null;
//
//    List<List<String>> result = new ArrayList<>();
//
//    int n ;
//
//    public List<List<String>> solveNQueens(int n) {
//
//        this.n = n;
//        for(int level = 0;level<n;level++){
//            tepmResult = new int[n][n];
//            boolean isRight = checkAttack(level,0);
//            if(isRight){
//                List<String> temp = new ArrayList<>();
//                for(int[] ints : tepmResult) {
//                    String tempString = new String();
//                    for (int anInt : ints) {
//                        if(anInt==2){
//                            tempString = tempString+"Q";
//                        }else {
//                            tempString = tempString+".";
//                        }
//                    }
//                    temp.add(tempString);
//                }
//                result.add(temp);
//            }
//            tepmResult = null;
//        }
//       return result;
//    }
//
//    private boolean checkAttack(int x, int y) {
//
//        for(int i =x;i<n;i++){
//            boolean rowIsMarket = false;
//            for(int j=0;j<n;j++){
//                if(i == x){
//                    martTempResult(i,j);
//                    rowIsMarket = true;
//                    break;
//                }else {
//                    Boolean isSuccessMarket = martTempResult(i,j);
//                    if(!isSuccessMarket){
//                        continue;
//                    }else {
//                        rowIsMarket = true;
//                        break;
//                    }
//                }
//            }
//            if(!rowIsMarket){
//                return false;
//            }
//        }
//        return true;
//    }
//
//    private Boolean martTempResult(int i, int j) {
//        for(int row = i;row<n;row++){
//            boolean hasMarket = false;
//            for(int column = j;column<n;column++){
//                if((tepmResult[row][column] !=1 || tepmResult[row][column] !=2) &&(row==i || column==j || (column-row)==(j-i) || (column+row)==(i+j) )){
//                    hasMarket = true;
//                    tepmResult[row][column] = 1;
//                    continue;
//                }else {
//                    tepmResult[row][column] = 0;
//                }
//            }
//            if(!hasMarket){
//                return false;
//            }
//        }
//
//        tepmResult[i][j] = 2;
//        return true;
//    }

    /**
     * 回溯法
     */
//    List<List<String>> result = new ArrayList<>();
//    Set<Integer> marketColumn = new HashSet<>();
//    Set<Integer> marketPie = new HashSet<>();
//    Set<Integer> marketNa = new HashSet<>();
//    Integer maxRow;
//
//    public List<List<String>> solveNQueens(int n) {
//        if(maxRow == null){
//            maxRow = n;
//        }
//        checkMarket(1,new ArrayList<>());
//        return result;
//    }
//
//    public void checkMarket(int row,List<String> tempResult) {
//        if(row>maxRow){
//            result.add(tempResult);
//            return;
//        }
//        //实际上是列数
//        for(int i = 1;i<= maxRow;i++){
//            if(marketColumn.contains(i) || marketPie.contains(i+row) || marketNa.contains(row-i)){
//                continue;
//            }
//
//            marketColumn.add(i);
//            marketNa.add(row-i);
//            marketPie.add(row+i);
//
//            String temp = new String();
//            for(int j=1;j<=maxRow;j++){
//                temp+=(j==i?"Q":".");
//            }
//            tempResult.add(temp.toString());
//            checkMarket(row+1,tempResult);
//
//            marketColumn.remove(i);
//            marketPie.remove(row+i);
//            marketNa.remove(row-i);
//            tempResult.remove(temp.toString());
//        }
//    }

    /**
     * 52 求解法总数
     *
     */
    int total = 0;
    Set<Integer> marketColumn = new HashSet<>();
    Set<Integer> marketPie = new HashSet<>();
    Set<Integer> marketNa = new HashSet<>();
    Integer maxRow;

    public int solveNQueens(int n) {
        maxRow = n;
        checkMarket(1);
        return total;
    }

    public void checkMarket(int row) {
        if(row>maxRow){
            total++;
            return;
        }
        //实际上是列数
        for(int i = 1;i<= maxRow;i++){
            if(marketColumn.contains(i) || marketPie.contains(i+row) || marketNa.contains(row-i)){
                continue;
            }

            marketColumn.add(i);
            marketNa.add(row-i);
            marketPie.add(row+i);
            checkMarket(row+1);

            marketColumn.remove(i);
            marketPie.remove(row+i);
            marketNa.remove(row-i);
        }
    }

    /**
     * 官方解法
     * @param row
     * @param col
     * @param n
     * @param rows
     * @param hills
     * @param dales
     * @return
     */
    public boolean is_not_under_attack(int row, int col, int n,
                                       int [] rows,
                                       int [] hills,
                                       int [] dales) {
        //实际上是为了节省空间把下标直接当做常量值
        int res = rows[col] + hills[row - col + 2 * n] + dales[row + col];
        return (res == 0) ? true : false;
    }

    public int backtrack(int row, int count, int n,
                         int [] rows,
                         int [] hills,
                         int [] dales) {
        for (int col = 0; col < n; col++) {
            if (is_not_under_attack(row, col, n, rows, hills, dales)) {
                // place_queen
                rows[col] = 1;
                hills[row - col + 2 * n] = 1;  // "hill" diagonals
                dales[row + col] = 1;   //"dale" diagonals

                // if n queens are already placed
                if (row + 1 == n) count++;
                    // if not proceed to place the rest
                else count = backtrack(row + 1, count, n,
                        rows, hills, dales);

                // remove queen
                rows[col] = 0;
                hills[row - col + 2 * n] = 0;
                dales[row + col] = 0;
            }
        }
        return count;
    }

    public int totalNQueens(int n) {
        int rows[] = new int[n];
        // "hill" diagonals
        int hills[] = new int[4 * n - 1];
        // "dale" diagonals
        int dales[] = new int[2 * n - 1];

        return backtrack(0, 0, n, rows, hills, dales);
    }

    public static void main(String[] args) {
        NQueen nQueen = new NQueen();
        nQueen.solveNQueens(4);
    }

}
