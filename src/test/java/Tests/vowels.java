package Tests;

public class vowels {
    public static void main(String[] args) {
        String input = "Hello, World!"; // Input string
        char[] vowelsArray = {'A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u'}; // Array of vowels

        // Convert the input string to a character array
        char[] inputArray = input.toCharArray();

        // Loop through each character in the input string
        for (char c : inputArray) {
            // Check if the character is a vowel
            for (char vowel : vowelsArray) {
                if (c == vowel) {
                    // Print the vowel
                    System.out.print(c);
                    break; // Exit the inner loop once a vowel is found
                }
            }
        }
    }
}
