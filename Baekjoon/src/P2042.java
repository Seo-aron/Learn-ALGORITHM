import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2042 {
    static long[] leafNode;
    static long[] treeNode;

    public static long sum(int node, int start, int end, int firstNode, int secondNode){
        if (secondNode < start || firstNode > end){
            return 0;
        }

        if (firstNode <= start && secondNode >= end) {
            return treeNode[node];
        }

        int mid = (start + end) / 2;

        return sum(node * 2, start, mid, firstNode, secondNode)
                + sum(node * 2 + 1, mid + 1, end, firstNode, secondNode);
    }

    public static void update(int node, int start, int end, int original, long diff){
        if (original < start || original > end){
            return;
        }

        int mid = (start + end) / 2;

        treeNode[node] += diff;

        if (start == end) {
            return;
        }

        if (original <= mid) update(node * 2, start, mid, original, diff);
        else update(node * 2 + 1, mid + 1, end, original, diff);
    }

    public static long init(int node, int start, int end){
        if (start == end) {
            return treeNode[node] = leafNode[start];
        }

        int mid = (start + end) / 2;

        return treeNode[node] = init(node * 2, start, mid) + init(node * 2 + 1, mid + 1, end);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = Integer.parseInt(st.nextToken());
        int numUpdate = Integer.parseInt(st.nextToken());
        int numSum = Integer.parseInt(st.nextToken());
        leafNode = new long[count + 1];
        treeNode = new long[count * 4];

        for (int i = 1; i <= count; i++){
            leafNode[i] = Long.parseLong(br.readLine());
        }

        init(1, 1, count);

        for (int i = 0; i < numSum + numUpdate; i++){
            st = new StringTokenizer(br.readLine());
            int option = Integer.parseInt(st.nextToken());

            switch (option){
                case 1:
                    int original = Integer.parseInt(st.nextToken());
                    long change = Long.parseLong(st.nextToken());
                    long diff = change - leafNode[original];
                    leafNode[original] = change;
                    update(1, 1, count, original, diff);
                    break;
                case 2:
                    int num1 = Integer.parseInt(st.nextToken());
                    int num2 = Integer.parseInt(st.nextToken());
                    System.out.println(sum(1, 1, count, num1, num2));
                    break;
            }
        }
    }
}
