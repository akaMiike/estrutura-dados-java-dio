package com.exercicio;

public class Stack<T> {
    private No topo;

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

        T poppedNo = topo.conteudo;
        this.topo = topo.proxNo;

        return poppedNo;
    }

    public T top(){
        if(isEmpty())
            return null;

        return topo.conteudo;
    }

    public void push(T conteudo){
        if(topo == null){
            topo = new No(conteudo);
        }
        else{
            topo = new No(conteudo, topo);
        }
    }

    @Override
    public String toString(){
        String stackString = "";
        No noAtual = this.topo;

        if(!isEmpty())
            stackString += "{No = " + noAtual.conteudo + " }";

        while(noAtual.proxNo != null){
            noAtual = noAtual.proxNo;
            stackString += "\n";
            stackString += "{No = " + noAtual.conteudo + " }";
        }

        return stackString;
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
