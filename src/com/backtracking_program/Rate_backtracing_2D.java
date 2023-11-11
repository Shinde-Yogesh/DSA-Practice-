package com.backtracking_program;
/*
import java.nio.file.Path;

public class Rate_backtracing_2D {

	public static void main(String args[]) {
		System.out.println(count(3, 3));
		path("", 3, 3);

	}

	public static int count(int r, int c) {
		if (r == 1 || c == 1) {
			return 1;
		}
		int left = count(r - 1, c);
		int right = count(r, c - 1);

		return left + right;
	}

	public static void path(String p, int r, int c) {
		if (r == 1 && c == 1) {
			System.out.println(p);
			return;
		}

		if (r > 1) {
			path(p + 'D', r - 1, c);
		}

		if (c > 1) {
			path(p + 'R', r, c - 1);
		}
	}

}
*/
// another approach is

import java.util.*;

//m is the given matrix and n is the order of matrix
class Solution {
	private static void solve(int i, int j, int a[][], int n, ArrayList<String> ans, String move, int vis[][], int di[],
			int dj[]) {
		if (i == n - 1 && j == n - 1) {
			ans.add(move);
			return;
		}
		String dir = "DLRU";
		for (int ind = 0; ind < 4; ind++) {
			int nexti = i + di[ind];
			int nextj = j + dj[ind];
			if (nexti >= 0 && nextj >= 0 && nexti < n && nextj < n && vis[nexti][nextj] == 0 && a[nexti][nextj] == 1) {

				vis[i][j] = 1;
				solve(nexti, nextj, a, n, ans, move + dir.charAt(ind), vis, di, dj);
				vis[i][j] = 0;

			}
		}
	}

	public static ArrayList<String> findPath(int[][] m, int n) {
		int vis[][] = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				vis[i][j] = 0;
			}
		}
		int di[] = { +1, 0, 0, -1 };
		int dj[] = { 0, -1, 1, 0 };
		ArrayList<String> ans = new ArrayList<>();
		if (m[0][0] == 1)
			solve(0, 0, m, n, ans, "", vis, di, dj);
		return ans;
	}
}

class Rate_backtracing_2D {
	public static void main(String[] args) {

		int n = 4;
		int[][] a = { { 1, 0, 0, 0 }, { 1, 1, 0, 1 }, { 1, 1, 0, 0 }, { 0, 1, 1, 1 } };

		Solution obj = new Solution();
		ArrayList<String> res = obj.findPath(a, n);
		if (res.size() > 0) {
			for (int i = 0; i < res.size(); i++)
				System.out.print(res.get(i) + " ");
			System.out.println();
		} else {
			System.out.println(-1);
		}
	}
}
