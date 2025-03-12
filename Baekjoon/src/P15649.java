import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P15649 {
    static StringBuilder sb = new StringBuilder();
    public static void perm(int n, int m, boolean[] visited, List<Integer> result){
        if (result.size() == m){
            for (int i = 0; i < result.size(); i++){
                sb.append(result.get(i)).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 1; i <= n; i++){
            if (!visited[i]){
                visited[i] = true;
                result.add(i);
                perm(n, m, visited, result);
                result.remove(result.size()-1);
                visited[i] = false;
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<Integer> result = new ArrayList<>();

        perm(n, m, new boolean[n+1], result);

        System.out.println(sb);
    }
}
