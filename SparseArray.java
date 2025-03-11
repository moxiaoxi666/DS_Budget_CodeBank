public class SparseArray {
    public static void main(String[] args) {
        //创建一个原始的二维数组,
        //0表示没有.1表示黑子,2表示篮子
        int chessArr1[][] = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
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
        System.out.println(count);
        System.out.println("************************************************************");
        //创建一个稀疏数组
        int[][] sparseArray = new int[count+1][3];
        //给稀疏数组赋值
        sparseArray[0][0] = chessArr1.length;
        sparseArray[0][1] = chessArr1[1].length;
        sparseArray[0][2] = count;
//        sparseArray[1][0]= 1;
//        sparseArray[1][1]= 2;
//        sparseArray[1][2]= 1;
//        sparseArray[2][0]= 2;
//        sparseArray[2][1]= 3;
//        sparseArray[2][2]= 2;
//        for (int[] row: sparseArray) {
//            for (int data:row) {
//                System.out.printf("%d\t",data);
//            }
//            System.out.println();
//        }
        //快速的存入数据
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
        for (int[] row: sparseArray) {
            for (int data:row) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
    }
}