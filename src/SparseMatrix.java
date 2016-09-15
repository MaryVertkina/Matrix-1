import java.awt.Point;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;

public class SparseMatrix {
    public int size;
    public HashMap<Point,Integer> map;

    public SparseMatrix(HashMap<Point,Integer> map, int size){
        this.size = size;
        this.map = map;
    }

    public SparseMatrix(int size){
        this.map = new HashMap<>();
        this.size = size;
    }

    public SparseMatrix mulSparseSparse(SparseMatrix other){
        int s;
        SparseMatrix res = new SparseMatrix(size);
        res.NullS();
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                for (int k = 1; k <= size; k++) {
                    Point Coord1 = new Point();  Coord1.x=j; Coord1.y=i;
                    Point Coord2 = new Point();  Coord2.x=k; Coord2.y=i;
                    Point Coord3 = new Point();  Coord3.x=j; Coord3.y=k;
                    s = res.map.get(Coord1) + (this.map.get(Coord2) * other.map.get(Coord3));
                    res.map.put(Coord1,s);
                }
            }
        }
        return res;
    }

    public void NullS(){
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                Point Coord = new Point();
                Coord.x=j; Coord.y=i;
                if (map.get(Coord)==null) map.put(Coord,0);
            }
        }
    }

    public void StringS(){
        PrintWriter out2 = null;
        try {
            out2 = new PrintWriter("out2.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                Point Coord = new Point();
                Coord.x=j; Coord.y=i;
                out2.print(map.get(Coord)+"  ");
                if (j==size) out2.println();
            }
        }
        out2.close();
    }
}
