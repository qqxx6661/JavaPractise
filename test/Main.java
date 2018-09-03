package test;

/**
 * @author yzd
 * @version Id: Main.java, v 0.1 2018年08月13日 16:19 yzd Exp $
 */
public class Main {
    public static void main(String[] args) {
        String a = "haha";
        String b = "haha";
        char c [] = {'h','a','h','a'};
        System.out.println(a.equals(b));
        System.out.println(b.equals(c));
        System.out.println(b.equals(new String("haha")));
        System.out.println(a==b);
//        System.out.println(b==c);

    }



}