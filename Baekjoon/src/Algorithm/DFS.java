package Algorithm;

import java.util.*;

class DFS_Graph {
    private LinkedList<Integer> adjList[]; // 인접 리스트
    private int Node_Number;    //  노드 개수

    // 인접 리스트 초기화
    @SuppressWarnings("unchecked")
    DFS_Graph(int Node_Number){
        this.Node_Number = Node_Number;
        adjList = new LinkedList[Node_Number]; // 배열 크기 설정

        for(int i = 0; i < Node_Number; i++){  // 각 노드마다 또 배열 초기화
            adjList[i] = new LinkedList<Integer>();
        }
    }
    // 노드간 관계형성
    void addList(int node1, int node2){
        adjList[node1].add(node2);
    }
    // 방문 여부 배열 만드는 함수
    void DFS(int st_node){
        boolean[] visited = new boolean[Node_Number];
        DFS_Visit(st_node, visited);
    }
    // 방문 한 곳 체크하는 재귀함수
    void DFS_Visit(int node, boolean[] visited){
        visited[node] = true;
        System.out.print(node + " ");

        // 모든 노드를 반복시켜, 이웃한 노드에 방문한 적 있는지를 체크
        // 방문을 했다면 종료, 안했다면 재귀해서 visited배열에 true값 넣음
        for(int nextnode : adjList[node]){
            if(!visited[nextnode]){
                DFS_Visit(nextnode, visited);
            }
        }
    }
}

public class DFS{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int edge = sc.nextInt();    // 간선 갯수
        int node = sc.nextInt();    // 노드 갯수

        // Graph       graph =  new     Graph    ()  ;
        // 자료형(클래스명) 객체명 = new예약어 클래스명 생성자호출;
        DFS_Graph graph = new DFS_Graph(node);

        // 간선에 노드 추가
        for(int i = 0; i < edge; i++){
            String edgeInput = sc.next();   // 간선 입력 예: "1,0"
            String[] nodes = edgeInput.split(",");   // 쉼표로 분리

            int node1 = Integer.parseInt(nodes[0]);   // 노드1
            int node2 = Integer.parseInt(nodes[1]);   // 노드2

            graph.addList(node1, node2);
        }
        int start_node = sc.nextInt(); // 시작 노드 
        System.out.println("DFS 결과");
        graph.DFS(start_node);
        System.out.println();

        sc.close();
    }
}