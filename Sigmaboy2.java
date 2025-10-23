import java.util.Arrays;
import java.util.Scanner;

public class Sigmaboy2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan jumlah untuk nums1: ");
        int mInput = scanner.nextInt();
        int[] nums1 = new int[mInput]; 

        System.out.println("Masukkan m:");
        for (int i = 0; i < mInput; i++) {
            nums1[i] = scanner.nextInt();
        }

        System.out.print("Masukkan jumlah untuk nums2: ");
        int n = scanner.nextInt();
        int[] nums2 = new int[n];

        System.out.println("Masukkan n:");
        for (int i = 0; i < n; i++) {
            nums2[i] = scanner.nextInt();
        }

        // Hitung elemen valid (bukan 0) di nums1
        int m = 0;
        for (int val : nums1) {
            if (val != 0) m++;
        }

        // Pastikan nums1 punya ruang cukup
        nums1 = Arrays.copyOf(nums1, m + n);

        // Gabungkan dan hapus nol
        merge(nums1, m, nums2, n);
        int[] hasilBersih = removeZeros(nums1);

        System.out.println("\nHasil: " + Arrays.toString(hasilBersih));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }

        while (j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }

    public static int[] removeZeros(int[] nums) {
        int count = 0;
        for (int num : nums) {
            if (num != 0) count++;
        }

        int[] result = new int[count];
        int index = 0;
        for (int num : nums) {
            if (num != 0) result[index++] = num;
        }
        return result;
    }
}