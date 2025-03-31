import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class P15663 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        comb(new ArrayList<>(), arr, m, 0, new boolean[n]);

        System.out.println(sb);
    }

    private static void comb(ArrayList<Object> result, int[] arr, int m, int start, boolean[] visited) {
        if (result.size() == m){
            for (int i = 0; i < result.size(); i++){
                sb.append(result.get(i)).append(" ");
            }
            sb.append("\n");
            return;
        }

        int prev = -1;

        for (int i = start; i < arr.length; i++){
            if (visited[i] || prev == arr[i]) continue;

            visited[i] = true;
            result.add(arr[i]);
            comb(result, arr, m, start, visited);
            result.remove(result.size() - 1);
            visited[i] = false;

            prev = arr[i];
        }
    }
}
