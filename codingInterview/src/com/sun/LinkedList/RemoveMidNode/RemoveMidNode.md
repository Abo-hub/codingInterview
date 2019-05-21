[toc]
# 删除链表的中间节点

## 【题目】
给定链表的头节点head，实现删除链表的中间节点的函数。
例如：
不删除任何节点;
1->2,删除节点1；
1->2->3，删除节点2；
1->2->3->4，删除节点2；
1->2->3->4->5，删除节点3；
进阶：
给定链表的头节点head、整数a和b，实现删除位于a/b处节点的函数。
例如：
链表：1->2->3->4->5，假设a/b的值为r。
如果r等于0，不删除任何节点；
如果r在区间(0,1/5]上，删除节点1；
如果r在区间(1/5,2/5]上，删除节点2；
如果r在区间(2/5,3/5]上，删除节点3；
如果r在区间(3/5,4/5]上，删除节点4；
如果r在区间(4/5,1]上，删除节点5；
如果r大于1，不删除任何节点。
## 【解答】
先来分析原问题
- 如果链表为空或者长度为1，不需要调整，则直接返回；
- 如果链表的长度为2，将头节点删除即可；
- 如果链表的长度达到3，应该删除第2个节点；
- 当链表的长度为4，应该删除第2个；
- 当链表长度为5，应该删除第3个节点......
也就是链表长度没增加2(3，5，7)，要删除的节点就后移一个节点。
具体过程请参考如下代码：
```java
public class RemoveMidNode {

    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public Node removeMidNode(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        if (head.next.next == null) {
            return head.next;
        }
        Node pre = head;
        Node cur = head.next.next;
        while (cur.next != null && cur.next.next != null) {
            pre = pre.next;
            cur = cur.next.next;
        }
        pre.next = pre.next.next;
        return head;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        RemoveMidNode rMidNode = new RemoveMidNode();
        rMidNode.removeMidNode(node1);
        Node node = node1;
        while (node != null) {
            System.out.println(node.value);
            node = node.next;
        }
    }
}
```
