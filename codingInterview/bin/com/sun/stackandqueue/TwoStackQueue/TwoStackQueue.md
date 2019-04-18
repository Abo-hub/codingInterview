[toc]
# 有两个栈组成的队列
## 【题目】
编写一个类，用两个栈实现队列，支持队列的基本操作(add、poll、peek)
## 【解答】
栈的特点时先进后出，而队列的特点时先进先出。我们用两个栈正好把顺序反过来实现类似队列的操作。
1. 如果stackPush要往stackPop中压入数据，那么必须一次性把stackPush中的数据全部压入。
2. 如果stackPop不为空，stackPush不能像stackPop中压入数据