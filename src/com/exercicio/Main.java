package com.exercicio;

public class Main {

    public static void main(String[] args) throws Exception {
	    Stack<String> pilha = new Stack<>();

        pilha.newNode("Primeiro elemento");
        pilha.newNode("Segundo elemento");
        pilha.showStack();

        String topo = pilha.top();
        System.out.println("Topo: " + topo);

        pilha.pop();
        String novoTopo = pilha.top();
        System.out.println("Topo apos remover o topo: " + novoTopo);
    }
}
