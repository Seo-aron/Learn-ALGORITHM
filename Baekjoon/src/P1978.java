import java.util.Scanner;

public class P1978 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int result = 0;

        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            boolean prime = true;

            if (num == 1) {
                prime = false;
            } else if (num == 2) {
                prime = true;
            } else {
                // num 3이상부터 실행
                for (int j = 2; j <= Math.sqrt(num); j++){
                    if (num % j == 0){
                        prime = false;
                        break;
                    }
                }
            }

            if (prime) result++;
        }

        System.out.println(result);
    }
}
