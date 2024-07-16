package com.string_program;

public class DirectionWise_Path_Count {
	public static float getPath(String path) {
		int x = 0;
		int y = 0;

		for (int i = 0; i < path.length(); i++) {
			char dir = path.charAt(i);
			// south
			if (dir == 'S') {
				y--; // Move South
			} else if (dir == 'N') {
				y++; // Move North
			} else if (dir == 'W') {
				x--; // Move West
			} else {
				x++; // Move East
			}
		}
		int X2 = x * x;
		int Y2 = y * y;
		return (float) Math.sqrt(X2 + Y2);
	}

	public static void main(String[] args) {
		String path = "WNEENESENNN";
		System.out.println(getPath(path));
	}

}

					// Example in pic form
/*
 * 
 							|
 							|       N
 							|
 							|
 							|
 			W				|				E
 		 <-------------------------------------->
 							|
 							|
 							|
 							|		S
 							|
 							|
 							|
 					
 
 			
 * */
