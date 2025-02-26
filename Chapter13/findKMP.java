public class findKMP {
    /**
     * Returns the lowest index at which substring pattern begins in text (or else −1),
     * using the Knuth-Morris-Pratt (KMP) algorithm.
     */
    public static int findKMP(char[] text, char[] pattern) {
        int n = text.length;    // length of the text
        int m = pattern.length; // length of the pattern

        if (m == 0) return 0;   // trivial search for an empty pattern

        int[] fail = computeFailKMP(pattern);  // compute the failure function
        int j = 0;  // index into the text
        int k = 0;  // index into the pattern

        while (j < n) {  // continue until the end of the text
            if (text[j] == pattern[k]) {  // current characters match
                if (k == m - 1) return j - m + 1;  // entire pattern has been found
                j++;  // advance in the text
                k++;  // advance in the pattern
            } else if (k > 0) {
                k = fail[k - 1];  // use the failure function to shift the pattern
            } else {
                j++;  // move to the next character in the text if no partial match
            }
        }

        return -1;  // pattern was not found
    }
    /**
     * Computes and returns the failure function for the Knuth-Morris-Pratt (KMP) algorithm.
     * The failure function stores, para cada posição j do padrão, o comprimento do maior prefixo 
     * que é também um sufixo da substring padrão[0..j].
     */
    private static int[] computeFailKMP(char[] pattern) {
        int m = pattern.length;    // tamanho do padrão
        int[] fail = new int[m];   // array de falhas, por padrão, todos os valores são zero
        int j = 1;                 // começa a partir do segundo caractere do padrão
        int k = 0;                 // o comprimento do maior prefixo que é também um sufixo

        while (j < m) {  // percorre o padrão até o final
            if (pattern[j] == pattern[k]) {  // se o caractere atual de j coincide com o de k
                fail[j] = k + 1;  // atualiza fail[j] com o comprimento do maior prefixo-sufixo
                j++;  // avança o índice j
                k++;  // avança o índice k
            } else if (k > 0) {  // caso contrário, se k > 0, faz o retrocesso baseado em fail[k-1]
                k = fail[k - 1];  // usa o valor da tabela de falha para evitar comparações repetidas
            } else {
                j++;  // se k for zero, simplesmente avança j
            }
        }

        return fail;  // retorna a tabela de falhas
    }

    public static void main(String[] args) {
        char[] text = {'s','a','m','a','l','g','a','m','a','i','i','5','5','a','m','a','l','g','a','m','a','t','i','o','n','4','5','5','5','4','5','5','1','2','3','3','5','5','5','4','5','4','5','5','5','4','5','5','5','4','5','5','5','4','5','5'};
        char[] pattern = {'a','m','a','l','g','a','m','a','t','i','o','n'};
        
        Integer finded = findKMP(text , pattern);
        
        System.out.println(finded);
    }

}
