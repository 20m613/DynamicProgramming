package dp;
import java.util.Scanner;

public class Shuffle {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		while(true){
			//System.out.println("abc".substring(1).equals("defabc".substring(4)));
			String str1=sc.next();
			String str2=sc.next();
			String str3=sc.next();
			System.out.println(ifPossible(str1, str2, str3, 0, 0, 0));
		}
	}
	
	//use memoizaton to improve this if possible
	public static boolean ifPossible(String s1, String s2,String s3, int st1, int st2, int st3){
		int L1=s1.length();
		int L2=s2.length();
		int L3=s3.length();
		if(st1==L1 && st2==L2){
			if(st3==L3)
				return true;
			else
				return false;
		}
		if(st1==L1 && st2!=L2 && st3==L3)
			return false;
		if(st1!=L1 && st2==L2 && st3==L3)
			return false;	
		if(st1!=L1 && st2!=L2 && st3==L3)
			return false;
		
		if(st1==L1 && st2==L2 && st3==L3)
			return true;
		if(st1==L1 && s2.substring(st2).equals(s3.substring(st3)))
			return true;
		else if(st1==L1 && !s2.substring(st2).equals(s3.substring(st3)))
			return false;
		if(st2==L2 && s1.substring(st1).equals(s3.substring(st3)))
			return true;
		else if(st2==L2 && !s1.substring(st1).equals(s3.substring(st3)))
			return false;
		
		if(s1.charAt(st1)==s3.charAt(st3) && s2.charAt(st2)!=s3.charAt(st3))
			return ifPossible(s1, s2, s3, st1+1, st2, st3+1);
		else if(s2.charAt(st2)==s3.charAt(st3) && s1.charAt(st1)!=s3.charAt(st3))
			return ifPossible(s1, s2, s3, st1, st2+1, st3+1);
		else if(s2.charAt(st2)==s3.charAt(st3) && s1.charAt(st1)==s3.charAt(st3))
			return ifPossible(s1, s2, s3, st1+1, st2, st3+1) || ifPossible(s1, s2, s3, st1, st2+1, st3+1);
		else
			return false;
	}
}
