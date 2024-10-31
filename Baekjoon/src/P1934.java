import java.util.Scanner;

public class P1934 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int i = 0; i < T; i++){
            int A = sc.nextInt();
            int B = sc.nextInt();

            // 최소 공배수 = a * b / 최대공약수
            System.out.println(A * B / gcb(A, B));
        }
        sc.close();
    }
    // 최대공약수 구하는 함수 (유클리드 호제법)
    private static int gcb(int a, int b) {
        if(b == 0){
            return a;
        } else{
            return gcb(b, a%b);
        }
    }
}
