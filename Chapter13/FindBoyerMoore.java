
import java.util.HashMap;
import java.util.Map;

public class FindBoyerMoore {

    /**
     * Returns the lowest index at which substring pattern begins in text (or else −1),
     * using the Boyer-Moore algorithm.
     */
    public static int findBoyerMoore(char[] text, char[] pattern) {
        int n = text.length;    // length of the text
        int m = pattern.length; // length of the pattern

        if (m == 0) return 0;   // trivial search for an empty pattern

        // Create a map for the last occurrence of each character in the pattern
        Map<Character, Integer> last = new HashMap<>();  // the 'last' map

        // Initialize all characters in the text with a default value of -1
        for (int i = 0; i < n; i++)
            last.put(text[i], -1);

        // Set the rightmost occurrence of each character in the pattern
        for (int k = 0; k < m; k++)
            last.put(pattern[k], k);

        // Start with the end of the pattern aligned at index m−1 of the text
        int i = m - 1;  // an index into the text
        int k = m - 1;  // an index into the pattern

        while (i < n) {  // Continue as long as the pattern can fit within the text
            if (text[i] == pattern[k]) {  // a matching character is found
                if (k == 0) return i;     // entire pattern has been found, return the start index
                i--;  // otherwise, continue comparing previous characters
                k--;
            } else {  // if characters don't match, calculate the jump step
                int lastValue = last.get(text[i]);
                int min = Math.min(k, 1 + lastValue);
                i += m - min;  // case analysis for jump
                k = m - 1;  // restart from the end of the pattern
            }
        }

        return -1;  // pattern was not found in the text
    }

    public static void main(String[] args) {
        char[] text = {'s','s','5','5','1','3','5','s','i','i','5','5','5','4','5','5','5','1','4','5','5','5','4','5','5','1','2','3','3','5','5','5','4','5','4','5','5','5','4','5','5','5','4','5','5','5','4','5','5'};
        char[] pattern = {'s','u','s','h','i'};
        
        Integer finded = findBoyerMoore(text , pattern);
        
        System.out.println(finded);
    }
}
