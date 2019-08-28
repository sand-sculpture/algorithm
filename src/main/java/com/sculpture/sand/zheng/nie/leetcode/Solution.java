package com.sculpture.sand.zheng.nie.leetcode;

import java.util.*;

/**
 * @author: niezheng1
 * @Date: 2019/8/27 21:38
 */
public class Solution {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> resultList = new ArrayList<>();
//设计数据结构存贮占用的斜线
        Set<Integer> positiveLine = new HashSet<>();//点(x,y) 斜线为 x-y=n
        Set<Integer> negativeLine = new HashSet<>();//点(x,y) 斜线为 x+y=n
        Set<Integer> yLine = new HashSet<>();
        dfs(0, n, positiveLine, negativeLine, yLine, resultList, new ArrayList<>());
        return resultList;
    }

    private void dfs(int row, int n, Set<Integer> positiveLine, Set<Integer> negativeLine,
                     Set<Integer> yLine, List<List<String>> resultList, List<String> subResult) {
//terminator
        if (row == n) {
            resultList.add(new ArrayList<>(subResult));
            return;
        }

        for (int col = 0; col < n; col++) {
            int pos = row + col;
            int neg = row - col;
            if (positiveLine.contains(pos) || negativeLine.contains(neg) || yLine.contains(col)) {
//剪枝
                continue;
            }
            positiveLine.add(pos);
            negativeLine.add(neg);
            yLine.add(col);
            char[] chars = new char[n];
            Arrays.fill(chars, '.');
            chars[col] = 'Q';
            String subStr = new String(chars);
            subResult.add(subStr);
            dfs(row + 1, n, positiveLine, negativeLine, yLine, resultList, subResult);
            subResult.remove(subStr);
            positiveLine.remove(pos);
            negativeLine.remove(neg);
            yLine.remove(col);
        }
    }
}

