import java.util.*;

class Graph {
    private LinkedList<Integer>[] adjList;
    private int nodeCount;

    // 인접 리스트 초기화
    @SuppressWarnings("unchecked")  // 경고 무시하는 애노테이션
    Graph(int nodeCount) {
        this.nodeCount = nodeCount;
        adjList = new LinkedList[nodeCount + 1]; // 노드 번호가 1부터 시작하므로 크기를 nodeCount + 1로 설정

        for (int i = 0; i <= nodeCount; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    // 노드 간 관계 형성 (간선 추가)
    void addEdge(int node1, int node2) {
        adjList[node1].add(node2);
        adjList[node2].add(node1); // 무방향 그래프이므로 양쪽 간선을 모두 추가
    }

    // DFS 탐색
    void DFS(int startNode) {
        boolean[] visited = new boolean[nodeCount + 1];
        DFS_Visit(startNode, visited);
    }

    private void DFS_Visit(int node, boolean[] visited) {
        visited[node] = true;
        System.out.print(node + " ");

        // 작은 노드부터 방문하기 위해 정렬
        Collections.sort(adjList[node]);

        for (int nextNode : adjList[node]) {
            if (!visited[nextNode]) {
                DFS_Visit(nextNode, visited);
            }
        }
    }

    // BFS 탐색
    void BFS(int startNode) {
        boolean[] visited = new boolean[nodeCount + 1];
        Queue<Integer> queue = new LinkedList<>();
        visited[startNode] = true;
        queue.add(startNode);

        System.out.println();

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            System.out.print(currentNode + " ");

            // 작은 노드부터 방문하기 위해 정렬
            Collections.sort(adjList[currentNode]);

            for (int nextNode : adjList[currentNode]) {
                if (!visited[nextNode]) {
                    visited[nextNode] = true;
                    queue.add(nextNode);
                }
            }
        }
    }
}

public class P1260 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nodeCount = sc.nextInt(); // 노드 개수
        int edgeCount = sc.nextInt(); // 간선 개수
        int startNode = sc.nextInt(); // 시작 노드 번호

        Graph graph = new Graph(nodeCount);

        for (int i = 0; i < edgeCount; i++) {
            int node1 = sc.nextInt();
            int node2 = sc.nextInt();
            graph.addEdge(node1, node2);
        }

        // DFS 실행
        graph.DFS(startNode);
        
        // BFS 실행
        graph.BFS(startNode);
        
        sc.close();
    }
}
