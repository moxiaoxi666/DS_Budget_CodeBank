package stack;
public class Calculator {
    public static void main(String[] args) {
        //先定义有关的变量
        ArrayStack numStack = new ArrayStack(10);
        ArrayStack operStack = new ArrayStack(10);
        String expression = "10+2*6-2";
        //记录当前表达式运行的位置
        int index = 0;
        //数字和符号以及最后结果的存储
        int num1 = 0;
        int num2 = 0;
        int res = 0;
        int oper =0;//符号,这个知识点的运用要明白
        char ch =' ';//记录index扫描的数据
        String data ="";
        //使用while开始扫描expression,先进行一个入栈的过程
        while(true) {
            //依次得到expression的每一个字符
            ch = expression.substring(index,index+1).charAt(0);
            //1.判断ch是不是符号,大小关系要明白
            //2.判断是不是为空
            //3.判断符号的优先级
            if(operStack.isOper(ch)){
                if(!operStack.isEmpty()){
                    //判断优先级和前一个数据
                    if(operStack.priority(ch)<=operStack.priority(operStack.topData())){
                        //要进行运算
                       num1 = numStack.pop();
                       num2 = numStack.pop();
                       oper = operStack.pop();
                       int value = numStack.cal(num1,num2,oper);
                       //再次入栈
                        numStack.push(value);
                        //把当前的符号入栈
                        operStack.push(ch);
                    }else {
                        //入栈
                        operStack.push(ch);
                    }

                }else {
                    //为空直接入栈
                    operStack.push(ch);
                }
            }else {
                //数字直接入栈 重点!!!!!
               // numStack.push(ch-48);  这种写法不能记录多位数
                data += ch;
                //判断是不是最后一位
                if(index==expression.length()-1) {
                    //存入数据
                    numStack.push(Integer.parseInt(data));
                }else {
                    //判断下一位是不是符号
                    if(operStack.isOper(expression.substring(index+1,index+2).charAt(0))) {
                        //如果是符号则push,不是则拼接下一轮
                        numStack.push(Integer.parseInt(data));
                        //重置
                        data = "";
                    }
                }
            }
            //用index判断是否结束
            index++;
            if(index>=expression.length()) {
                break;
            }
        }
        //出栈
        while(!operStack.isEmpty()) {
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = numStack.cal(num1,num2,oper);
            numStack.push(res);
        }
        System.out.printf("表达式%s=%d",expression,numStack.pop());
    }
}
