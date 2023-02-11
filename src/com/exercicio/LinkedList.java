package com.exercicio;

public class LinkedList<T> {

    private Node first;

    public LinkedList(){}

    public int size(){
        int size = 0;

        if(isEmpty())
            return size;

        Node actual = first;
        size++;

        while(actual.next != null){
            actual = actual.next;
            size++;
        }

        return size;
    }

    public T get(int index){
        if(!isIndexOutOfBounds(index)){
            Node actual = first;
            for(int i = 0; i < index; i++){
                actual = actual.next;
            }
            return actual.content;
        }
        else{
            throw new IndexOutOfBoundsException("Índice está fora da lista.");
        }
    }

    public void add(T conteudo, int index){
        if(index <= size() && index >= 0){
            Node actual = first;

            for(int i = 0; i < index-1; i++){
                actual = actual.next;
            }

            if(index == 0)
                first = new Node(conteudo);
            else
                actual.next = new Node(conteudo, actual.next);
        }
        else{
            throw new IndexOutOfBoundsException("Índice está fora da lista.");
        }
    }

    public void add(T conteudo){
        add(conteudo, size());
    }

    public T remove(int index){
        if(isIndexOutOfBounds(index))
            throw new IndexOutOfBoundsException("Índice está fora da lista.");

        Node removedNode;

        if(index == 0){
            removedNode = first;
            first = first.next;
        }
        else{
            Node actual = first;
            for(int i = 0; i < index-1; i++){
                actual = actual.next;
            }

            removedNode = actual.next;
            actual.next = actual.next.next;
        }

        return removedNode.content;
    }

    public Boolean isEmpty(){
        return first == null;
    }

    @Override
    public String toString(){
        String queueString = "---Lista encadeada---\n";
        Node noAtual = this.first;

        if(!isEmpty()){
            queueString += "{No = " + noAtual.content + "} -> ";

            while(noAtual.next != null){
                noAtual = noAtual.next;
                queueString += "{No = " + noAtual.content + "} -> ";
            }
        }
        queueString += "Fim da lista";
        queueString += "\n---------------------";
        return queueString;
    }

    private Boolean isIndexOutOfBounds(int index){
        return index >= size() || index < 0;
    }

    private class Node{
        public T content;
        public Node next;

        public Node(T content){
            this.content = content;
            this.next = null;
        }

        public Node(T content, Node proxNo){
            this.content = content;
            this.next = proxNo;
        }
    }
}
