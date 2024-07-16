package org.example;

public class Main {
    public static void main(String[] args) {
        HashTable<String, Integer> ht = new HashTable<>(10);

        ht.put("Cat", 1);
        ht.put("Dog", 2);
        ht.put("Rabbit", 3);

        System.out.println("Hash-table size: " + ht.size());
        System.out.println("Key value Dog: " + ht.get("Dog"));

        ht.remove("Dog");

        System.out.println("Hash-table size: " + ht.size());
        System.out.println("Key value Dog: " + ht.get("Dog"));
    }
}
