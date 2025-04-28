import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P15665 {
    static int n;
    static int m;
    static StringBuilder sb = new StringBuilder();

    public static void func(int[] arr, List<Integer> list){
        if (list.size() == m) {
            for (int i = 0; i < m; i++) {
                sb.append(list.get(i)).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (i != 0) {
                if (arr[i] == arr[i-1]) continue;
            }
            list.add(arr[i]);
            func(arr, list);
            list.remove(list.size() - 1);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        func(arr, new ArrayList<Integer>());

        System.out.println(sb);
    }
}
