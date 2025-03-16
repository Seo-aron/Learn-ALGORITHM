/*
    DP (Dynamic Programing)
    
    - 복잡한 문제를 작은 부분 문제로 나누고, 각 부분 문제의 결과를 저장하여 
      중복 계산을 방지하는 알고리즘 기법
      (시간 복잡도를 줄이기 위해 메모이제이션 또는 TopDown / BottomUp 방식 사용)

    - 동작 방식
    1. 큰 문제를 작은 문제로 나누어 해결
    2. 부분 문제의 결과를 저장 (메모이제이션 or DP테이블 활용)
    3. 저장된 결과를 활용하여 최종 결과 도출
 */

public class DP{
    // 피보나치 수열 (바텀업 방식)
    public static int fibonacci(int n){
        if (n <= 1) return n;

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
    public static void main(String[] args){
        int n = 10;
        
        System.out.println("DP");
        System.out.println("피보나치 " + n + "번째 수: " + fibonacci(n));
    }
}