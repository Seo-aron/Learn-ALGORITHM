import java.util.Arrays;
import java.util.Scanner;

public class P28353 {
    public static void twoCat(int cat, int weight, int[] catWeight){
        int start = 0;
        int end = catWeight.length - 1;
        int ans = 0;

        while (start < end){
            int sum = catWeight[start] + catWeight[end];

            if (sum <= weight) {
                ans++;
                start++;
                end--;
            } else {
                end--;
            }
        }

        System.out.println(ans);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cat = sc.nextInt();
        int weight = sc.nextInt();

        int[] catWeight = new int[cat];
        for (int i = 0; i < cat; i++){
            catWeight[i] = sc.nextInt();
        }

        Arrays.sort(catWeight);
        twoCat(cat, weight, catWeight);
    }
}
