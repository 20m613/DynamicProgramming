package dp;
//No Duplicates allowed..
//Java program to print all permutations of a given string.
public class Permutations
{
 public static void main(String[] args)
 {
     //String str = "1123";//gives duplicate permutations
	 String str="1123";
     int n = str.length();
     Permutations permutation = new Permutations();
     permutation.permute(str, 0, n-1);
 }

 /**
  * permutation function
  * @param str string to calculate permutation for
  * @param l starting index
  * @param r end index
  */
 private void permute(String str, int l, int r)
 {
     if (l == r)
         System.out.println(str);
     else
     {
         for (int i = l; i <= r; i++)
         {
	             str = swap(str,l,i);
        	 
	             //System.out.println("i:  "+i+"  l:  "+l);
	             permute(str, l+1, r);
	             //System.out.println("Before 2nd swap:  "+str);
	             str = swap(str,l,i);//second swap is required for backtracking
	             //System.out.println("after 2nd swap:  "+str);
        	 
         }
     }
 }

 /**
  * Swap Characters at position
  * @param a string value
  * @param i position 1
  * @param j position 2
  * @return swapped string
  */
 public String swap(String a, int i, int j)
 {
     char temp;
     char[] charArray = a.toCharArray();
     temp = charArray[i] ;
     charArray[i] = charArray[j];
     charArray[j] = temp;
     return String.valueOf(charArray);
 }

}