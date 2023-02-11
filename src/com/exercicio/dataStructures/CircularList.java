package com.exercicio.dataStructures;

public class CircularList<T> {

    private Node head;
    private Node tail;

    public CircularList(){
        tail = null;
    }

    public T tail(){
        return tail.content;
    }

    public Boolean isEmpty(){
        return tail == null;
    }

    public int size(){
        int size = 0;

        if(isEmpty())
            return size;

        Node actual = tail; size++;
        while(actual.next != head){
            actual = actual.next;
            size++;
        }

        return size;
    }

    private Node getNo(int index){
        if(index >= size() || index < 0){
            throw new IndexOutOfBoundsException("Índice não pertence a lista.");
        }

        Node actual = tail;
        for(int i = 0; i < index; i++){
            actual = actual.next;
        }
        return actual;
    }

    public T get(int index){
        return getNo(index).content;
    }

    public void add(T content){
        add(content, size());
    }

    public void add(T content, int index){
        Node newNode = new Node(content);

        if(index == 0){
            if(isEmpty()){
                head = newNode;
                tail = newNode;
            }

            newNode.next = tail;
            tail = newNode;
            head.next = tail;
        }
        else{
            Node lastNode = getNo(index-1);
            newNode.next = lastNode.next;
            lastNode.next = newNode;
        }
    }

    public T remove(int index){
        Node nodeRemoved;

        if(index == 0){
            nodeRemoved = getNo(index);
            tail = tail.next;
            head.next = tail;
            return nodeRemoved.content;
        }

        Node previousNode = getNo(index-1);
        nodeRemoved = previousNode.next;
        previousNode.next = nodeRemoved.next;

        if(index == size()-1)
            head = previousNode;

        return nodeRemoved.content;
    }

    @Override
    public String toString(){
        String queueString = "------Lista circular------\n";
        queueString += "Cauda --> ";

        Node noAtual = this.tail;

        if(!isEmpty()){
            queueString += "{No = " + noAtual.content + "} --> ";

            while(noAtual.next != tail){
                noAtual = noAtual.next;
                queueString += "{No = " + noAtual.content + "} --> ";
            }
        }
        queueString += "Cabeça";
        queueString += "\n--------------------------";
        return queueString;
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
