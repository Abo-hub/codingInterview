package com.sun.stackandqueue.GetMinStack;

import java.util.Stack;

public class GetMinStack2 {

    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public GetMinStack2(){
        this.stackData = new Stack<Integer>();
        this.stackMin = new Stack<Integer>();
    }

    //压入
    public void push(int newNum){
        if (stackMin.isEmpty()) {
            stackMin.push(newNum);
        }else if(newNum <= this.getMin()){
            stackMin.push(newNum);
        }else {
            int newMin = stackMin.peek();
            stackMin.push(newMin);
        }
        stackData.push(newNum);
    }

    //弹出
    public int pop(){
        if(stackData.isEmpty()){
            throw new RuntimeException("Your stack is empty");
        }
        stackMin.pop();
        return stackData.pop();
    }

    public int getMin() {
        if(stackMin.isEmpty()){
            throw new RuntimeException("Your stack is empty");
        }
        return stackMin.peek();
    }

    public static void main(String[] args) {
        int[] nums = { 3, 4, 5, 1, 2, 1 };
        GetMinStack2 test = new GetMinStack2();
        for (Integer num : nums) {
            test.push(num);
        }
        System.out.println(test.getMin());
        test.push(0);
        System.out.println(test.getMin());
    }
    
}