/*
    부분합 (Prefix Sum)
    - 배열의 앞에서부터 누적된 합을 저장한 배열
    - 특정 구간의 합을 빠르게 계산할 수 있는 알고리즘 기법
    - 시간 복잡도 O(n)으로 구간합을 효율적으로 계산 가능

    - 동작 방식
    1. 입력 배열 A의 누적합을 저장하는 prefixSum 배열 생성
    2. prefixSum[i] = A[0] + A[1] + ... + A[i]
    3. 구간 [L, R]의 합 = prefixSum[R] - prefixSum[L - 1] (단, L > 0일 때)
 */

 public class PrefixSum {
    // 구간 [L, R]의 합을 구하는 함수
    private static int getRangeSum(int[] prefixSum, int L, int R) {
        if (L == 0) return prefixSum[R];
        return prefixSum[R] - prefixSum[L - 1];
    }

    public static void main(String[] args) {
        int[] A = {5, 2, 1, 4, 3};
        int[] prefixSum = new int[A.length];

        // 1. 부분합 배열 생성
        prefixSum[0] = A[0];
        for (int i = 1; i < A.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + A[i];
        }

        // 2. 구간 [1, 3]의 합 계산 (A[1] + A[2] + A[3])
        int L = 1;
        int R = 3;
        int sum = getRangeSum(prefixSum, L, R);

        // 3. 결과 출력
        System.out.println("Prefix Sum");
        System.out.println("구간 [" + L + ", " + R + "]의 합: " + sum);
    }
}
