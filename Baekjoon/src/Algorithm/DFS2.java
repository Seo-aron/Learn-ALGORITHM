package Algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DFS2 {
    public static void main(String[] arg){
        List<LinkedList<Integer>> linkedLists = new ArrayList<>(9);
        boolean[] isVisited = new boolean[9];

        for(int i = 0; i < 9; i++){
            linkedLists.add(new LinkedList<>());
            isVisited[i] = false;
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

        System.out.println("DFS Example");

        DepthFirstSearch(linkedLists, isVisited, 1);
    }

    public static void DepthFirstSearch(List<LinkedList<Integer>> linkedList, boolean[] isVisited, int currentNode){
        if(!isVisited[currentNode]){
            System.out.println("currentNode = " + currentNode);
            isVisited[currentNode] = true;
        }

        for(int i = 0; i < linkedList.get(currentNode).size(); i++){
            int nextNode = (int) linkedList.get(currentNode).get(i);
            if(!isVisited[nextNode]){
                DepthFirstSearch(linkedList, isVisited, nextNode);
            }
        }
    }
}
