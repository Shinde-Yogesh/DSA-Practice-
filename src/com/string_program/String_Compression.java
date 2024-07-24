package com.string_program;

public class String_Compression {
	// T.C O(n) with StringBuilder for efficient string concatenation

	public static String compressString(String str) {
		// Using StringBuilder for efficient string concatenation
		StringBuilder compressedStr = new StringBuilder();

		int length = str.length();
		for (int i = 0; i < length; i++) {
			int count = 1;

			// Count consecutive characters
			while (i < length - 1 && str.charAt(i) == str.charAt(i + 1)) {
				count++;
				i++;
			}

			// Append current character to StringBuilder
			compressedStr.append(str.charAt(i));

			// Append count if greater than 1
			if (count > 1) {
				compressedStr.append(count);
			}
		}
		return compressedStr.toString();
	}

	public static void main(String[] args) {
		String str = "aaabbcccdd";
		System.out.println(compressString(str)); // Output: a3b2c3d2
	}
}

/*				Approach 2			
					
				package com.string_program;
				
				public class String_Compression {
					// T.C O(n) StringBuilder O(log n)
				
					public static String compression(String str) {
						String newStr = "";
				
						for (int i = 0; i < str.length(); i++) {
							Integer count = 1;
				
							while (i < str.length() - 1 && str.charAt(i) == str.charAt(i + 1)) {
								count++;
								i++;
							}
							newStr += str.charAt(i);
				
							if (count > 1) {
								newStr += count.toString();
							}
						}
						return newStr;
					}
				
					public static void main(String[] args) {
						String str = "aaabbcccdd";
				
						System.out.println(compression(str));
					}
				
				}

*/


/*				  Approach 3
 		
 			package com.string_program;

			import java.util.LinkedHashMap;
			import java.util.Map;
			
			public class StringCompression {
			
			    public static String compressString(String str) {
			        // Using LinkedHashMap to store characters and their counts while maintaining insertion order
			        LinkedHashMap<Character, Integer> charCountMap = new LinkedHashMap<>();
			        int length = str.length();
			        
			        for (int i = 0; i < length; i++) {
			            char currentChar = str.charAt(i);
			            charCountMap.put(currentChar, charCountMap.getOrDefault(currentChar, 0) + 1);
			        }
			        
			        StringBuilder compressedStr = new StringBuilder();
			        for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
			            compressedStr.append(entry.getKey());
			            if (entry.getValue() > 1) {
			                compressedStr.append(entry.getValue());
			            }
			        }
			        
			        return compressedStr.toString();
			    }
			
			    public static void main(String[] args) {
			        String str = "aaabbcccdd";
			        System.out.println(compressString(str));  // Output: a3b2c3d2
			    }
			}
 */
