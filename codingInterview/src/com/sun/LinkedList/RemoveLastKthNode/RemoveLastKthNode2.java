package com.sun.LinkedList.RemoveLastKthNode;

public class RemoveLastKthNode2 {

    public class DoubleNode {
        public int value;
        public DoubleNode next;
        public DoubleNode last;

        public DoubleNode(int data) {
            this.value = data;
        }
    }

    public DoubleNode removeLastKthNode(DoubleNode head, int LastKth) {
        if (head == null || LastKth < 1) {
            return head;
        }
        DoubleNode cur = head;
        while (cur != null) {
            LastKth--;
            cur = cur.next;
        }
        if (LastKth == 0) {
            head = head.next;
            head.last = null;
        }
        if (LastKth < 0) {
            cur = head;
            while (++LastKth != 0) {
                cur = cur.next;
            }
            DoubleNode newNext = cur.next.next;
            cur.next = newNext;
            if (newNext != null) {
                newNext.last = cur;
            }
        }
        return head;
    }
}