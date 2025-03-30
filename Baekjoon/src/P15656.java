import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P15656 {
    static StringBuilder sb = new StringBuilder();

    private static void func(List<Integer> result, int[] arr, int m) {
        if (result.size() == m){
            for (int i = 0; i < m; i++){
                sb.append(result.get(i)).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < arr.length; i++){
            result.add(arr[i]);
            func(result, arr, m);
            result.remove(result.size() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        func(new ArrayList<>(), arr, m);

        System.out.println(sb);
    }
}
