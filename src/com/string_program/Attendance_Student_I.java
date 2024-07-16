package com.string_program;

public class Attendance_Student_I {

    public static boolean checkRecord(String s) {
        int countA = 0;
        int countL = 0;
        int forConse = 0;

        // Count the number of 'A's
        for (char a : s.toCharArray()) {
            if (a == 'A') {
                countA++;
            }
        }

        // Find the maximum number of consecutive 'L's
        for (char a : s.toCharArray()) {
            if (a == 'L') {
                countL++;
            } else {
                forConse = Math.max(forConse, countL);
                countL = 0;
            }
        }
        // Update forConse in case the string ends with 'L'
        forConse = Math.max(forConse, countL);

        // Check if the record is valid
        if (countA < 2 && forConse < 3) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        String s = "LALL";
        System.out.println(checkRecord(s)); // Output: true
    }
}
