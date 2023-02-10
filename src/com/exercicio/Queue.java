package com.exercicio;

public class Queue<T>{

    private Node first;

    public Queue(){
        first = null;
    }

    private T first(){
        Node actual = first;
        while(actual.nextRef != null){
             actual = actual.nextRef;
        }

        return actual.content;
    }

    public void enqueue(T content){
        if(isEmpty())
            first = new Node(content);

        Node actual = this.first;
        while(actual.nextRef != null){
            actual = actual.nextRef;
        }

        first = new Node(content, actual);
    }

    public T dequeue(){
        Node actual;

        if(isEmpty())
            return null;

        else if(first.nextRef == null){
            actual = first;
            first = null;
            return actual.content;
        }

        else{
            actual = first;
            while(actual.nextRef.nextRef != null){
                 actual = actual.nextRef;
            }

            Node dequeuedElement = actual.nextRef;
            actual.nextRef = null;

            return dequeuedElement.content;
        }
    }

    public Boolean isEmpty(){
        return first == null;
    }

    @Override
    public String toString(){
        String queueString = "--------Fila--------\n";
        Node noAtual = this.first;

        if(!isEmpty()){
            queueString += "{No = " + noAtual.content + "}";

            while(noAtual.nextRef != null){
                noAtual = noAtual.nextRef;
                queueString += "\n";
                queueString += "{No = " + noAtual.content + "}";
            }
        }

        queueString += "\n---------------------";
        return queueString;
    }

    private class Node{
        public T content;
        public Node nextRef;

        public Node(T content){
            this.content = content;
            this.nextRef = null;
        }

        public Node(T content, Node proxNo){
            this.content = content;
            this.nextRef = proxNo;
        }
    }
}
