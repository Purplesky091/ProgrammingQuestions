package arrays;

public class ZeroMatrix {
   void setZeros(int[][] matrix) {
       boolean rowHasZero = false;
       boolean colHasZero = false;

       // check if first row has zero
       for(int j = 0; j < matrix[0].length; j++) {
           if(matrix[0][j] == 0) {
               colHasZero = true;
               break;
           }
       }

       for(int i = 0; i < matrix.length; i++) {
           if(matrix[i][0] == 0) {
               rowHasZero = true;
               break;
           }
       }

       // check for zeros in the rest of the array
       for (int i = 1; i < matrix.length; i++) {
           for(int j = 1; j < matrix[0].length; j++) {
               if(matrix[i][j] == 0) {
                   matrix[i][0] = 0;
                   matrix[0][j] = 0;
               }
           }
       }

       // nullify rows based on values in first col
       for(int i = 1; i < matrix.length; i++) {
           if(matrix[i][0] == 0)
               blastRow(matrix, i);
       }

       for(int j = 1; j < matrix[0].length; j++) {
           if(matrix[0][j] == 0)
               blastCol(matrix, j);
       }
   }

   void blastRow(int[][] matrix, int rowNum) {
       for(int j = 0; j < matrix[0].length; j++) {
           matrix[rowNum][j] = 0;
       }
   }

   void blastCol(int[][] matrix, int colNum) {
       for(int i = 0; i < matrix.length; i++) {
           matrix[i][colNum] = 0;
       }
   }

   public void printMatrix(int[][] matrix) {
       for(int i = 0; i < matrix.length; i++) {
           for(int j = 0; j < matrix[0].length; j++) {
               System.out.print(matrix[i][j] + " ");
           }
           System.out.println();
       }
   }

    public static void main(String[] args) {
        int[][] matrix = new int[5][4];
        int counter = 1;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                matrix[i][j] = counter;
                counter++;
            }
        }

        matrix[2][3] = 0;
        matrix[0][2] = 0;

        ZeroMatrix zeroMatrix = new ZeroMatrix();
        zeroMatrix.setZeros(matrix);
        zeroMatrix.printMatrix(matrix);
    }
}
