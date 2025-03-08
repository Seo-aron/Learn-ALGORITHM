import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P15650 {
    public static void combination(int[] arr, int m, List<Integer> result, int start){
        if (result.size() == m){
            for (int i = 0; i < result.size(); i++){
                System.out.print(result.get(i) + " ");
            }
            System.out.println();
            return;
        }
        for (int i = start; i < arr.length; i++){
            result.add(arr[i]);
            combination(arr, m, result, i + 1);
            result.remove(result.size() - 1);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();   // 1~n까지 범위
        int m = sc.nextInt();   // 몇개 뽑을건지
        int[] arr = new int[n];

        for (int i = 0; i < n; i++){
            arr[i] = i + 1;
        }

        combination(arr, m, new ArrayList<>(), 0);

        sc.close();
    }
}
