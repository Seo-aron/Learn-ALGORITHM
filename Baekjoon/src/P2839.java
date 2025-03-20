import java.util.Scanner;

public class P2839 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sugar = sc.nextInt();
        int temp = 0;
        int result = Integer.MAX_VALUE;
        int y = 0;
        int i = 0;

        while (true){
            y = sugar - (5 * i);
            if (y == 0){
                System.out.println(i);
                return;
            } else if (y > 0 && y % 3 == 0){
                temp = i + (y / 3);
                if (result > temp) {
                    result = temp;
                }
            }

            if (y < 0) {
                if (result != Integer.MAX_VALUE){
                    System.out.println(result);
                    return;
                }
                System.out.println(-1);
                return;
            }

            i++;
        }
    }
}
