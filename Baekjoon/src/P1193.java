import java.util.Scanner;

public class P1193 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int sum = 1;    // 각 행의 총 개수
        int i = 1;      // 몇 번째 행

        while (num > sum){
            i++;
            sum += i;
        }

        int a = num - (sum - i);
        int b = i - a + 1;

        if (i % 2 == 0){
            System.out.println(a + "/" + b);
        } else {
            System.out.println(b + "/" + a);
        }

        sc.close();
    }
}
