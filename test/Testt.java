package test;

import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Testt {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        MyThread1 m1 = new MyThread1(s);
        FutureTask<String> ft1 = new FutureTask<>(m1);
        Thread thread1 = new Thread(ft1);
        thread1.start();

        MyThread2 m2 = new MyThread2(ft1.get());
        FutureTask<String> ft2 = new FutureTask<>(m2);
        Thread thread2 = new Thread(ft2);
        thread2.start();

        MyThread3 m3 = new MyThread3(ft2.get());
        FutureTask<String> ft3 = new FutureTask<>(m3);
        Thread thread3 = new Thread(ft1);
        thread3.start();

        System.out.println(ft3.get());

    }
}

class MyThread1 implements Callable<String> {

    private String name;

    MyThread1(String name) {
        this.name = name;
    }


    @Override
    public String call() {
        return name+"_A";
    }
}

class MyThread2 implements Callable<String> {

    private String name;

    MyThread2(String name) {
        this.name = name;
    }


    @Override
    public String call() {
        return name+"_B";
    }
}

class MyThread3 implements Callable<String> {

    private String name;

    MyThread3(String name) {
        this.name = name;
    }


    @Override
    public String call() {
        return name+"_C";
    }
}