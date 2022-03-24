package C123;


public class JavaProduct {
	  public static void main(String[] args)
	    {
	        int[] a = {1,2,3,4,5};
	        int[] b = {1,2,3,4,5};
	        JavaProduct product = new JavaProduct();
	        int[] vectorProduct = product.VectorProduct(a,b);
	        
	        for(int i : vectorProduct) {
	        	System.out.print(i + ",");
	        }
	    }
	 
	    private int[] VectorProduct(int[] a, int[] b)
	    {

	    	int[] product = new int[a.length];
            for (int i = 0; i < a.length; i++)
            {
            	product[i] = a[i] * b[i];
            }
            
            return product;
        
	    }
	 
	    /**
	    * Swap Characters at position
	    * @param a string value
	    * @param i position 1
	    * @param j position 2
	    * @return swapped string
	    */
	    public String swap(String a, int i, int j)
	    {
	        char temp;
	        char[] charArray = a.toCharArray();
	        temp = charArray[i] ;
	        charArray[i] = charArray[j];
	        charArray[j] = temp;
	        return String.valueOf(charArray);
	    }
}
