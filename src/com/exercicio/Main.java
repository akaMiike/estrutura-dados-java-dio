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
        System.out.println("Topo atual: " + topo);

        pilha.pop();
        String novoTopo = pilha.top();

        Queue<String> queue = new Queue<>();
        System.out.println(queue);

        queue.enqueue("Nova string 1");
        queue.enqueue("Nova string 2");
        System.out.println(queue);

    }
}
