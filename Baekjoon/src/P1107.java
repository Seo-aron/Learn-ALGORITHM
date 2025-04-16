import java.util.Scanner;

public class P1107 {
    public static boolean remoteControl(int ch, boolean[] isBroken){
        if (ch == 0) return !isBroken[0];
        while (ch > 0) {
            // true = 고장난 버튼
            if (isBroken[ch % 10]) return false;

            ch = ch / 10;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ch = 100;
        int target = sc.nextInt();
        int breakdown = sc.nextInt();
        boolean[] isBroken = new boolean[10];
        int result = Math.abs(target - 100);

        // 고장난 버튼 = true
        for (int i = 0; i < breakdown; i++) {
            isBroken[sc.nextInt()] = true;
        }

        for (int i = 0; i <= 999999; i++) {
            if (remoteControl(i, isBroken)) {
                int pressCount = String.valueOf(i).length();    // 숫자 버튼 누른 횟수
                int moveCount = Math.abs(i - target);           // 목표까지 이동한 횟수
                result = Math.min(result, pressCount + moveCount);
            }
        }

        System.out.println(result);
    }
}
