package com.exercicio;

public class Stack<T> {
    private Node topo;

    public Stack(){
        this.topo = null;
    }

    public Boolean isEmpty(){
        return topo == null;
    }

    public T pop(){
        if(topo == null) {
            return null;
        }

        T poppedNo = topo.content;
        this.topo = topo.next;

        return poppedNo;
    }

    public T top(){
        if(isEmpty())
            return null;

        return topo.content;
    }

    public void push(T conteudo){
        if(topo == null){
            topo = new Node(conteudo);
        }
        else{
            topo = new Node(conteudo, topo);
        }
    }

    @Override
    public String toString(){
        String stackString = "--------Pilha--------\n";
        Node noAtual = this.topo;

        if(!isEmpty()){
            stackString += "{No = " + noAtual.content + "}";

            while(noAtual.next != null){
                noAtual = noAtual.next;
                stackString += "\n";
                stackString += "{No = " + noAtual.content + "}";
            }
        }

        stackString += "\n---------------------";
        return stackString;
    }

    private class Node{
        public T content;
        public Node next;

        public Node(T content){
            this.content = content;
            this.next = null;
        }

        public Node(T conteudo, Node next){
            this.content = conteudo;
            this.next = next;
        }
    }

}
