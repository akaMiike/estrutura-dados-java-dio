package com.exercicio.dataStructures;

public class BinaryTree<T extends Comparable<T>>{

    private Node root;

    public BinaryTree(){
        root = null;
    }

    public T getRoot(){
        return root.content;
    }

    public T get(T content){
        return getNode(new Node(content), root).content;
    }

    private Node getNode(Node node, Node subTreeRoot){
        if(subTreeRoot == null)
            return null;
        else if(subTreeRoot.compareTo(node.content) == 0)
            return subTreeRoot;
        else if(subTreeRoot.compareTo(node.content) < 0)
            return getNode(node, subTreeRoot.dir);
        else
            return getNode(node, subTreeRoot.esq);
    }

    public void add(T content){
        root = add(new Node(content), root);
    }

    private Node add(Node newNode, Node subTreeRoot){
        if(subTreeRoot == null)
            return newNode;
        else if(subTreeRoot.compareTo(newNode.content) < 0){
            subTreeRoot.dir = add(newNode, subTreeRoot.dir);
            subTreeRoot.dir.pai = subTreeRoot;
        }
        else{
            subTreeRoot.esq = add(newNode, subTreeRoot.esq);
            subTreeRoot.esq.pai = subTreeRoot;
        }

        return subTreeRoot;
    }

    private Boolean isLeaf(Node n){
        return n.dir == null && n.esq == null;
    }

    private Node getSuccessor(Node actual){
        Node successor = actual.dir;

        if(successor == null){
            successor = actual.pai;

            while(successor != null){
                if(successor.compareTo(actual.content) > 0){
                    return successor;
                }
                successor = successor.pai;
            }
        }
        else{
            while(successor.esq != null){
                successor = successor.esq;
            }
        }

        return successor;
    }

    public void remove(T content){
        Node nodeToRemove = getNode(new Node(content), root);
        if(nodeToRemove != null)
            remove(nodeToRemove);
    }

    public void remove(Node removedNode){
        if(isLeaf(removedNode)){
            if(root.compareTo(removedNode.content) == 0)
                root = null;
            else{
                if(removedNode.pai.dir.compareTo(removedNode.content) == 0)
                    removedNode.pai.dir = null;
                else if(removedNode.pai.esq.compareTo(removedNode.content) == 0)
                    removedNode.pai.esq = null;

                removedNode.pai = null;
            }
        }
        else if(removedNode.esq !=  null && removedNode.dir == null){

            if(removedNode != root){
                if(removedNode.pai.dir.compareTo(removedNode.content) == 0)
                    removedNode.pai.dir = removedNode.esq;
                else if(removedNode.pai.esq.compareTo(removedNode.content) == 0)
                    removedNode.pai.esq = removedNode.esq;
            }
            else{
                root = removedNode.esq;
            }

            removedNode.esq.pai = removedNode.pai;
        }
        else{
            Node successor = getSuccessor(removedNode);

            if(removedNode != root){
                if(removedNode.pai.dir != null && removedNode.pai.dir.compareTo(removedNode.content) == 0)
                    removedNode.pai.dir = successor;
                else if(removedNode.pai.esq != null && removedNode.pai.esq.compareTo(removedNode.content) == 0)
                    removedNode.pai.esq = successor;
            }
            else{
                root = successor;
            }

            if(!isLeaf(successor)){
                if(removedNode.dir != successor){
                    successor.dir.pai = successor.pai;
                    successor.pai.esq = successor.dir;
                }
            }
            else{
                successor.pai.esq = null;
            }

            successor.pai = removedNode.pai;
            successor.esq = removedNode.esq;

            if(removedNode.dir != successor)
                successor.dir = removedNode.dir;
            if(removedNode.esq != null)
                removedNode.esq.pai = successor;
            if(removedNode.dir != null)
                removedNode.dir.pai = successor;
        }
    }

    public void showOrder(int option){
        System.out.println("-----Árvore binária------");
        switch(option){
            case 0:
                System.out.println("--------Pre ordem--------");
                showPreOrder(root);
                break;
            case 1:
                System.out.println("--------Em ordem---------");
                showInOrder(root);
                break;
            case 2:
                System.out.println("--------Pós ordem--------");
                showPosOrder(root);
                break;
            default:
                System.out.println("Opção inserida não é valida.");
                break;
        }
        System.out.println("--------------------------");
    }

    public void showInOrder(Node root){
        if(root != null){
            showInOrder(root.esq);
            System.out.println("Elemento: " + root.content);
            showInOrder(root.dir);
        }
    }

    public void showPreOrder(Node root){
        if(root != null){
            System.out.println(root.content);
            showPreOrder(root.esq);
            showPreOrder(root.dir);
        }
    }

    public void showPosOrder(Node root){
        if(root != null){
            showPosOrder(root.esq);
            showPosOrder(root.dir);
            System.out.println(root.content);
        }
    }

    private class Node implements Comparable<T>{
        T content;
        Node pai;
        Node esq;
        Node dir;

        public Node(T content){
            this.content = content;
            this.esq = this.dir = this.pai = null;
        }

        public Node(T content, Node esq, Node dir, Node pai){
            this.content = content;
            this.esq = esq;
            this.dir = dir;
            this.pai = pai;
        }

        @Override
        public int compareTo(T t) {
            return content.compareTo(t);
        }
    }
}
