[toc]
# 猫狗队列
## 【题目】
宠物、猫和狗的类如下
```java
public class Pet {

    private String type;

    public Pet(String type){
        this.type = type;
    }

    public String getPetType(){
        return this.type;
    }
}

public class Dog extends Pet {

    public Dog(){
        super("dog");
    }
}

public class Cat extends Pet {

    public Cat(){
        super("cat");
    }
}

```

实现一种猫狗队列的机构，要求如下：
- 用户可以调用add方法将cat类或dog类的实例放入队列中；
- 用户可以调用pollAll方法，将队列中所有的实例按照进队列的先后顺序依次弹出；
- 用户可以调用pollDog方法将队列中dog类的实例按照进队列的先后顺序依次弹出；
- 用户可以调用pollCat方法将队列中cat类的实例按照进队列的先后顺序依次踏出；
- 用户可以调用isEmpty方法，检查队列中是否还有dog或者cat的实例；
- 用户可以调用isDogEmpty方法，检查队列中是否有dog类的实例；
- 用户可以调用isCatEmpty方法，检查队列中是否有cat类的实例；

## 【解答】
这里指出几种常见的设计错误：
- cat队列只放cat实例，dog队列只放dog实例，再用一个总队列放所有的实例
    - 错误原因：cat、dog和总队列的更新问题
- 用哈希表，key表示一个cat实例或dog实例，value表示这个实例进队列的次序。
    - 错误原因：不能支持一个实例多次进队列的功能需求，因为哈希表的key只能对应一个value值
- 将用户原有的cat或dog类改写，加一个计数项来表示某一个实例进队列的时间。
    - 错误原因：不能铲子改变用户的类结构。
本题实现将不同的实例盖上时间戳的方法，但是又不能改变用户本身的类，所以定义一个新的类，具体实现请参考如下的PerEnterQueue类
```java
public class PetEnterQueue{

    private Pet pet;
    private long count;

    public PetEnterQueue(Pet pet,long count){
        this.pet = pet;
        this.count = count;
    }

    public Pet getPet(){
        return this.pet;
    }

    public long getCount(){
        return this.count;
    }

    public String getEnterPetType(){
        return this.pet.getPetType();
    }
}
```
在构造PetEnterQueue类时，pet时用户原有的实例，count就是这个实例的时间戳。
我们实现的队列其实是PetEnterQueue类的实例。大体来说，首先有一个不断累加的数据项，用来表示实例进入队列的时间；同时有两个队列，一个只放dog类实例的队列dogQ，另一个脂肪cat类实例的队列catQ。

在加入实例时，如果实例时dog，就盖上时间戳，生成对应的PetEnterQueue类的实例，然后放入dogQ;如果实例是cat，就盖上时间戳，生成对应的PetEnterQueue类实例，然后放入catQ。具体过程参考DogCatQueue类的add方法;

只想弹出dog类的实例时，从dogQ里不断弹出即可，具体过程看DogCatQueue的pollDog方法

只想弹出cat类的实例时，从catQ里不断弹出即可，具体过程看DogCatQueue的pollCat方法

想按照实际弹出实例时，因为dogQ的队列头表示所有dog实例中最早进队列的实例，同时catQ的队列表示所有的cat实例中最早进队列的实例。则比较这两个队列头的时间戳，谁更早，就弹出谁
```java
public class DogCatQueue {

    private Queue<PetEnterQueue> dogQ;
    private Queue<PetEnterQueue> catQ;
    private long count;

    public DogCatQueue() {
        this.dogQ = new LinkedList<PetEnterQueue>();
        this.catQ = new LinkedList<PetEnterQueue>();
    }

    public void add(Pet pet) {
        if (pet.getPetType().equals("dog")) {
            dogQ.add(new PetEnterQueue(pet, count++));
        } else if (pet.getPetType().equals("cat")) {
            catQ.add(new PetEnterQueue(pet, count++));
        } else {
            throw new RuntimeException("error,not dog or cat");
        }
    }

    public Pet pollAll() {
        if (!dogQ.isEmpty() && !catQ.isEmpty()) {
            if (dogQ.peek().getCount() < catQ.peek().getCount()) {
                return dogQ.poll().getPet();
            } else {
                return catQ.poll().getPet();
            }
        } else if (!dogQ.isEmpty()) {
            return dogQ.poll().getPet();
        } else if (!catQ.isEmpty()) {
            return catQ.poll().getPet();
        } else {
            throw new RuntimeException("error,queue is empty");
        }
    }

    public Dog pollDog() {
        if (!dogQ.isEmpty()) {
            return (Dog) dogQ.poll().getPet();
        } else {
            throw new RuntimeException("error,dogqueue is empty");
        }
    }

    public Cat pollCat() {
        if (!catQ.isEmpty()) {
            return (Cat) catQ.poll().getPet();
        }else{
            throw new RuntimeException("error,catqueue is empty");
        }
    }

    public boolean isEmpty() {
        return dogQ.isEmpty() && catQ.isEmpty();
    }

    public boolean isDogQueueEmpty(){
        return dogQ.isEmpty();
    }

    public boolean isCatQueueEmpty(){
        return catQ.isEmpty();
    }

}
```


