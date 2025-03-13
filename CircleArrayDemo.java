import java.util.Scanner;

public class CircleArrayDemo {
    public static void main(String[] args) {
        CircleArray circleArray = new CircleArray(5);
        boolean loop = true;
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        while(loop){
            System.out.println("s(show):>显示队列");
            System.out.println("a(add):>添加数据到队列");
            System.out.println("g(get):>从队列中取出数据");
            System.out.println("h(head):>查看队列头数据");
            System.out.println("e(exit):>退出程序");
            key = scanner.next().charAt(0);//接收一个字符
            switch (key) {
                case's':
                    try {
                        circleArray.showCircleArray();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'a':
                    System.out.println("请输入一个数字");
                    int data = scanner.nextInt();
                    try {
                        circleArray.addCircleArray(data);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'g':
                    int value = 0;
                    try {
                        value = circleArray.getCircleArray();
                        System.out.println(value);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    System.out.println(value);
                case 'h':
                    try {
                        value = circleArray.headCircleArray();
                        System.out.println(value);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    break;
                default:
                    System.out.println("输入错误");
                    break;
            }
        }
        System.out.println("本次运行成功");
    }
}
//定义一个环形对列
class CircleArray{
    private int maxSize;
    private int circleArray[];
    private int front;//指向对象头
    private int rear;//最后一个数据的下一个

    public CircleArray(int maxSize) {
        this.maxSize = maxSize;
        //初始化环形数组,注意new数组的长度创建
        this.circleArray = new int[maxSize];
    }
    //判断是否,满
    public boolean isFullCircleArray() {
        return (this.rear+1)%this.maxSize == this.front;
    }
    public void addCircleArray(int n){
        if(isFullCircleArray()){
            throw new RuntimeException("该环形队列当前以满");
        }
        this.circleArray[this.rear] = n;
        //将rear后移必须考虑%
        this.rear = (this.rear+1)%this.maxSize;
    }
    public boolean isEmptyCircleArray() {
        return this.rear==this.front;
    }
    //取出数据
    public int getCircleArray() {
        if (isEmptyCircleArray()){
            throw  new RuntimeException("当前环形队列为空");
        }
        int data = this.circleArray[this.front];
        //考虑取模
        front = (front+1)%this.maxSize;
        return data;
    }
    public void showCircleArray() {
        if(isEmptyCircleArray()){
            throw new RuntimeException("当前环形队列为空");
        }
        //计算有效个数
       int count = this.size();
        for (int i = this.front; i <this.front+count ; i++) {
            System.out.printf("arr[%d]=%d\t",i%this.maxSize,this.circleArray[i%this.maxSize]);
        }
        System.out.println();
    }
    //显示为队列的头数据,不是取出数据
    public int headCircleArray(){
        return this.circleArray[this.front];
    }
    //求当前队列的有效个数
    public int size(){
        return (this.rear-this.front+this.maxSize)%this.maxSize;
    }
}