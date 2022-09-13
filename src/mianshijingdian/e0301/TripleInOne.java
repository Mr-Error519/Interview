package mianshijingdian.e0301;

//三合一。描述如何只用一个数组来实现三个栈。
public class TripleInOne {
    public Integer[] array;
    public TripleInOne(int stackSize) {
        this.array = new Integer[stackSize*3];
    }

    public void push(int stackNum, int value) {
        for (int i = stackNum*array.length/3; i <stackNum*array.length/3+array.length/3 ; i++) {
            if(array[i]==null){
                array[i]=value;
                return;
            }
        }
        return;
    }

    public int pop(int stackNum) {
        for (int i = ((stackNum+1)*array.length/3)-1; i >stackNum*array.length/3-1; --i) {
            if(array[i]!=null){
                int b = array[i];
                array[i] = null;
                return b;
            }
        }
        //遍历“栈”，没有元素可弹出
        return -1;
    }

    public int peek(int stackNum) {
        for (int i = (stackNum+1)*array.length/3-1; i >stackNum*array.length/3-1; --i) {
            if(array[i]!=null){
                return array[i];
            }
        }
        //遍历“栈”，没有元素可弹出
        return -1;

    }

    public boolean isEmpty(int stackNum) {
      //栈底不为空，则栈不空
        if(array[stackNum*array.length/3]!=null){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        TripleInOne tripleInOne = new TripleInOne(1);
        System.out.println(tripleInOne.array[0]);

    }
}
