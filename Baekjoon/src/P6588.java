import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class P6588 {
    static final int MAX = 1000000;
    static HashSet<Integer> primeSet = new HashSet<>();
    static ArrayList<Integer> primeList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        getPrime();

        while(true){
            int num = sc.nextInt();

            if (num == 0 || num % 2 != 0){
                return;
            }
            goldbach(num);
        }
    }

    public static void goldbach(int num){
        int a = 0;      // 작은 수
        int b = 0;      // 큰 수

        for (int testA : primeList){
            int testB = num - testA;

            if (primeSet.contains(testB)){
                a = testA;
                b = testB;
                break;
            }
        }

        if (a == 0){
            System.out.println("Goldbach's conjecture is wrong.");
        } else {
            System.out.println(num + " = " + a + " + " + b);
        }

    }

    public static void getPrime(){
        boolean[] isPrime = new boolean[MAX + 1];

        for (int i = 2; i < isPrime.length; i++){
            isPrime[i] = true;
        }

        for (int i = 2; i <= Math.sqrt(MAX); i++){
            if(isPrime[i]){
                for (int j = i * i; j <= MAX; j += i){
                    isPrime[j] = false;
                }
            }
        }
        // 문제에서 홀수만 구하라함
        for (int i = 3; i <= MAX; i++){
            if (isPrime[i]){
                primeSet.add(i);
                primeList.add(i);
            }
        }
    }
}
