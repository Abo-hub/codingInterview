[toc]
# 打印两个有序链表的公共部分
## 【题目】
给定两个有序链表的头指针head1和head2，打印两个链表的公共部分。
## 【解答】
因为时有序链表，所以从两个链表的头开始进行如下判断：
- 如果head1的值小于head2，则head1往下移动。
- 如果head2的值小于head1，则head2往下移动。
- 如果head1的值等于head2的值，则打印这个值，然后head1与head2都往下移动。
- head1或head2有任何移动到null，则整个过程停止。
具体过程看一下代码
```java
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
```