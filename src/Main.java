import java.awt.Point;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import static java.lang.Integer.max;

public class Main {
    public static void main(String[] args) {
        int size;
        int matrix1[][];
        int matrix2[][];

        Scanner in = null;
        try {
            in = new Scanner(new File("in.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        size = in.nextInt();
        matrix1 = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix1[i][j] = in.nextInt();
            }
        }
        matrix2 = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix2[i][j] = in.nextInt();
            }
        }
        in.close();

        DenseMatrix m1 = new DenseMatrix(matrix1, size);
        DenseMatrix m2 = new DenseMatrix(matrix2, size);
        m2.TransM();
        DenseMatrix m3 = m1.mulDenseDense(m2);
        m3.StringM();

        int number;
        int number2;
        int size2=0;
        Scanner in2 = null;
        try {
            in2 = new Scanner(new File("in2.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        number = in2.nextInt();
        HashMap<Point, Integer> map1 = new HashMap<>();
        for (int i = 1; i <= number; i++) {
            Point Coord = new Point(in2.nextInt(),in2.nextInt());
            if ((Coord.x>size2)||(Coord.y>size2)) size2=max(Coord.x, Coord.y);
            map1.put(Coord,in2.nextInt());
        }
        number2 = in2.nextInt();
        HashMap<Point, Integer> map2 = new HashMap<>();
        for (int i = 1; i <= number2; i++) {
            Point Coord = new Point(in2.nextInt(),in2.nextInt());
            if ((Coord.x>size2)||(Coord.y>size2)) size2=max(Coord.x, Coord.y);
            map2.put(Coord,in2.nextInt());
        }
        in2.close();

        SparseMatrix s1 = new SparseMatrix(map1, size2);
        SparseMatrix s2 = new SparseMatrix(map2, size2);
        s1.NullS(); s2.NullS();
        SparseMatrix s3 = s1.mulSparseSparse(s2);
        s3.StringS();
    }
}
