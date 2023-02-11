package com.exercicio;

public class LinkedList<T> {

    private Node first;

    public LinkedList(){}

    public int length(){
        int length = 0;

        if(isEmpty())
            return length;

        Node actual = first;
        length++;

        while(actual.next != null){
            actual = actual.next;
            length++;
        }

        return length;
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
        if(index <= length() && index >= 0){
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
        add(conteudo, length());
    }

    public void remove(int index){
        if(isIndexOutOfBounds(index))
            throw new IndexOutOfBoundsException("Índice está fora da lista.");

        if(index == 0){
            first = first.next;
        }
        else{
            Node actual = first;
            for(int i = 0; i < index-1; i++){
                actual = actual.next;
            }

            actual.next = actual.next.next;
        }
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
        return index >= length() || index < 0;
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
