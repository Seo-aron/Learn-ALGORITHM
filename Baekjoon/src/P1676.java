import java.util.Scanner;

public class P1676 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int zero = 0;

        for (int i = 5; i <= a; i *= 5){
            zero += a / i;
        }

        System.out.println(zero);
    }
}
