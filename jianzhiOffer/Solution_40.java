package jianzhiOffer;

import java.util.*;

public class Solution_40 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        // 由于本题需要返回ArrayList<Integer>，所以新建之
        ArrayList<Integer> list = new ArrayList<>();
        // 若输入数组长度小于k。直接返回数空的ArrayList
        if(input.length < k){
            return list;
        }
        // 调用找到k个最小数的函数，改变了数组数字位置，之后写入ArrayList
        findKMin(input,0,input.length-1,k);
        System.out.println(Arrays.toString(input));
        for(int i = 0; i < k; i++){
            list.add(input[i]);
        }
        return list;
    }

    // 找到k个最小数的函数
    private void findKMin(int[] a, int start, int end, int k){
        if(start < end){
            int pos = partition(a, start, end);
            System.out.println(pos);
            // 一旦到了k（数组中k-1）这个位置，就找到了前k个小的数，返回
            if(pos == k-1){
                return ;
            }else if(pos < k-1){
                findKMin(a,pos+1,end,k);
            }else{
                findKMin(a,start,pos-1,k);
            }
        }
    }

    // 快排中的每次排序实现（挖坑填数法），返回的是交换后start位置（快排一次后的中轴点，中轴点左边全是小于它的，右边都是大于它的）
    public int partition(int[] a, int start, int end){
        int pivot = a[start];
        while(start < end){
            while(start < end && a[end] >= pivot){end--;};
            a[start] = a[end];
            while(start < end && a[start] <= pivot){start++;};
            a[end] = a[start];
        }
        a[start] = pivot;
        return start;
    }



    public ArrayList<Integer> GetLeastNumbers_Solution_2(int [] input, int k) {
        // 由于本题需要返回ArrayList<Integer>，所以新建之
        ArrayList<Integer> res = new ArrayList<>();
        // 几种特殊情况
        if (k > input.length|| k == 0) {
            return res;
        }
        // 构造优先队列，排序方法是自然数顺序的逆序，所以是个最大堆，这样这个堆的堆顶就是所有数中的最大数
        Queue<Integer> queue = new PriorityQueue<>(k, Collections.reverseOrder());

        for (int i = 0; i < input.length; i++) {
            // 最大堆内数字个数少于k，一直添加到k个
            if (queue.size() < k) {
                queue.add(input[i]);
            }
            else {
                // 若堆内最大的数字大于数组中的数字，则将数字出堆，并放入这个小的数
                if (input[i] < queue.peek()) {
                    queue.remove();
                    queue.add(input[i]);
                }
            }
        }

        // 结束上面循环后，堆内就是最小的k个数
        while (!queue.isEmpty()) {
            res.add(queue.remove());
        }
        return res;
    }


    public static void main(String[] args) {
        int[] a = {4,5,1,6,2,7,3,8};
        Solution_40 solution_40 = new Solution_40();
        System.out.println(solution_40.GetLeastNumbers_Solution(a,4));
    }

}
