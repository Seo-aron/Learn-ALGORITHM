package Algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS2 {
    public static void main(String[] args) {
        List<LinkedList<Integer>> linkedLists = new ArrayList<>(9);

        for(int i = 0; i < 9; i++){
            linkedLists.add(new LinkedList<>());
        }

        linkedLists.get(1).add(2);
        linkedLists.get(1).add(3);
        linkedLists.get(1).add(8);
        linkedLists.get(2).add(1);
        linkedLists.get(2).add(7);
        linkedLists.get(3).add(1);
        linkedLists.get(3).add(4);
        linkedLists.get(3).add(5);
        linkedLists.get(4).add(3);
        linkedLists.get(4).add(5);
        linkedLists.get(5).add(3);
        linkedLists.get(5).add(4);
        linkedLists.get(6).add(7);
        linkedLists.get(7).add(2);
        linkedLists.get(7).add(6);
        linkedLists.get(7).add(8);
        linkedLists.get(8).add(1);
        linkedLists.get(8).add(7);

        BreadthFirstSearch(linkedLists);
    }

    public static void BreadthFirstSearch(List<LinkedList<Integer>> linkedList){
        boolean[] isVisited = new boolean[linkedList.size()];

        for(int i = 0; i < linkedList.size(); i++){
            isVisited[i] = false;
        }

        Queue<Integer> queue = new LinkedList<>();
        int currentNode = 1;
        int nextNode = 0;

        queue.add(currentNode);
        isVisited[currentNode] = true;

        while(!queue.isEmpty()){
            currentNode = queue.remove();
            System.out.println("currentNode = " + currentNode);

            for(int i = 0; i < linkedList.get(currentNode).size(); i++){
                nextNode = linkedList.get(currentNode).get(i);
                if(!isVisited[nextNode]){
                    queue.add(nextNode);
                    isVisited[nextNode] = true;
                }
            }
        }
    }
}
