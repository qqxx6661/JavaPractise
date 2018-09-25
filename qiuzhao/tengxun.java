package qiuzhao;

import java.util.Arrays;
import java.util.Scanner;
/**
 * @author yzd
 * @version Id: tengxun.java, v 0.1 2018年09月18日 20:41 yzd Exp $
 */


public class tengxun {


    public static int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int size = nums.length;
        int ans = 0;
        for (int i = 0; i < size - 2; i++) {
            if (nums[i] == 0) continue;
            int k = i + 2;
            for (int j = i + 1; j < size - 1; j++) {
                while (k < size && nums[k] < nums[i] + nums[j]) k++;
                ans += k - j - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int timushu = sc.nextInt();
        for(int i = 0; i < timushu; i++){
            int array_len = sc.nextInt();
            int[] array = new int[array_len];
            for(int j = 0; j < array_len; j++){
                array[j] = sc.nextInt();
            }
//            System.out.println(Arrays.toString(array));
            System.out.println(triangleNumber(array));
        }


    }
}