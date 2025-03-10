import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P15654 {
    private static void permutation(int[] num, int m, boolean[] visited, List<Integer> result) {
        if (result.size() == m){
            for (int i = 0; i < result.size(); i++){
                System.out.print(result.get(i) + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < num.length; i++){
            if (!visited[i]){
                visited[i] = true;
                result.add(num[i]);
                permutation(num, m, visited, result);
                result.remove(result.size() - 1);
                visited[i] = false;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] num = new int[n];

        for (int i = 0; i < n; i++){
            num[i] = sc.nextInt();
        }
        Arrays.sort(num);

        permutation(num, m, new boolean[n], new ArrayList<Integer>());
    }
}
