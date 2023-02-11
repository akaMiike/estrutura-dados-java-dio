package com.exercicio.dataStructures;

public class Queue<T>{

    private Node last;

    public Queue(){
        last = null;
    }

    private T first(){
        Node actual = last;
        while(actual.next != null){
             actual = actual.next;
        }

        return actual.content;
    }

    public void enqueue(T content){
        if(isEmpty())
            last = new Node(content);
        else{
            last = new Node(content, last);
        }
    }

    public T dequeue(){
        Node actual;

        if(isEmpty())
            return null;

        else if(last.next == null){
            actual = last;
            last = null;
            return actual.content;
        }

        else{
            actual = last;

            while(actual.next.next != null){
                 actual = actual.next;
            }

            Node dequeuedElement = actual.next;
            actual.next = null;

            return dequeuedElement.content;
        }
    }

    public Boolean isEmpty(){
        return last == null;
    }

    @Override
    public String toString(){
        String queueString = "--------Fila---------\n";
        Node noAtual = this.last;

        if(!isEmpty()){
            queueString += "{No = " + noAtual.content + "} -> ";

            while(noAtual.next != null){
                noAtual = noAtual.next;
                queueString += "{No = " + noAtual.content + "} -> ";
            }
        }
        queueString += "Fim da fila";
        queueString += "\n---------------------";
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
