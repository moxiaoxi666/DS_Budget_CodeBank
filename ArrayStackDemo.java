package stack;

import java.util.Scanner;

public class ArrayStackDemo {
    public static void main(String[] args) {
        //测试一下ArrayStack是否正确
        //创建一个菜单
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        String key = "";
        ArrayStack arrayStack = new ArrayStack(5);
       while(loop) {
           System.out.println("show:>表示显示栈");
           System.out.println("exit:>退出程序");
           System.out.println("push:>表示添加数据(入栈)");
           System.out.println("pop:>从栈中取出数据");
           key = scanner.next();
           switch (key) {
               case "show":
                    arrayStack.list();
                    break;
               case "pop":
                   try {
                       int value = arrayStack.pop();
                       System.out.println(value);
                   } catch (Exception e) {
                       e.printStackTrace();
                   }
                   break;
               case "push":
                   System.out.println("请输入一个数");
                   int data = scanner.nextInt();
                   arrayStack.push(data);
                   break;
               case "exit":
                   scanner.close();
                   loop = false;
               break;
               default:
                   System.out.println("输入数据错误");
                   break;
           }
       }
        System.out.println("程序退出");
    }
}
class ArrayStack{
    private int maxSize; //栈的最大值
    private int[] stack; //用数组创建一个stack
    private int top =-1; //top表示栈顶
    //构造器
    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }
    //判断栈满
    public boolean isFull() {
        return top == maxSize -1;
    }
    //判断栈空
    public boolean isEmpty() {
        return top == -1;
    }
    //入栈--push
    public void push(int val) {
        if(isFull()) {
            System.out.println("该队列已经满");
            return;
        }
        top++;
        stack[top] = val;
    }
    //出栈--pop
    public int pop() {
        if(isEmpty()) {
            //抛出异常
            throw new RuntimeException("栈空,没有数据");
        }
        int value = stack[top];
        top--;
        return  value;
    }
    //显示栈的情况
    public void list() {
        if(isEmpty()) {
            System.out.println("为空没有数据");
            return;
        }
        for (int i = top; i >= 0; i--) {
                int value = stack[i];
            System.out.println("stack["+i+"]==" + value);
        }
    }
}

