package com.exercicio;

public class DoublyLinkedList<T> {

    private Node first;
    private Node last;

    public DoublyLinkedList(){
        first = null;
        last = null;
    }

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

    public Boolean isEmpty(){
        return first == null;
    }

    public T get(int index){
        return getNo(index).content;
    }

    public T remove(int index){
        Node removedNode = getNo(index);

        Node previousNode = removedNode.previous;
        Node nextNode = removedNode.next;

        if(previousNode != null)
            previousNode.next = nextNode;
        else
            first = nextNode;

        if(nextNode != null)
            nextNode.previous = previousNode;
        else
            last = previousNode;

        return removedNode.content;
    }

    public void add(T content){
        add(content, size());
    }

    public void add(T content, int index){
        if(index == 0){
            Node newNode = new Node(content, first, null);
            first = newNode; last = newNode;
        }
        else if(index == size()){
            Node newNode = new Node(content, null, last);
            last.next = newNode;
            last = newNode;
        }
        else{
            Node actual = getNo(index);
            Node previous = actual.previous;

            Node newNode = new Node(content, actual, previous);

            previous.next = newNode;
            actual.previous = newNode;
        }
    }

    @Override
    public String toString(){
        String queueString = "--Lista duplamente encadeada--\n";
        Node noAtual = this.first;

        if(!isEmpty()){
            queueString += "{No = " + noAtual.content + "} <--> ";

            while(noAtual.next != null){
                noAtual = noAtual.next;
                queueString += "{No = " + noAtual.content + "} <--> ";
            }
        }
        queueString += "Fim da lista";
        queueString += "\n------------------------------";
        return queueString;
    }

    private Node getNo(int index){
        if(index >= size() || index < 0){
            throw new IndexOutOfBoundsException("Índice não pertence a lista.");
        }

        Node actual = first;
        for(int i = 0; i < index; i++){
            actual = actual.next;
        }
        return actual;
    }

    private class Node{
        public T content;
        public Node next;
        public Node previous;

        public Node(T content){
            this.content = content;
            this.next = null;
            this.previous = null;
        }

        public Node(T content, Node prox, Node anterior){
            this.content = content;
            this.next = prox;
            this.previous = anterior;
        }
    }
}
