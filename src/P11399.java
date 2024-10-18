import java.util.*;

public class P11399 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] sec = new int[n];
        int sum = 0;
        int result = 0;

        for(int i = 0; i < n; i++){
            sec[i] = sc.nextInt();
        }
        Arrays.sort(sec);
        
        for(int i = 0; i < n; i++){
            sum += sec[i];
            result += sum;
        }
        System.out.println(result);

        sc.close();
    }
}
