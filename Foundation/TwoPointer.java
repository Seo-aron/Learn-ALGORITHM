/*
    투 포인터 (Two Pointer)
    - 배열이나 리스트에서 두 개의 포인터를 이용해 문제를 해결하는 알고리즘 기법
    - 주로 정렬된 배열에서 부분 합, 쌍의 합, 구간 탐색 등에 사용

    - 동작 방식
    1. 시작점 포인터(start)와 끝점 포인터(end)를 설정
    2. 특정 조건에 따라 포인터를 이동시키며 값을 비교 또는 계산
    3. 시간 복잡도를 O(n)으로 줄일 수 있어 효율적
 */

public class TwoPointer {
    private static boolean hashPairWithSum(int[] arr, int targer) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int sum = arr[start] + arr[end];

            if (sum == targer) return true;
            
            if (sum < targer) {
                start++;
            } else {
                end--;
            }
        }

        return false;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5, 7, 9, 11};
        int targer = 10;

        boolean result = hashPairWithSum(arr, targer);
        
                System.out.println("Two Pointer");
        
                if (result) {
                    System.out.println("합이 " + targer + "인 쌍이 존재합니다.");
                } else {
                    System.out.println("합이 " + targer + "인 쌍이 존재하지 않습니다.");
                }
            }
}
