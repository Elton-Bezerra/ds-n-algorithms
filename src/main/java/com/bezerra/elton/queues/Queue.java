package com.bezerra.elton.queues;

public class Queue {

    Node first;
    Node last;
    int size;

    Queue() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    void enqueue(String value) {
        if (size == 0) {
            Node node = new Node(value);
            this.first = node;
            this.last = node;
            this.size++;
        } else {
            Node node = new Node(value);
            this.last.next = node;
            this.last = node;
            this.size++;
        }
    }

    Node dequeue() {
        if (this.first == null) {
            return null;
        }

        if( this.first == this.last) {
            this.last = null;
        }

        Node temp = this.first;

        this.first = this.first.next;
        size--;
        return temp;

    }

    Node peek() {
        return this.first;
    }

    boolean isEmpty() {
        return this.size == 0;
    }

    public static void main(String[] args) {
        Queue queue = new Queue();
        System.out.println(queue.isEmpty());

        queue.enqueue("0");
        queue.enqueue("1");
        queue.enqueue("2");
        queue.enqueue("3");
        queue.dequeue();
        queue.dequeue();

        queue.dequeue();

        queue.dequeue();


        System.out.println(queue.peek());

        var first = queue.first;

        System.out.println(first.value);
        while(first.next != null) {
            first =  first.next;
            System.out.println(first.value);
        }

    }

    class Node {
        String value;
        Node next;

        Node(String value) {
            this.value = value;
            this.next = null;
        }
    }
}
