//给定一个字符串，逐个翻转字符串中的每个单词。
//
// 
//
// 示例 1： 
//
// 输入: "the sky is blue"
//输出: "blue is sky the"
// 
//
// 示例 2： 
//
// 输入: "  hello world!  "
//输出: "world! hello"
//解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
// 
//
// 示例 3： 
//
// 输入: "a good   example"
//输出: "example good a"
//解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
// 
//
// 
//
// 说明： 
//
// 
// 无空格字符构成一个单词。 
// 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。 
// 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。 
// 
//
// 
//
// 进阶： 
//
// 请选用 C 语言的用户尝试使用 O(1) 额外空间复杂度的原地解法。 
// Related Topics 字符串


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseWords(String s) {
        char[] chas = s.toCharArray();
        reverseString(chas, 0, chas.length-1);
        System.out.println(Arrays.toString(chas));
        int begin = 0;
        String streamStr = String.valueOf(chas);
        String[] arr = streamStr.trim().split("\\s+");
        System.out.println(Arrays.toString(arr));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            char[] tempChas = arr[i].toCharArray();
            reverseString(tempChas, 0, tempChas.length-1);
            sb.append(String.valueOf(tempChas));
            if (i != arr.length-1) {
                sb.append(" ");
            }
        }
        return sb.toString();

    }

    private void reverseString(char[] chas, int from, int to){
        while (from < to) {
            char temp = chas[from];
            chas[from++] = chas[to];
            chas[to--] = temp;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
