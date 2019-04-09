# 设计一个有getMin功能的栈

## 【题目】
实现一个特殊的栈，在实现栈的基本功能的基础上，在实现返回栈中最小元素的操作
## 【要求】
1. pop、push、getMin操作的时间复杂度都是O(1).
2. 设计的站的类型可以使用现成的栈结构。

## 【解答】
在设计时，我们使用两个栈，一个栈用来保存当前栈中的元素，其功能和一个正常的栈没有区别，这个栈记为stackData；另一个栈用于保存每一步的最小值，这个栈记为stackMin。具体实现方式有两种。

### [第一种设计方案](GetMinStack1.java)
1. 压入规则
假设当前数据为newNum，先将其压入stackData。然后判断stackMin是否为空：
    - 如果为空，则newNum也压入stackMin。
    - 如果不为空，则比较newNum和stackMin栈顶元素哪一个更小：
        - 如果newNum更小或者两者相同，则newNum也压入stackMin；
        - 如果stackMin中栈顶元素小，则stackMin不压入任何元素；
2. 弹出规则
- 先在stackData中弹出栈顶元素，记为value。然后比较当前stackMin的栈顶元素和value哪个更小。
- 当value等于stackMin的栈顶元素时，stackMin弹出栈顶元素；当value大于stackMin的栈顶元素时，stackMin不弹出栈顶元素，返回value；
2. 查询当前栈中的最小值
通过上文我们知道stackMin的栈顶元素一直记录着stackData的最小值。


### 第二种设计方案
1. 压入规则
- 假设当前数据为newNum，先将其压入stackData。然后判断stackMin是否为空。
    - 如果为空，则newNum也压入stackMin；
    - 如果不为空，则比较newNum和stackMin的栈顶元素哪一个更小。
        - 如果newNum更小或相等，则newNum压入stackMin；
        - 如果stackMin中栈顶元素小，则把stackMin的栈顶元素重复压入stackMin中。
2. 弹出规则
在stackData中弹出数据，弹出的数据记为value；弹出stackMin的栈顶元素，返回value。
3. 查询当前栈中最小值
由上文的规则可知，stackMin栈顶元素始终记录着stackData中的最小值。

## 【点评】
方案一和方案二其实都是用stackMin栈保存着stackData每一步的最小值。共同点时所有操作的时间复杂度都为O(1)、空间复杂度都为O(n)。区别是：方案一种stackMin压入稍省时间，但是弹出操作稍费时间；方案二中stackMin压入时稍费时间，但是弹出操作稍省时间。