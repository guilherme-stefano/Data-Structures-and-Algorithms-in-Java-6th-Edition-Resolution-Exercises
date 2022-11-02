package C324;

public class ThreeDimensionalArrayAdd {
	
	public static void main(String[] args) {
		 int[][][] elements1 = { 
                 { {1, 2, 3, 4}, {5, 6, 75, 33}, {1, 2, 3, 4}, {1, 2, 3, 4} }, 
                 { {47, 21, 23, 7}, {7, 8, 75, 33}, {1, 2, 3, 4} }, 
                 { {66, 91, 15, 18} , {9, 10, 75, 33}, {1, 2, 3, 4}, {1, 2, 3, 4}}
                 };
		 
		 int[][][] elements2 = { 
                 { {1, 1}, {2, 2, 2, 2, 5}, {1, 1, 1, 1}, {4, 4, 4, 4} }, 
                 { {1, 1, 1, 1}, {2, 2, 2, 2}, {1, 1, 1, 1}, {4, 4, 4, 4} }, 
                 { {1, 1, 1, 1}, {2, 2, 2, 2}, {1, 1, 1, 1}, {4, 4, 4, 4} }, 
                 { {1, 1, 1, 1}, {2, 2, 2, 2}, {1, 1, 1, 1}, {4, 4, 4, 4} }
                 };
		 
		 
		 int[][][] result = Add(elements1,elements2 );
		 
		 for(int i = 0; i< 4; i++) {
			 for(int j = 0 ; j<4; j++) {
				 System.out.print("|");
				 for(int k = 0 ; k < 4 ; k++) {
					 System.out.print( result[i][j][k] + "|");
				 }
				 System.out.println("");
			 }
			 System.out.println("");
		 }
	}
	
	public static int[][][]  Add(int[][][] array1, int[][][] array2) {
		
		int[][][] arrayResult = null;
		int arrayI1[][][] = null;
		int arrayI2[][][] = null;
		if(array1.length >= array2.length) {
			arrayI1 =  array1;
		}else {
			arrayI1 =  new int[array2.length][array2[0].length][array2[0][0].length];
			for(int temp = 0 ; temp<array1.length; temp++) {
				arrayI1[temp] = array1[temp];
			}
		}
		
		if(array2.length >= array1.length) {
			arrayI2 =  array2;
		}else {
			arrayI2 =  new int[array1.length][array1[0].length][array1[0][0].length];
			for(int temp = 0 ; temp<array2.length; temp++) {
				arrayI2[temp] = array2[temp];
			}
		}

		for( int i = 0; i<arrayI1.length; i++ ) {
			int arrayJ1[][] = null;
			int arrayJ2[][] = null;
			if(arrayI1[i].length >= arrayI2[i].length) {
				arrayJ1 =  arrayI1[i];
			}else {
				arrayJ1 =  new int[arrayI2.length][arrayI2[0].length];
				for(int temp = 0 ; temp<arrayI1[i].length; temp++) {
					arrayJ1[temp] = arrayI1[i][temp];
				}
			}
			
			if(arrayI2[i].length >= arrayI1[i].length) {
				arrayJ2 =  arrayI2[i];
			}else {
				arrayJ2 =  new int[arrayI1.length][arrayI1[0].length];
				for(int temp = 0 ; temp<arrayI2[i].length; temp++) {
					arrayJ2[temp] = arrayI2[i][temp];
				}
			}
			for(int j = 0; j<arrayJ1.length; j++) {
				int arrayK1[] = null;
				int arrayK2[] = null;
	
					if(arrayJ1[j].length >= arrayJ2[j].length) {
						arrayK1 =  arrayJ1[j];
					}else {
						arrayK1 =  new int[arrayJ2.length];
						for(int temp = 0 ; temp<arrayJ1[j].length; temp++) {
							arrayK1[temp] = arrayJ1[j][temp];
						}
					}
					
					if(arrayJ2[j].length >= arrayJ1[j].length) {
						arrayK2 =  arrayJ2[j];
					}else {
						arrayK2 =  new int[arrayJ1.length];
						for(int temp = 0 ; temp<arrayJ2[j].length; temp++) {
							arrayK2[temp] = arrayJ2[j][temp];
						}
					}
				for(int k = 0; k<arrayK1.length; k++) {
					if(i==0 && j==0 && k==0) {
						arrayResult = new int[arrayI1.length][arrayJ1.length][arrayK1.length];
					}
					
					arrayResult[i][j][k] = arrayK1[k] + arrayK2[k];
				}
			}
		}
		
		return arrayResult;
	}
}
