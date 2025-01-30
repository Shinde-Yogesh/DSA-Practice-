import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {
    /*
     * Complete the 'longestBitonicSubarray' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */
    public static int longestBitonicSubarray(List<Integer> arr) {
        int n = arr.size();
        if (n < 2) return n;

        // Arrays to store the length of increasing and decreasing subarrays
        int[] inc = new int[n];
        int[] dec = new int[n];

        // Initialize the first element of `inc` as 1
        inc[0] = 1;

        // Calculate the increasing subarray lengths
        for (int i = 1; i < n; i++) {
            if (arr.get(i) >= arr.get(i - 1)) {
                inc[i] = inc[i - 1] + 1;
            } else {
                inc[i] = 1;
            }
        }

        // Initialize the last element of `dec` as 1
        dec[n - 1] = 1;

        // Calculate the decreasing subarray lengths
        for (int i = n - 2; i >= 0; i--) {
            if (arr.get(i) >= arr.get(i + 1)) {
                dec[i] = dec[i + 1] + 1;
            } else {
                dec[i] = 1;
            }
        }

        // Calculate the length of the longest bitonic subarray
        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            maxLength = Math.max(maxLength, inc[i] + dec[i] - 1);
        }

        return maxLength;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());
        List<Integer> arr = IntStream.range(0, arrCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
        .map(String::trim)
        .map(Integer::parseInt)
        .collect(toList());

        int result = Result.longestBitonicSubarray(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
