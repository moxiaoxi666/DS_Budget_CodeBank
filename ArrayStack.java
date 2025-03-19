package stack;
//实现stack的增删查
//实现计算器的功能
public class ArrayStack {
    private int maxSize;
    private int top;
    //一定要记得初始化数组
    private int[]stack;
    //创建一个构造器
    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        this.stack = new int[this.maxSize];
        top = -1;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public int[] getStack() {
        return stack;
    }

    public void setStack(int[] stack) {
        this.stack = stack;
    }
    //判断stack是否已经满
    private boolean isFull() {
        return this.maxSize-1 == this.top;
    }
    //判断stack是否为空
    public boolean isEmpty() {
        return this.top == -1;
    }
    //入栈及push
    public void push(int value) {
        //判断是否栈满
        if(isFull()) {
            System.out.println("当前栈数据已满");
            return;
        }
        this.top++;
        stack[top] = value;
    }
    //出栈及pop
    public int pop() {
        if(isEmpty()) {
            return 0;
        }
        int value = stack[top];
        top--;
        return value;
    }
    public void list() {
        if(isEmpty()) {
            throw new RuntimeException("该栈为空");
        }
        //栈的特点是先进后出,所以要从后遍历
        for (int i = top; i >=0 ; i--) {
            int data = stack[i];
            System.out.printf("stack==%d\n",data);
        }
    }
    //stack需要比较符号的优先级,从外界接收一个符号
    public int priority(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        }else if(oper == '+'|| oper =='-') {
            return 0;
        }else {
            System.out.println("符号错误,无法正常进行运算");
            return -1;
        }
    }
    //判断是否为运算符(不好判断是不是数字,但运算符好说)
    public boolean isOper(int oper) {
        return oper == '+'||oper =='-'||oper =='*'||oper =='/';
    }
    //实现加减乘除,两个数字,一个符号
    public int cal(int num1,int num2,int oper) {
        //switch用的太少,自己想都想不起来
        int res = 0;
        switch(oper) {
            case '*':
                res = num1*num2;
                break;
            case '/':
                res = num2/num1;
                break;
            case '+':
                 res = num1+num2;
                 break;
            case '-':
                res = num2-num1;
                break;
        }
        return res;
    }
//返回栈顶数据,只是看一下当前stack顶的数据
    public int topData() {
        return stack[top];
    }
}
