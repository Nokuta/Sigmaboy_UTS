import java.util.Scanner;

public class Sigmaboy1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan jumlah elemen array: ");
        int n = input.nextInt();
        int[] nums = new int[n];

        System.out.println("Masukkan elemen array (harus terurut dari kecil ke besar):");
        for (int i = 0; i < n; i++) {
            nums[i] = input.nextInt();
        }

        int k = removeDuplicates(nums);

        System.out.println("\nJumlah elemen unik: " + k);
        System.out.print("Array setelah dihapus duplikat: ");
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int k = 1; 

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k; 
    }
}
