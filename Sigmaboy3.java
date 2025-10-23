import java.util.*;

public class Sigmaboy3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan jumlah baris segitiga Pascal (1–30): ");
        int numRows = scanner.nextInt();
        
        List<List<Integer>> hasil = generate(numRows);
        
        System.out.println("Output:");
        System.out.println(hasil);
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        if (numRows <= 0) {
            return triangle;
        }

        // baris pertama selalu [1]
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);

        // mulai dari baris ke-2
        for (int i = 1; i < numRows; i++) {
            List<Integer> prevRow = triangle.get(i - 1);
            List<Integer> row = new ArrayList<>();

            row.add(1); // elemen pertama selalu 1

            // isi tengahnya = jumlah dua elemen di atasnya
            for (int j = 1; j < i; j++) {
                row.add(prevRow.get(j - 1) + prevRow.get(j));
            }

            row.add(1); // elemen terakhir selalu 1
            triangle.add(row);
        }

        return triangle;
    }
}
