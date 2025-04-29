import java.util.Scanner;

public class P12904 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();
        char lastT = t.charAt(t.length() - 1);

        while (t.length() >= s.length()) {
            if (t.equals(s)) {
                System.out.println(1);
                return;
            }
            lastT = t.charAt(t.length() - 1);

            if (lastT == 'A') {
                // 뒤에 있는 A 제거
                t = t.substring(0, t.length() - 1);
            } else {
                t = t.substring(0, t.length() - 1);
                String reverse = new StringBuilder(t).reverse().toString();
                t = reverse;
            }
        }

        System.out.println(0);
    }
}
