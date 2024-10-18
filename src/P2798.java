import java.util.*;

public class P2798 {
    static int[] num;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        num = new int[N];
        int sum = 0;
        int max = 0;

        for(int i = 0; i < N; i++){
            num[i] = sc.nextInt();
        }

        for(int i = 0; i < N-2; i++){
            for(int j = i+1; j < N-1; j++){
                for(int k = j+1; k < N; k++){
                    sum = num[i] + num[j] + num[k];
                    if (sum > M) {
                        continue;
                    }
                    if (max == 0){
                        max = sum;
                    } else{
                        max = sum > max ? sum : max;
                    }
                }
            }
        }
        System.out.println(max);
        sc.close();
    }
}
