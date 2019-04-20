package test;

import java.util.Stack;

/**
 * @author yzd
 * @version Id: Solution.java, v 0.1 2018年09月25日 8:58 yzd Exp $
 */
public class Solution {

    Stack<Integer> data = new Stack<>();
    Stack<Integer> min = new Stack<>();
    Integer temp = null;

    public void push(int node) {
        if(temp != null){
            if(node <= temp){
                temp = node;
                min.push(node);
            }
            data.push(node);
        }else{
            temp = node;
            data.push(node);
            min.push(node);
        }
    }

    public void pop() {
        int num = data.pop();
        int num2 = min.pop();
        if(num != num2){
            min.push(num2);
        }
    }

    public int top() {
        int num = data.pop();
        data.push(num);
        return num;
    }

    public int min() {
        int num = min.pop();
        min.push(num);
        return num;
    }

}