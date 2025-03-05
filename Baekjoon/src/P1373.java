import java.math.BigInteger;
import java.util.Scanner;

public class P1373 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num = sc.next();
        BigInteger result = new BigInteger(num, 2);
        System.out.println(result.toString(8));
    }
}
