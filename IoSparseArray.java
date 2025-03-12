package IoSparseArray;

import java.io.*;

public class IoSparseArray {
    static void saveSparseArray(int[][] sparseArray) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("map.data"));

                    oos.writeObject(sparseArray);
            System.out.println("存入成功");
                    oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static int[][] readSparseArray() {

        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("map.data"));
            return (int[][])ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return  null;
        }
    }
    public static void main(String[] args) {
        //创建一个原始的二维数组,
        //0表示没有.1表示黑子,2表示蓝子
        int chessArr1[][] = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        chessArr1[4][4] = 6;
        //取出每一行
        for (int[] row : chessArr1) {
            //再取出每一个
            for (int data : row) {
                //格式化输出
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
        //把二维数组转化为稀疏数组
        int count = 0;
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1[i].length; j++) {
                if(chessArr1[i][j]!=0){
                    count++;
                }
            }
        }
        //把稀疏数组存到文件中
        saveSparseArray(chessArr1);
        System.out.println(count);
        System.out.println("************************************************************");
        //创建一个稀疏数组
        int[][] sparseArray = new int[count+1][3];
        //给稀疏数组赋值
        sparseArray[0][0] = chessArr1.length;
        sparseArray[0][1] = chessArr1[1].length;
        sparseArray[0][2] = count;
        int count1 = 1;
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1[i].length; j++) {
                if(chessArr1[i][j]!=0) {
                    sparseArray[count1][0] = i;
                    sparseArray[count1][1] = j;
                    sparseArray[count1][2] = chessArr1[i][j];
                    count1++;
                }
            }
        }
        System.out.println("得到的稀疏数组如下~~~~~");
        for (int[] row: sparseArray) {
            for (int data:row) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }

        //创建棋盘
        int[][] chessArr3 = new int[sparseArray[0][1]][sparseArray[0][1]];
        //遍历稀疏数组赋值
        for (int i = 1; i < sparseArray.length; i++) {
            chessArr3[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }
        System.out.println("恢复成原来的数组");
        for (int[] row:chessArr3) {
            for (int data : row) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
        System.out.println("***************************************");
        System.out.println("打印存入的稀疏数组");
        int[][] saveDate =  readSparseArray();
        for (int[] row:saveDate) {
            for (int data : row) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
    }
}
