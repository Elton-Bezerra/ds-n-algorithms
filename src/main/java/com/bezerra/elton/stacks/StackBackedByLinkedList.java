package com.bezerra.elton.stacks;

class StackBackedByLinkedList {
    int size;
    Node top;
    Node bottom;
    
    StackBackedByLinkedList() {
        this.bottom = null;
        this.top = null;
        this.size = 0;    
    }
    
    Node peek() {
        return this.top;
    }
    
    void push(Node node) {
        if (this.bottom == null) {
            this.bottom = node;
            this.top = node;
        } else {
            this.top.setNext(node);
            this.top = node;
        }
        this.size++;
    }
    
    Node pop() {
        if (this.size == 0) {
            return null;
        }

        Node poppedNode = this.top;

        if (this.size == 1) {
            this.top = null;
            this.bottom = null;
        } else {
            Node current = this.bottom;
            while (current.getNext() != this.top) {
                current = current.getNext();
            }
            current.setNext(null);
            this.top = current;
        }

        this.size--;
        return poppedNode;
    }

    void printStack() {
        if (this.size == 0) {
            System.out.println("Stack is empty");
            return;
        }

        Node current = this.bottom;
        while (current != null) {
            System.out.println(current.getValue());
            current = current.getNext();
        }
    }

    public static void main(String[] args) {
        var stack = new StackBackedByLinkedList();

        stack.push(new Node("1"));
        stack.push(new Node("2"));
        stack.push(new Node("3"));
        stack.push(new Node("4"));
        stack.push(new Node("5"));
        stack.push(new Node("6"));
        stack.push(new Node("7"));
        stack.push(new Node("10"));

        System.out.println(stack.peek().getValue());
        System.out.println(stack.pop().getValue());

        System.out.println("Printing stack from bottom to top:");
        stack.printStack();
    }
}

class Node {

    private final String value;
    private Node next;

    public Node(String value) {
        this.next = null;
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public Node getNext() {
        return next;
    }


    public void setNext(Node next) {
        this.next = next;
    }

}
