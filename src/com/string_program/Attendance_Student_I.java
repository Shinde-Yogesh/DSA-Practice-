package com.string_program;

public class Attendance_Student_I {
	
	//LALL
	// *****************best Approach*******************
	public boolean Aprroach_Two_checkRecord(String s) {
        int co = 0,a=0;
        for(char c : s.toCharArray())
        {
            if(c=='P' || c == 'A')
                co=0;

            if(c == 'L')
                co++;
            
            if(co == 3)
                return false;
            if(c == 'A')
                a++;
            
            if(a>=2)
                return false;
        }

        return true;
    }
	 public static  boolean Approach_1_checkRecord(String s) {
	        int a=0;
	        for(int i=0;i<s.length();i++){
	            if(s.charAt(i)=='A') a++;
	        }
	        if(s.contains("LLL")) return false;
	        if(a>=2) return false;

	        return true;
	         
	    }
	
    public static boolean checkRecord(String s) {
        int countA = 0;
        int countL = 0;
       int   forConse = 0;

        for(char a : s.toCharArray())
        {
            if(a == 'A')
            {
                    countA++;
            }
        }

        for(char a : s.toCharArray())
        {
            if(a == 'L')
            {
                    countL++;
            }
            else
            {
                forConse = Math.max(forConse, countL);
                countL = 0;
            }
        }
       forConse = Math.max(forConse, countL);
        if(countA < 2 && forConse < 3)
        {
            return true;
        }
        else
        {
           return  false;
        }
        
    }
        
    
	public static void main(String[] args) {
		String s = "LALL";
		System.out.println(checkRecord(s));
	}

}
