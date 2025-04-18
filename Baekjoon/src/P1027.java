import java.util.Scanner;

public class P1027 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int[] building = new int[count + 1];
        int ans = 0;

        for (int i = 1; i <= count; i++){
            building[i] = sc.nextInt();
        }

        for (int i = 1; i <= count; i++){
            int now = building[i];
            int back = 0;
            int front = 0;

            // 뒤에 건물
            if (i > 1){
                double maxSlope = Double.MAX_VALUE;
                for (int j = i - 1; j > 0; j--){
                    double slope = (double)(now - building[j]) / (i - j);
                    if (slope < maxSlope) {
                        back++;
                        maxSlope = slope;
                    }
                }
            }
            // 앞에 건물
            if (i < count){
                double maxSlope = -Double.MAX_VALUE;
                for (int j = i + 1; j <= count; j++){
                    double slope = (double)(now - building[j]) / (i - j);
                    if (slope > maxSlope) {
                        front++;
                        maxSlope = slope;
                    }
                }
            }

            if (ans < back + front) {
                ans = back + front;
            }
        }

        System.out.println(ans);
    }
}