[toc]
# 单调栈结构

##【题目】
给定一个不含有重复值的数组arr，找到每一个i位置左边和右边离i位置最近且比arr[i]小的位置。返回所有位置相应的信息。
## 【举例】
```
arr = {3,4,1.5.6.2.7}
返回如下二位数组作为结果：
{
    {-1，2},
    { 0, 2},
    {-1,-1},
    { 2, 5},
    { 3, 5},
    { 2,-1},
    { 5,-1}
}
```
## 【解答】
本题时间复杂度为O(N^2^)的解是非常容易的，每个位置分别向左和向右遍历一下，总可以确定。具体过程看如下rightWay方法：
```java
public class RightWay {

    public int[][] rightWay(int[] arr) {
        int[][] res = new int[arr.length][2];

        for (int i = 0; i < arr.length; i++) {
            int leftLessIndex = -1;
            int rightLessIndex = -1;
            int cur = i - 1;
            while (cur > 0) {
                if (arr[cur] < arr[i]) {
                    leftLessIndex = cur;
                    break;
                }
                cur--;
            }
            cur = i + 1;
            while (cur < arr.length) {
                if (arr[cur] < arr[i]) {
                    rightLessIndex = cur;
                    break;
                }
                cur++;
            }
            res[i][0] = leftLessIndex;
            res[i][1] = rightLessIndex;
        }
        return res;
    }
}
```

关键在于生成所有位置的相应信息，时间复杂度做到O(N),这需要<font color=red>单调栈结构</font>，这个结构在算法面试中经常出现。
原问题：准备一个栈，记为stack<Integer>，栈中放的元素是数组的位置，开始时stack为空。如果找到每一个i位置左边和右边离i位置最近且值比arr[i]小的位置，那么需要让stack从栈顶到栈底的位置所代表的值时严格递减的；如果找到每一个i位置左边和右边离i位置最近且比arr[i]大的位置，那么需要让stack从栈顶到栈底的位置所代表的值时严格递增的。本题解决的是前者，但对于后者原理也是完全一样的。
