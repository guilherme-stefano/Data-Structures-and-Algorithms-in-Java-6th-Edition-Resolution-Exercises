package R510;

public class MatrixRecursive {
	public static int Sum(int[][] matrix, int row, int rowSize, int column, int columnSize) {
		  
		if(row == rowSize) {
			return 0;
		}
		
		if(column == columnSize) {
			return matrix[row][column];
		}
		  
		int columns = matrix[row][column] + Sum(matrix, row, rowSize, column + 1,  columnSize);
		int sum = Sum(matrix, row + 1, rowSize, column,  columnSize);
		  
		return sum + columns ; 
	}
}
   

