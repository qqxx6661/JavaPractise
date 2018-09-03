package test;

import java.util.Scanner;

/**
 * Created by lenovo on 2018/8/30.
 */
public class chiMaoLiang {
    public  static  int testK(int k,int p[]){
        int n = 0;
        for(int i = 0;i<p.length;i++){
            int tmp =p[i]/k;
            if(tmp*k<p[i])
                tmp++;
            n = n+tmp;
        }
        return n;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] arr=str.split(" ");
        int[] P = new int[arr.length];

        int sum = 0;
        for(int i = 0;i<arr.length;i++){
            P[i] = Integer.parseInt(arr[i]);
            sum = sum +P[i];
        }
        int H = sc.nextInt();

        int k = sum/H;
        if(testK(k,P)==H)
            System.out.print(k);

        while(testK(k,P)>H){
            k++;
        }
        System.out.print(k);

    }
}