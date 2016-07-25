import java.util.Scanner;
public class pailie {
	 public void combine(int[] arr, int start, int[] result, int count, int NUM, int arr_len) {
		  int i = 0;
		  for (i = start; i< arr_len+1 - count; i++)
		  {
			  result[count-1] = i;
			  if (count-1==0)
			  {
				  int j;
				  for(j=NUM-1;j>=0;j--)
					  System.out.print(arr[result[j]]+"\t");    
				  System.out.println();
			  }
			  else
				  combine(arr, i+1, result, count-1, NUM, arr_len);
		  }
	 }
	 
	 public static void main(String[] args) {
		 @SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in); 
		 int k=6;
		 int arr[]=new int[k];
		  for(int i = 0;i < k; i++){
			   System.out.println("Please input a number: ");  
			   arr[i] = sc.nextInt(); }
		  int t = 4;
		  int result[]=new int[t];
		  pailie p = new pailie();
		  p.combine(arr, 0, result, t, t, arr.length);
	 }
	 
}
