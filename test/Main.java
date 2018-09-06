package test;

import java.util.Scanner;

/**
 * Created by lenovo on 2018/9/3.
 */
public class Main {
    //    public static int diGuiF(int m,int n){
//        if(n == m){
//            return 0;
//        }
//        if(diGuiF(m+1,n)<diGuiF(2*m,n)){
//            return diGuiF(m+1,n)+1;
//        }
//        else {
//            return diGuiF(2*m,n)+1;
//        }
//    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int length = Math.max(n, m);
        int a[] = new int[2*(length+1)];
        int b[] = new int[2*(length+1)];
        int countB = 0;
        a[n]=0;
        b[n]=1;
        while (countB<2*length +1 ) {
            for (int i = 1; i < 2*(length+1); i++) {
                if (b[i] == 1) {
//                    if ( b[i - 1] == 0 || a[i - 1] > a[i] + 1) {
                    if ( b[i - 1] == 0 ) {
                        a[i - 1] = a[i] + 1;
                        b[i - 1] = 1;
                    }
//                    if (b[i * 2] == 0 || a[i * 2] > a[i] + 1) {
                    if(i  < (length)){
                        if (b[i * 2] == 0 ) {
                            a[i * 2] = a[i] + 1;
                            b[i * 2] = 1;
                        }
                    }

                }


            }

            if (b[m] == 1) {
                System.out.print(a[m]);
                break;
            }
            countB = 0;
            for (int i = 1; i < 2*(length+1); i++) {
                countB = countB +b[i];
            }
        }
    }


}