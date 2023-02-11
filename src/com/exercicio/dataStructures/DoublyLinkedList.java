package com.exercicio.dataStructures;

public class DoublyLinkedList<T> {

    private Node first;
    private Node last;

    public DoublyLinkedList(){
        first = null;
        last = null;
    }

    public T first(){
        return first.content;
    }

    public T last(){
        return last.content;
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
        Node newNode;

        if(index == 0){
            newNode = new Node(content, first, null);
            if(isEmpty())
                last = newNode;

            first = newNode;
        }
        else if(index == size()){
            newNode = new Node(content, null, last);
            last.next = newNode;
            last = newNode;
        }
        else{
            Node previous = getNo(index-1);
            Node actual = previous.next;

            newNode = new Node(content, actual, previous);

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
