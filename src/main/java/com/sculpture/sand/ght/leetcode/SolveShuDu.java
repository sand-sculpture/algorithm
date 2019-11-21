package com.sculpture.sand.ght.leetcode;

/**
 * @description: 解数独(未完待续)
 * @author: haitao.gao
 * @create: 2019-11-19 22:50
 */
public class SolveShuDu {

    char[][] allLineAndRaw ;
    char[][][] allThreeForThree ;
    char[][][] allNullChose = new char[9][9][9];

    public void solveSudoku(char[][] board) {

        checkShudu(board);
        setPreValue(board);

    }

    private void setPreValue(char[][] board) {
        //i是行 j是列
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(board[i][j] == '.'){

                }
            }
        }
    }

    public boolean checkShudu(char[][] board) {
        char[][] lineAndRaw = new char[18][9];
        char[][][] threeForThree = new char[9][9][9];

        //i是行 j是列
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                if (board[i][j] != '.') {
                    int base = board[i][j] - '0' - 1;
                    //判断每一行
                    if (lineAndRaw[i][base % 9] == '\0') {
                        lineAndRaw[i][base % 9] = board[i][j];
                    } else {
                        return false;
                    }

                    //判断每一列
                    if (lineAndRaw[j + 9][base % 9] == '\0') {
                        lineAndRaw[j + 9][base % 9] = board[i][j];
                    } else {
                        return false;
                    }
                    if (threeForThree[i / 3][j / 3][base] == '\0') {
                        //判断每个小型九宫格
                        threeForThree[i / 3][j / 3][base] = board[i][j];
                    } else {
                        return false;
                    }
                }
            }
        }
        if(allLineAndRaw == null){
            allLineAndRaw = lineAndRaw;
            allThreeForThree = threeForThree;
        }
        return true;

    }
}
