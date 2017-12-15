package dp;

public class LargestIndependentSet {
	public static void main(String[] args) {
		node root = new node(20);
        root.left = new node(8);
        root.left.left = new node(4);
        root.left.right = new node(12);
        root.left.right.left = new node(10);
        root.left.right.right = new node(14);
        root.right = new node(22);
        root.right.right = new node(25);
        System.out.println("Size of the Largest Independent Set is " + liss(root));
	}
	public static int liss(node root){
		if(root==null)
			return 0;
		int exclude=liss(root.left)+liss(root.right);
		int include=1;
		if(root.left!=null)
			include+=liss(root.left.left)+liss(root.left.right);
		if(root.right!=null)
			include+=liss(root.right.left)+liss(root.right.right);
		System.out.println("data:  "+root.data);
		System.out.println("Exclude:  "+exclude+"  Include:  "+include);
		return getMax(include,exclude);
	}
	public static int getMax(int a, int b){
		return a>b?a:b;
	}
}
class node 
{
    int data;
    node left, right;

    public node(int data) 
    {
        this.data = data;
    }
}
