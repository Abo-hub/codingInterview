package com.sun.stackandqueue.GetMinStack;

import java.util.Stack;

public class GetMinStack1 {

    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public GetMinStack1() {
        this.stackData = new Stack<Integer>();
        this.stackMin = new Stack<Integer>();
    }

    public void push(int newNum) {
        if (this.stackMin.isEmpty()) {
            this.stackMin.push(newNum);
        } else if (newNum <= this.getMin()) {
            this.stackMin.push(newNum);
        }
        this.stackData.push(newNum);

    }

    public int pop() {
        if (this.stackData.isEmpty()) {
            throw new RuntimeException("Your stack is empty");
        }
        int value = this.stackData.pop();
        if (value == this.getMin()) {
            this.stackMin.pop();
        }
        return value;
    }



    public int getMin() {
        if (this.stackMin.isEmpty())
            throw new RuntimeException("Your stack is empty");
        return this.stackMin.peek();
    }

    public static void main(String[] args) {
        int[] nums = { 3, 4, 5, 1, 2, 1 };
        GetMinStack1 test = new GetMinStack1();
        for (Integer num : nums) {
            test.push(num);
        }
        System.out.println(test.getMin());
        test.push(0);
        System.out.println(test.getMin());
    }
}