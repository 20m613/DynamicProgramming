package dp;
import java.util.*;

import com.sun.corba.se.spi.ior.MakeImmutable;

public class CoinChange {
	public static void main(String[] args){
		int[] set={2,2,3};
		int money=4;
		System.out.print("Number of ways to make: "+money+" from the given set: { ");
		int i=0;
		for(;i<set.length;i++)
			System.out.print( set[i]+" ");
		System.out.print("} are: "+makeChange(set,set.length,money));
	}
	//Let there be m different coins
	//1: the case where mth coin is included 
	//2: the case where mth coin is not included
	//return 1+2
	private static int makeChange(int[] set,int index,int money){
		if(money==0)
			return 1;
		if(money<0)
			return 0;
		if(money>0 && index<=0)
			return 0;
		
		return makeChange(set, index, money-set[index-1]) + makeChange(set, index-1, money);
	}
}
