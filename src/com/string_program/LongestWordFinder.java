public class LongestWordFinder {
    public static void main(String[] args) {
        String input = "Java is a powerful programming language";
        String longestWord = findLongestWord(input);
        
        System.out.println("Longest word: " + longestWord);
    }

    public static String findLongestWord(String sentence) {
        if (sentence == null || sentence.isEmpty()) {
            return "";
        }

        String[] words = sentence.split("\\s+"); // Split by spaces
        String longestWord = "";
        
        for (String word : words) {
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }
        return longestWord;
    }
}
