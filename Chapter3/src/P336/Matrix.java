package P336;

public class Matrix {
	public static int[][] Multiply(int[][] a, int[][] b) throws Exception{
		
		if(a[0].length != b.length) {
			throw new Exception("não pode multiplicar");
		}
		int equalLenght = b.length;
		int xSize = a.length;
		int ySize = b[0].length;
		int[][] newMatrix = new int[xSize][ySize];
		
		
		for(int i = 0 ; i < ySize ; i++) {
			for(int j = 0; j <xSize; j++) {
			 for(int k = 0 ; k < equalLenght ; k++) {
						newMatrix[i][j] =  newMatrix[i][j] + (a[i][k] *   b[k][j]); 
				}
			}
		}
		return newMatrix;
	}
}
