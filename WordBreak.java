package dp;
//google interview
public class WordBreak {
	public static void main(String[] args) {
		System.out.println("ilikesamsung:  "+wordBreak("ilikesamsung"));
		//System.out.println("i".substring(0,1));
		//System.out.println("i".substring(1));
	}
	
	public static boolean wordBreak(String str){
		int size=str.length();
		if(size==0)
			return true;
		for(int i=1;i<=size;i++){
			if((wordPresentInDictionary(str.substring(0,i))&&wordBreak(str.substring(i))))//subString(start,end): end character is not included
				return true;//if both prefix and suffix are present then return true to its daddy otherwise increment the i i.e check for the new prefix and new suffix.
		}
		return false;
	}
	
	
	public static boolean wordPresentInDictionary(String str){
		String[] dic={"mobile","samsung","sam","sung",
                	  "man","mango","icecream","and",
                	  "go","i","like","ice","cream"};
		for(int i=0;i<dic.length;i++)
			if(dic[i].equals(str))
				return true;
		return false;
	}
}
