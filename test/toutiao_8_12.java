package test;

//import java.util.Scanner;
//
//public class Main {
//    static boolean flag = true;
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in
//
//        );
//        String[] str = sc.nextLine().split(",");
//        int M = Integer.valueOf(str[0]);
//        int N = Integer.valueOf(str[1]);
//        int[][] qiuchang = new int[M][N];
//        for (int i = 0; i < M; i++) {
//            String[] str_temp = sc.nextLine().split(",");
//            for (int j = 0; j < M; j++) {
//                int tmp = Integer.valueOf(str_temp[j]);
//                qiuchang[i][j] = tmp;
//            }
//        }
//
//        int[] res = MaxIsland(qiuchang);
//        System.out.println(res[1] + "," + res[0]);
//    }
//    public static int[] MaxIsland(int[][] island) {
//        int[] res = new int[2];
//        int max = 0;
//        int num = 0;
//        for (int i = 0; i < island.length; i++) {
//            for (int j = 0; j < island[0].length; j++) {
//                flag = true;
//                if (island[i][j] == 1) {
//                    int tmp = count(island, i, j);
//                    num++;
//                    if (tmp > max) {
//                        max = tmp;
//                    }
//                }
//            }
//        }
//        res[0] = max;
//        res[1] = num;
//        return res;
//    }
//    private static int count(int[][] island, int x, int y) {
//        int num = 1;
//        if (x == 0 || x == island.length || y == 0|| y == island[0].length)
//            flag = false;
//        island[x][y] = 0;
//        if ((x-1)>=0 && island[x-1][y] == 1)
//            num += count(island,x-1,y);
//        if ((x+1)<island.length && island[x+1][y] == 1)
//            num += count(island,x+1,y);
//        if ((y-1)>=0 && island[x][y-1] == 1)
//            num += count(island,x,y-1);
//        if ((y+1)<island.length && island[x][y+1] == 1)
//            num += count(island,x,y+1);
//        if ((x+1)<island.length && (y+1)<island.length && island[x+1][y+1] == 1)
//            num += count(island,x+1,y+1);
//        if ((x-1)>=0 && (y+1)<island.length && island[x-1][y+1] == 1)
//            num += count(island,x-1,y+1);
//        if ((x-1)>=0 && (y-1)>=0 && island[x-1][y-1] == 1)
//            num += count(island,x-1,y-1);
//        if ((x+1)<island.length && (y-1)>=0 && island[x+1][y-1] == 1)
//            num += count(island,x+1,y-1);
//        return num;
//    }
//}

import java.util.Scanner;

public class toutiao_8_12 {
    public static int Max(int[] num){
        int maxIndex = 0;
        for (int i = 0; i < num.length; i++) {
            if(maxIndex < num[i]){
                maxIndex = num[i];
            }

        }
        return  maxIndex;
    }

    public static int Min(int[] num){
        int minIndex = 0;
        for (int i = 0; i < num.length; i++) {

            if(minIndex < num[i]){
                minIndex = num[i];
            }
        }
        return  minIndex;
    }

    public static void main(String args[]){
        Scanner reader = new Scanner(System.in);

        while(reader.hasNext()){
            int n = reader.nextInt();
            int[] numA = new int[n];
            int[] numB = new int[n];
            for (int i=0;i<n;i++){
                numA[i]=reader.nextInt();

            }
            for (int i=0;i<n;i++){
                numB[i]=reader.nextInt();

            }
            int count = 0;
            for(int i = 0;i<n-1;i++){
                for(int j = i+1;j<n;j++){
                    int lenth = j-i+1;
                    int[] NumberATemp =  new int[lenth];
                    int[] NumberBTemp =  new int[lenth];
                    for(int k=0;k<lenth;k++){
                        NumberATemp[k] = numA[k+i];
                        NumberBTemp[k] = numB[k+i];
                    }
                    if(Max(NumberATemp)<=Min(NumberBTemp)){
                        count++;
                    }

                }
            }

            System.out.println(count);
        }
    }

}

//import java.util.Scanner;
//
//public class test {
//    static boolean flag = true;
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in
//
//        );
//        String[] str = sc.nextLine().split(",");
//        int M = Integer.valueOf(str[0]);
//        int N = Integer.valueOf(str[1]);
//        int[][] qiuchang = new int[M][N];
//        for (int i = 0; i < M; i++) {
//            String[] tempStr = sc.nextLine().split(",");
//            for (int j = 0; j < M; j++) {
//                int tmp = Integer.valueOf(tempStr[j]);
//                qiuchang[i][j] = tmp;
//            }
//        }
//
//        int[] res = QiuchangMax(qiuchang);
//        System.out.println(res[1] + "," + res[0]);
//    }
//    public static int[] QiuchangMax(int[][] island) {
//        int[] res = new int[2];
//        int max = 0;
//        int num = 0;
//        for (int i = 0; i < island.length; i++) {
//            for (int j = 0; j < island[0].length; j++) {
//                flag = true;
//                if (island[i][j] == 1) {
//                    int tmp = calc(island, i, j);
//                    num++;
//                    if (tmp > max) {
//                        max = tmp;
//                    }
//                }
//            }
//        }
//        res[0] = max;
//        res[1] = num;
//        return res;
//    }
//    private static int calc(int[][] island,int x,int y) {
//        int num = 1;
//        if (x == 0 || x == island.length || y == 0|| y == island[0].length)
//            flag = false;
//        island[x][y] = 0;
//        if ((x-1)>=0 && island[x-1][y] == 1)
//            num += calc(island,x-1,y);
//        if ((x+1)<island.length && island[x+1][y] == 1)
//            num += calc(island,x+1,y);
//        if ((y-1)>=0 && island[x][y-1] == 1)
//            num += calc(island,x,y-1);
//        if ((y+1)<island.length && island[x][y+1] == 1)
//            num += calc(island,x,y+1);
//
//        if ((x+1)<island.length && (y+1)<island.length && island[x+1][y+1] == 1)
//            num += calc(island,x+1,y+1);
//        if ((x-1)>=0 && (y+1)<island.length && island[x-1][y+1] == 1)
//            num += calc(island,x-1,y+1);
//        if ((x-1)>=0 && (y-1)>=0 && island[x-1][y-1] == 1)
//            num += calc(island,x-1,y-1);
//        if ((x+1)<island.length && (y-1)>=0 && island[x+1][y-1] == 1)
//            num += calc(island,x+1,y-1);
//        return num;
//    }
//}