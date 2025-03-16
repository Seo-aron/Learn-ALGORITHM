import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P15652 {
    public static void perm(int[] arr, int m, List<Integer> result, int index) {
        if (result.size() == m) {
            for (int i = 0; i < result.size(); i++){
                System.out.print(result.get(i) + " ");
            }
            System.out.println();
            return;
        }

        for (int i = index; i < arr.length; i++){
            result.add(arr[i]);
            perm(arr, m, result, i);
            result.remove(result.size() - 1);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++){
            arr[i] = i + 1;
        }

        perm(arr, m, result, 0);
    }
}
