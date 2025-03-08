import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P15651 {
    static StringBuilder sb = new StringBuilder();

    public static void permutation(int[] arr, int m, List<Integer> result){
        if (result.size() == m){
            for (int i = 0; i < result.size(); i++){
                sb.append(result.get(i)).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 0; i < arr.length; i++){
            result.add(arr[i]);
            permutation(arr, m, result);
            result.remove(result.size()-1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++){
            arr[i] = i + 1;
        }

        permutation(arr, m, new ArrayList<Integer>());
        System.out.println(sb);
        sc.close();
    }
}
