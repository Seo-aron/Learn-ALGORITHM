import java.util.Scanner;

public class P2720 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();  // 테스트 케이스 횟수

        final int QUARTER = 25;
        final int DIME = 10;
        final int NICKEL = 5;
        final int PENNY = 1;

        for (int i = 0; i < T; i++){
            int C = scanner.nextInt();  // 거스름 돈

            int quarter_ = C / QUARTER;
            C = C % QUARTER;

            int dine_ = C / DIME;
            C = C % DIME;

            int nickel_ = C / NICKEL;
            C = C % NICKEL;

            int penny_ = C / PENNY;

            System.out.println(quarter_ + " " + dine_ + " " + nickel_ + " " + penny_);
        }
        scanner.close();
    }
}
