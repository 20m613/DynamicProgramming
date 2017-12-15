package dp;
import genericImplementations.tree.Tree;

import java.util.*;
public class SegmentTree {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=0;
		int q=0;
		int L=0;
		int R=0;
		if(sc.hasNext())
			n=sc.nextInt();
		if(sc.hasNext())
			q=sc.nextInt();
		if(sc.hasNext())
			L=sc.nextInt();
		if(sc.hasNext())
			R=sc.nextInt();
		int[] seq=new int[n+1];
		
		int a = (int) (Math.ceil(Math.log(n) / Math.log(2)));
	    int max_size = 2 * (int) Math.pow(2, a) - 1;
		TreeNode tree[]=new TreeNode[max_size];
		
		while(--q>=0){
			int query=0;
			if(sc.hasNext())
				query=sc.nextInt();
			if(query==1){
				int x=0;
				int y=0;
				if(sc.hasNext())
					x=sc.nextInt();
				if(sc.hasNext())
					y=sc.nextInt();
				update(0, 0, max_size, L, R, x, y, tree, seq);
				//seq[x]=y;//aise update nahi karna hai..Have to update the tree.
			}
			else{
				int l=0;
				int r=0;
				if(sc.hasNext())
					l=sc.nextInt();
				if(sc.hasNext())
					r=sc.nextInt();
				
			}
			
		}
	}
	
	public static void build(TreeNode[] tree){
		
	}
	
	
	public static int update(int parent,int start, int end,int L, int R ,int index, int val, TreeNode tree[],int[] seq){
		if(end<=start)
			tree[start].val=val>R?1:0;
		int mid=(start+end)/2;
		if(index>=start && index<=end)
			update(2*parent,start, mid-1, L, R, index, val, tree,seq);
		else
			update(2*parent+1,mid, end, L, R, index, val, tree,seq);
		tree[parent].subArrays=tree[2*parent].subArrays+tree[2*parent+1].subArrays+calc(tree[2*parent],tree[2*parent+1],seq);//calc is functiuon that takes care of the cases when seq of 1's spanning left and right
		return tree[parent].subArrays;
	}
	
	public static int calc(TreeNode left, TreeNode right,int[] seq){
		int lCount=0;
		int rCount=0;
		for(int i=left.r;i>=left.l;i--){
			if(seq[i]==1)
				lCount++;
			else
				break;
		}
		for(int i=right.l;i<=right.r;i++){
			if(seq[i]==1)
				rCount++;
			else
				break;
		}
		return lCount*rCount;
	}
}
class TreeNode{
	int val;
	int l;
	int r;
	int subArrays;
	public TreeNode(){
		val=0;
		l=0;
		r=0;
		subArrays=0;
	}
	public TreeNode(int l, int r){
		this.l=l;
		this.r=r;
		subArrays=0;
	}
}
