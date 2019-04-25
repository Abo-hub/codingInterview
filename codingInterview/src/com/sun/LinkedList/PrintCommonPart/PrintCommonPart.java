package com.sun.LinkedList.PrintCommonPart;

public class PrintCommonPart {

    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public void printCommonPart(Node head1, Node head2) {
        System.out.println("Common Part:");
        while (head1 != null && head2 != null) {
            if (head1.value<head2.value) {
                head1 = head1.next;
            }else if(head1.value>head2.value){
                head2 = head2.next;
            }else{
                System.out.println(head1.value+" ");
                head1 = head1.next;
                head2 = head2.next;
            }
        }
        System.out.println();
    }
    public static void main(String[] args) {
        
        Node fnode1 = new Node(1);
        Node fnode2 = new Node(2);
        Node fnode3 = new Node(4);
        Node fnode4 = new Node(7);
        Node fnode5 = new Node(9);
        fnode1.next = fnode2;
        fnode2.next = fnode3;
        fnode3.next = fnode4;
        fnode4.next = fnode5;

        Node snode1 = new Node(1);
        Node snode2 = new Node(2);
        Node snode3 = new Node(5);
        Node snode4 = new Node(7);
        Node snode5 = new Node(8);
        snode1.next = snode2;
        snode2.next = snode3;
        snode3.next = snode4;
        snode4.next = snode5;

        PrintCommonPart pcp = new PrintCommonPart();
        pcp.printCommonPart(fnode1, fnode2);
        
    }
}