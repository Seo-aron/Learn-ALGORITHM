import java.util.Scanner;

public class P2609 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        int div = divisor(a, b);
        int mul = multiple(a, b, div);

        System.out.println(div);
        System.out.println(mul);
    }

    private static int divisor(int a, int b){
        // 최대 공약수
        int standard = Math.min(a, b);
        int div = 1;

        for (int i = 1; i <= standard; i++){
            if (a % i == 0 && b % i == 0){
                div = i;
            }
        }

        return div;
    }

    private static int multiple(int a, int b, int div){
        // 최소 공배수
        int mul = 0;

        for (int i = div; i <= a * b; i += div){
            if (i % a == 0 && i % b ==0){
                mul = i;
                return mul;
            }
        }

        return mul;
    }
}
