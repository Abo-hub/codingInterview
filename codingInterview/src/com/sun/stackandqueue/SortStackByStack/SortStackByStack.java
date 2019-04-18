package com.sun.stackandqueue.SortStackByStack;

import java.util.Stack;

public class SortStackByStack {
    
    public static void sortStackByStack(Stack<Integer> stack) {
         Stack<Integer> help = new Stack<Integer>();
         while(!stack.isEmpty()){
             int cur = stack.pop();
             while(!help.isEmpty() && help.peek()<cur){
                 stack.push(help.pop());
             }
             help.push(cur);
         }
         while(!help.isEmpty()){
             stack.push(help.pop());
         }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(4);
        stack.push(1);
        stack.push(5);
        stack.push(2);
        stack.push(3);
        System.out.println("before:"+stack);
        sortStackByStack(stack);
        System.out.println("after:"+stack);
    }
}