package com.exercicio.dataStructures;

public class DataStructureTests {

    public static void showBinaryTreeTests(){
        BinaryTree<Integer> binaryTree = new BinaryTree<>();
        binaryTree.add(69);
        binaryTree.add(15);
        binaryTree.add(55);
        binaryTree.add(33);
        binaryTree.add(66);
        binaryTree.add(68);
        binaryTree.add(67);
        binaryTree.add(56);
        binaryTree.add(57);

        System.out.println(binaryTree.get(56));
        System.out.println(binaryTree.get(69));
        binaryTree.remove(69);
        binaryTree.remove(55);
        binaryTree.remove(56);
        binaryTree.remove(57);
        binaryTree.remove(15);
        binaryTree.showOrder(0);
        binaryTree.showOrder(1);
        binaryTree.showOrder(2);
    }

    public static void showCircularLinkedListTests(){
        CircularList<String> circularList = new CircularList<>();
        circularList.add("Element 1",0);
        circularList.add("Element 2",1);
        circularList.add("Element 3",1);

        System.out.println(circularList);

    }

    public static void showDoublyLinkedListTests(){
        DoublyLinkedList<String> doublyLinkedList = new DoublyLinkedList<>();
        doublyLinkedList.add("String 1",0);
        doublyLinkedList.add("String 2",1);
        doublyLinkedList.add("String 3",2);

        doublyLinkedList.remove(1);
        System.out.println(doublyLinkedList);
    }

    public static void showLinkedListTests(){
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("New string 1",0);
        linkedList.add("New string 2",1);
        linkedList.add("New string 3",2);

        linkedList.remove(2);
        System.out.println(linkedList);
    }

    public static void showQueueTests(){
        Queue<String> queue = new Queue<>();
        System.out.println(queue);

        queue.enqueue("Primeiro");
        queue.enqueue("Segundo");
        queue.enqueue("Terceiro");
        System.out.println(queue);
        queue.dequeue();

        System.out.println("Fila após dequeue");
        System.out.println(queue);

    }

    public static void showStackTest(){
        Stack<String> pilha = new Stack<>();
        String topo = pilha.pop();

        System.out.println("Topo vazio: " + topo);

        pilha.push("Primeiro elemento");
        pilha.push("Segundo elemento");
        System.out.println(pilha);

        topo = pilha.top();
        System.out.println("Topo atual da pilha: " + topo);

        pilha.pop();
        String novoTopo = pilha.top();
        System.out.println("Topo atual da pilha após pop: " + novoTopo);
    }
}
