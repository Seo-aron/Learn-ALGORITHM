/*
    DFS(Depth-First Search), BFS(Breadth-First Search)
    
    - DFS (깊이 우선 탐색) : 그래프에서 한 노드에서 출발하여 갈 수 있는 곳까지 한 방향으로 탐색한 후,
                           더 이상 갈 곳이 없으면 되돌아가면서 탐색하는 방식 (재귀 또는 스택 사용)
    
    - BFS (너비 우선 탐색) : 시작 노드에서 가까운 노드부터 탐색하며, 한 레벨씩 넓혀가면서 탐색하는 방식 (큐 사용)
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Graph {
   // DFS 재귀 방식
   public static void dfsRecursive(List<List<Integer>> graph, boolean[] visited, int node){
      visited[node] = true;
      System.out.println(node + " ");

      for(int next : graph.get(node)){
         if (!visited[next]) {
            dfsRecursive(graph, visited, next);
         }
      }
   }
    public static void main(String[] args) {
        int node = 6;
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < node; i++){
         graph.add(new ArrayList<>());
        }
        
        // 간선 관계 : 0-1, 0-2, 1-3, 1-4, 2-4, 3-5, 4-5
        graph.get(0).addAll((Arrays.asList(1, 2)));
        graph.get(1).addAll((Arrays.asList(0, 3, 4)));
        graph.get(2).addAll((Arrays.asList(0, 4)));
        graph.get(3).addAll((Arrays.asList(1, 5)));
        graph.get(4).addAll((Arrays.asList(1, 2, 5)));
        graph.get(5).addAll((Arrays.asList(3, 4)));

        System.out.println("DFS 재귀 방식");
        dfsRecursive(graph, new boolean[node], 0);
        
    }
 }