package com.sun.stackandqueue.getandremovelastelement;

import java.util.Stack;

public class GetAndRemoveLastElement {

    public static int getAndRemoveLastElement(Stack<Integer> stack) {
        int result = stack.pop();
        if (stack.isEmpty()) {
            return result;
        } else {
            int last = getAndRemoveLastElement(stack);
            stack.push(result);
            return last;
        }
    }
    public static void reverse(Stack<Integer> stack) {
        if(stack.isEmpty()){
            return;
        }
        int i = getAndRemoveLastElement(stack);
        reverse(stack);
        stack.push(i);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.add(1);
        stack.add(2);
        stack.add(3);
        for (Integer num : stack) {
            System.out.print(num);
        }
        System.out.println();
        reverse(stack);
        for (Integer num : stack) {
            System.out.print(num);
        }
    }

}