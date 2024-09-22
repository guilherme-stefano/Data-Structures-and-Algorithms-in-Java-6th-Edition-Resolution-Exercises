/** Returns the lowest index at which substring pattern begins in text (or else -1). */
public static int findBrute(char[] text, char[] pattern) {
    int n = text.length;
    int m = pattern.length;
    
    // Try every starting index within text where pattern could fit
    for (int i = 0; i <= n - m; i++) {
        int k = 0;  // k is index into pattern
        
        // Check if the characters from the current index of text match the pattern
        while (k < m && text[i + k] == pattern[k]) {
            k++;  // increment k if characters match
        }
        
        // If we have gone through the entire pattern and found a match
        if (k == m) {
            return i;  // Return the starting index where the match begins
        }
    }
    
    // If no match was found, return -1
    return -1;
}
