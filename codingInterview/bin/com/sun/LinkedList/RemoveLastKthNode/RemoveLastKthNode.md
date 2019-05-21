[toc]
# 在单链表和双链表中删除倒数第K个节点
## 【题目】
分别实现两个函数，一个可以删除单链表中倒数第k个节点，另一个可以删除双链表中倒数第k个节点。
## 【要求】
如果链表长度为N，时间复杂度O(N),额外空间复杂度达到O(1)。
# 【解答】
先来看看单链表如何调整。如果链表为空或者k值小于1，在这种情况下，参数是无效的，直接返回即可。除此之外，让链表从头开始走到尾，每移动一步，就让k值减1.
- 让链表从头开始走到尾，没移动一步，就让k值减1。
- 当链表走到结尾时，如果k值大于0，说明链表没有倒数第k个节点，此时将原链表直接返回即可。
- 当链表走到结尾时，如果k值等于0，说明链表倒数第k个节点就是头节点，此时直接返回head.next即可，也就是原链表的第二个节点，让第二个节点作为链表的头返回即可，相当于删除头节点。
接下来说一下如果k值小于0，该如何处理。
> 先明确一点，如果要删除链表的头节点之后的某个节点，实际上需要找到删除节点的前一个节点，比如1->2->3，如果想删除节点2，则需要找到节点1，然后把节点1连到节点3上(1->3)，以此来达到删除节点2的目的。

如果k值小于0，如何找到要删除节点的前一个节点呢？方法如下：
1. 重新从头节点开始走，每移动一步，就让k的值加1.
2. 当k等于0时，移动停止，移动到的节点就是要删除节点的前一个节点。
> 这样做是非常好理解的，因为如果链表长度为N，要删除倒数第k个节点，很明显，倒数第k个节点的前一个节点就是第N-K个节点。在第一次遍历后，k的值变为K-N。第二次遍历时，K的值不断加1，加到0就停止遍历，第二次遍历当然会听到第N-K个节点的位置。

具体过程请参考removeLastKthNode方法：
```java
public class RemoveLastKthNode {

    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public Node removeLastKthNode(Node head, int lastKth) {
        if (head == null || lastKth < 1) {
            return head;
        }
        Node cur = head;
        while (cur != null) {
            lastKth--;
            cur = cur.next;
        }
        if (lastKth == 0) {
            head = head.next;
        }
        if (lastKth < 0) {
            cur = head;
            while (++lastKth != 0) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        RemoveLastKthNode rln = new RemoveLastKthNode();

        rln.removeLastKthNode(node1, 5);
        Node tNode = node1;
        while (tNode != null) {
            System.out.println(tNode.value);
            tNode = tNode.next;
        }
    }
}

```
对于双链表的调整，几乎于单链表的处理方式一样，注意last指针的重连即可。具体操作请参考下面RemoveLastKthNode2方法：
```java

```