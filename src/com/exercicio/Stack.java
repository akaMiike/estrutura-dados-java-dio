package com.exercicio;

public class Stack<T> {
    private No topo;

    public Stack(){}

    public void pop() throws Exception{
        if(topo == null)
            throw new Exception("Não foi possível remover o topo pois a pilha está vazia.");

        this.topo = topo.proxNo;
    }

    public T top() throws Exception{
        if(topo == null)
            throw new Exception("Não há elementos na pilha");

        return topo.conteudo;
    }

    public void newNode(T conteudo){
        if(topo == null){
            topo = new No(conteudo);
        }
        else{
            topo = new No(conteudo, topo);
        }
    }

    public void showStack(){
        No noAtual = this.topo;
        System.out.println("Elementos da pilha: ");
        System.out.println(noAtual.conteudo);

        while(noAtual.proxNo != null){
            noAtual = noAtual.proxNo;
            System.out.println(noAtual.conteudo);
        }

        System.out.println("Fim da pilha.");
    }

    private class No{
        public T conteudo;
        public No proxNo;

        public No(T conteudo){
            this.conteudo = conteudo;
            this.proxNo = null;
        }

        public No(T conteudo, No proxNo){
            this.conteudo = conteudo;
            this.proxNo = proxNo;
        }
    }

}
