/*
    이분 탐색 (Binary Search)
    - 정렬된 배열에서 특정 값을 빠르게 찾는 알고리즘
    - 탐색 범위를 반씩 줄여가며 원하는 값을 탐색
    - 시간 복잡도 O(log n)으로 매우 효율적

    - 동작 방식
    1. 시작 인덱스 left와 끝 인덱스 right를 설정
    2. 중간값 mid를 계산하고, 원하는 값과 비교
    3. 값이 mid보다 작으면 범위를 왼쪽으로, 크면 오른쪽으로 이동
    4. 값이 일치하면 해당 인덱스를 반환, 없으면 -1 반환
 */

 public class BinarySearch {
    // target 값을 이분 탐색으로 찾는 함수
    private static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2; // 중간 인덱스 계산

            if (arr[mid] == target) {
                return mid; // 값을 찾았을 때 인덱스 반환
            } else if (arr[mid] < target) {
                left = mid + 1; // target이 더 크면 오른쪽 탐색
            } else {
                right = mid - 1; // target이 더 작으면 왼쪽 탐색
            }
        }

        return -1; // 값을 찾지 못한 경우
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11, 13}; // 오름차순 정렬된 배열
        int target = 7;

        // 이분 탐색 수행
        int result = binarySearch(arr, target);

        // 결과 출력
        System.out.println("Binary Search");
        if (result != -1) {
            System.out.println("값 " + target + "는(은) 인덱스 " + result + "에 있습니다.");
        } else {
            System.out.println("값 " + target + "를(을) 찾을 수 없습니다.");
        }
    }
}
