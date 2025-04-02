import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P15664 {
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

        comb(new ArrayList<Integer>(), new boolean[n], arr, 0, m);

        System.out.println(sb);
    }

    private static void comb(List<Integer> result, boolean[] visited, int[] arr, int start, int m) {
        if (result.size() == m){
            for (int i = 0; i < result.size(); i++){
                sb.append(result.get(i)).append(" ");
            }
            sb.append("\n");
            return;
        }

        int preNum = -1;

        for (int i = start; i < arr.length; i++){
            if (preNum == arr[i]) continue;
            if (!visited[i]){
                visited[i] = true;
                result.add(arr[i]);
                comb(result, visited, arr, i + 1, m);
                visited[i] = false;
                result.remove(result.size() - 1);
                preNum = arr[i];
            }
        }
    }
}
