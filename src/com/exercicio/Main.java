package com.exercicio;

public class Main {

    public static void main(String[] args){
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

        Queue<String> queue = new Queue<>();
        System.out.println(queue);

        queue.enqueue("Primeiro");
        queue.enqueue("Segundo");
        queue.enqueue("Terceiro");
        System.out.println(queue);
        queue.dequeue();

        System.out.println("Fila após dequeue");
        System.out.println(queue);


        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("New string 1",0);
        linkedList.add("New string 2",1);
        linkedList.add("New string 3",2);

        linkedList.remove(2);
        System.out.println(linkedList);

        DoublyLinkedList<String> doublyLinkedList = new DoublyLinkedList<>();
        doublyLinkedList.add("String 1",0);
        doublyLinkedList.add("String 2",1);
        doublyLinkedList.add("String 3",2);

        doublyLinkedList.remove(1);
        System.out.println(doublyLinkedList);
    }
}
