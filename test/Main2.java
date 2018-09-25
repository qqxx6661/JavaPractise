package test;

import java.io.*;
import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        Count count = new Count();
        count.count(count.getCount()).getCount();
        new Count().count(count.getCount());
    }
    public static class Count{
        volatile Integer count = 2018;
        public Count count(Integer count){
            System.out.println(++count);
            return this;
        }
        public Integer getCount(){
            System.out.println(++count);
            return count;
        }
    }

}