import java.util.Scanner;

public class P2903 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dot = scanner.nextInt();
        int n = 2;
        int result = 0;

        for (int i=1; i <= dot; i++){
            result = n + n - 1;
            n = result;
        }

        result = (int) Math.pow(result, 2);

        System.out.println(result);
    }
}