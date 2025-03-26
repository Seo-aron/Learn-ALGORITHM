/*
    해시 테이블 (Hash Table)
    - 키(Key)를 이용해 값을 빠르게 저장하고 검색할 수 있는 자료구조
      (평균 시간 복잡도: O(1)로 삽입, 삭제, 검색 가능)

    - 동작 방식
    1. 키를 해시 함수에 입력해 해시값을 생성
    2. 해시값을 배열의 인덱스로 변환해 해당 위치에 데이터 저장
    3. 충돌(해시 충돌) 발생 시 체이닝(Chaining) 또는 개방 주소법(Open Addressing)으로 처리
 */

import java.util.LinkedList;

public class HashTable<K, V> {
    private static class Node<K, V> {
        K key;
        V value;

        Node(K key, V value){
            this.key = key;
            this.value = value;
        }
    }

    private LinkedList<Node<K, V>>[] table;
    private int size;

    public HashTable(int capacity){
        table = new LinkedList[capacity];
        size = capacity;
    }

    // 해시 함수
    private int hash(K key){
        return Math.abs(key.hashCode()) % size;
    }

    // 삽입
    public void put(K key, V value) {
        int index = hash(key);

        if (table[index] == null) {
            table[index] = new LinkedList<>();
        }

        for (Node<K, V> node : table[index]){
            if (node.key.equals(key)) {
                // 이미 존재하면 업데이트
                node.value = value;
                return;
            }
        }

        table[index].add(new Node<>(key, value));
    }

    // 검색
    public V get(K key){
        int index = hash(key);

        if (table[index] == null) return null;

        for (Node<K, V> node : table[index]){
            if (node.key.equals(key)) {
                return node.value;
            }
        }

        // 존재하지 않으면
        return null;
    }

    // 삭제
    public void remove(K key){
        int index = hash(key);

        if (table[index] == null) return;

        table[index].removeIf(node -> node.key.equals(key));
    }

    public static void main(String[] args) {
        HashTable<String, Integer> hashTable = new HashTable<>(10);

        System.out.println("Hash Table");

        hashTable.put("apple", 5);
        hashTable.put("banana", 3);
        hashTable.put("orange", 7);

        System.out.println("apple: " + hashTable.get("apple"));
        System.out.println("banana: " + hashTable.get("banana"));

        hashTable.remove("banana");
        System.out.println("banana: " + hashTable.get("banana"));
    }
}
