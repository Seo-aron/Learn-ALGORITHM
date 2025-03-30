import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class P15657 {
    static StringBuilder sb = new StringBuilder();

    private static void func(ArrayList<Integer> result, int[] arr, int m, int start) {
        if (result.size() == m){
            for (int i = 0; i < result.size(); i++){
                sb.append(result.get(i)).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < arr.length; i++){
            result.add(arr[i]);
            func(result, arr, m, i);
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

        func(new ArrayList<Integer>(), arr, m, 0);

        System.out.println(sb);
    }
}
