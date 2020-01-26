package arrays;

public class RotateMatrix {
    boolean rotate(int[][] matrix) {
        if(matrix.length == 0 || matrix.length != matrix[0].length)
            return false;

        int n = matrix.length;
        for(int layer = 0; layer < n/2 ; layer++) {
            int first = layer;
            int last = n -  1 - layer;
            // we have i incrementing for the top layer.
            // However the bottom layer needs to go over its elements backwards.
            // Since we're not decrementing a counter to slowly walk the bottom array backwards, we use offset
            // to say "hey we're this far away fromm the first element on the top array, so you should be this many elements away from your last element"
            for(int i = first; i < last; i++) {
                int offset = i - first;

                int top = matrix[first][i];
                // left -> top
                matrix[first][i] = matrix[last - offset][first];

                // bottom -> left
                matrix[last - offset][first] = matrix[last][last - offset];

                // right -> bottom
                matrix[last][last - offset] = matrix[i][last];

                // top -> right
                matrix[i][last] = top;
            }
        }

        return true;

    }

    public void printMatrix(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] < 10)
                    System.out.print(matrix[i][j] + "  ");
                else
                    System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        RotateMatrix rm = new RotateMatrix();
        int[][] matrix = new int[4][4];
        int counter = 1;

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = counter;
                counter++;
            }
        }

        rm.printMatrix(matrix);

        System.out.println("Rotating matrix...\n");
        rm.rotate(matrix);

        rm.printMatrix(matrix);
    }
}
