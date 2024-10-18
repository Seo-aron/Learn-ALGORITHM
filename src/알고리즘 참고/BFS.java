import java.util.*;

class Graph {
    private LinkedList<Integer> adjList[];
    private int node_Number;

    // 인접 리스트 초기화
    @SuppressWarnings("unchecked")
    Graph(int node_Number) {
        this.node_Number = node_Number;
        adjList = new LinkedList[node_Number];

        for(int i = 0; i < node_Number; i++){
            adjList[i] = new LinkedList<Integer>();
        }
    }

    // 노드 간 관계 형성 (간선 추가)
    void addEdge(int node1, int node2) {
        adjList[node1].add(node2);
    }

    // BFS 실행문
    void BFS(int st_Node){
        // 방문한 노드 배열 생성, BFS큐 생성 후 시작노드 삽입
        boolean[] visited = new boolean[node_Number];
        Queue<Integer> BFS_queue = new LinkedList<>();
        visited[st_Node] = true;
        BFS_queue.add(st_Node);

        System.out.println("BFS 결과");

        while (!BFS_queue.isEmpty()) {  // 큐 안이 비어있다면 true
            int current_node = BFS_queue.poll();
            System.out.println(current_node);

            for(int nextnode : adjList[current_node]){
                if(!visited[nextnode]){
                    visited[nextnode] = true;
                    BFS_queue.add(nextnode);
                }
            }
        }
    }
          
}

public class BFS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print(("간선 개수 입력 : "));
        int edge = sc.nextInt(); // 간선 개수
        System.out.print(("노드 개수 입력 : "));
        int node = sc.nextInt(); // 노드 개수
        System.out.print(("시작 노드 입력 : "));
        int st_Node = sc.nextInt(); // 시작 노드 입력

        // 그래프 객체 생성
        Graph graph = new Graph(node);

        System.out.print(("노드 입력 : "));
        // 간선에 노드 추가
        for (int i = 0; i < edge; i++) {
            String edgeInput = sc.next(); // 간선 입력 예: "1,0"
            String[] nodes = edgeInput.split(","); // 쉼표로 분리

            int node1 = Integer.parseInt(nodes[0]); // 노드1
            int node2 = Integer.parseInt(nodes[1]); // 노드2

            graph.addEdge(node1, node2); // 그래프에 간선 추가
        }

        graph.BFS(st_Node);
        System.out.println();
        sc.close();
    }
}
