/*
    세그먼트 트리 (Segment Tree)
    - 구간 합, 최솟값, 최댓값 등 배열의 특정 범위에 대한 질의를 빠르게 수행하기 위한 자료구조
      (시간 복잡도 : O(log N)으로 업데이트와 질의 가능)

    - 동작 방식
    1. 트리의 각 노드는 배열의 특정 구간 정보를 저장
    2. 리프 노드는 입력 배열의 각 원소를 저장
    3. 내부 노드는 자식 노드의 정보를 이용해 부모 노드 계산
    4. 구간 질의와 업데이트는 재귀적으로 수행
 */

public class SegmentTree {
    private int[] tree;
    private int n;

    public SegmentTree(int[] arr){
        n = arr.length;
        tree = new int[n * 4];
        build(arr, 0, n - 1, 1);
    }

    // 세그먼트 트리 구축
    private void build(int[] arr, int start, int end, int node){
        if (start == end) {
            tree[node] = arr[start];
            return;
        }

        int mid = (start + end) / 2;
        build(arr, start, mid, node * 2);
        build(arr, mid + 1, end, node * 2 + 1);

        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }

    // 구간 합 질의
    public int query(int left, int right){
        return query(0, n - 1, left, right, 1);
    }

    private int query(int start, int end, int left, int right, int node){
        if (right < start || end < left) return 0;              // 범위를 벗어난 경우
        if (left <= start && end <= right) return tree[node];   // 구간에 완전히 포함된 경우

        int mid = (start + end) / 2;
        
        return query(start, mid, left, right, node * 2) 
                + query(mid + 1, end, left, right, node * 2 + 1);
    }

    // 값 업데이트
    public void update(int index, int value){
        update(0, n - 1, index, value, 1);
    }

    private void update(int start, int end, int index, int value, int node){
        if (index < start || index > end) return;

        if (start == end) {
            tree[node] = value;
            return;
        }

        int mid = (start + end) / 2;

        update(start, mid, index, value, node * 2);
        update(mid + 1, end, index, value, node * 2 + 1);

        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        SegmentTree st = new SegmentTree(arr);

        System.out.println("Segment Tree");
        System.out.println("구간 합 (2 ~ 5): " + st.query(2, 5));   // 3 + 4 + 5 + 6 = 18

        st.update(3, 10);   // arr[3] = 10
        System.out.println("구간 합 (2 ~ 5): " + st.query(2, 5));   // 3 + 10 + 5 + 6 = 24
    }
}
