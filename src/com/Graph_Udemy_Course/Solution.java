import java.io.*;
import java.util.*;

class Result {
    static final int MOD = 1000000007;

    public static int distributeRanges(List<List<Integer>> ranges) {
        int n = ranges.size();
        ranges.sort(Comparator.comparingInt(a -> a.get(0)));

        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (ranges.get(j).get(0) > ranges.get(i).get(1)) {
                    break;
                }
                if (overlaps(ranges.get(i), ranges.get(j))) {
                    uf.union(i, j);
                }
            }
        }

        int components = uf.countComponents();
        return (modPow(2, components, MOD) - 2 + MOD) % MOD;
    }

    private static boolean overlaps(List<Integer> range1, List<Integer> range2) {
        return range1.get(1) >= range2.get(0) && range2.get(1) >= range1.get(0);
    }

    private static int modPow(int base, int exp, int mod) {
        long result = 1;
        long power = base;

        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * power) % mod;
            }
            power = (power * power) % mod;
            exp >>= 1;
        }

        return (int) result;
    }
}

class UnionFind {
    private int[] parent;
    private int[] rank;
    private int components;

    public UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        components = n;
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
            components--;
        }
    }

    public int countComponents() {
        return components;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int rangesRows = Integer.parseInt(bufferedReader.readLine().trim());
        int rangesColumns = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> ranges = new ArrayList<>();

        for (int i = 0; i < rangesRows; i++) {
            ranges.add(
                Arrays.stream(bufferedReader.readLine().split(" "))
                      .map(Integer::parseInt)
                      .toList()
            );
        }

        int result = Result.distributeRanges(ranges);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
