import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class DenseMatrix {
    public int size;
    public int matrix[][];

    public DenseMatrix(int[][] matrix, int size){
        this.size = size;
        this.matrix = matrix;
    }

    public DenseMatrix(int size){
        this.matrix = new int[size][size];
        this.size = size;
    }

    public DenseMatrix mulDenseDense(DenseMatrix other){
        DenseMatrix res = new DenseMatrix(size);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    res.matrix[i][j] = res.matrix[i][j] + this.matrix[i][k] * other.matrix[j][k];
                }
            }
        }
        return res;
    }

    public void TransM(){
        for (int i=0;i<size-1;i++){
            for (int j=i+1;j<size;j++){
                int b=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=b;
            }
        }
    }

    public void StringM(){
        PrintWriter out = null;
        try {
            out = new PrintWriter("out.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                out.print(matrix[i][j]+"  ");
                if (j==size-1) out.println();
            }
        }
        out.close();
    }
}
