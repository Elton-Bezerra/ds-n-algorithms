package com.bezerra.elton.stacks;

import java.util.ArrayList;
import java.util.List;

public class StackBackedByArray {

    List<ArrayNode> array;

    StackBackedByArray() {
        this.array = new ArrayList<>();
    }

    void push(ArrayNode node) {
        this.array.add(node);
    }

    ArrayNode pop() {
        if (this.array.isEmpty()) {
            return null;
        }

        return this.array.remove(this.array.size() - 1);
    }

    ArrayNode peek() {
        if (this.array.isEmpty()) {
            return null;
        }

        return this.array.get(this.array.size() - 1);
    }

    void printStack() {
        if (this.array.isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }

        for (int i = this.array.size() - 1; i >= 0; i--) {
            System.out.println(this.array.get(i).value());
        }
    }

    public static void main(String[] args) {
        var stack = new StackBackedByArray();
        stack.push(new ArrayNode("6"));
        stack.push(new ArrayNode("5"));
        stack.push(new ArrayNode("4"));
        stack.push(new ArrayNode("3"));
        stack.push(new ArrayNode("2"));
        stack.push(new ArrayNode("1"));

        System.out.println(stack.peek());
        System.out.println(stack.pop());

        stack.printStack();
    }

}

record ArrayNode(String value) {}
