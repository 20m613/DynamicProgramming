package dp;

public class PossibleWalks {
	public static void main(String[] args) {
		int graph[][] ={ {0, 1, 1, 1},
	            		 {0, 0, 1, 1},
	            		 {0, 0, 0, 1},
	            		 {0, 0, 0, 0}};
		System.out.println(countPaths(graph, 0, 3, 3));
	}
	//reach source to destination with exactly k edges in the path.
	public static int countPaths(int[][] graph, int source, int destination, int k){
		if(k==0 && source == destination)
			return 1;
		if(k<0)
			return 0;
		int row=graph.length;
		int count=0;
		//int result=Integer.MAX_VALUE;
		for(int i=0;i<row;i++){
			if(graph[source][i]==1){
				count+=countPaths(graph, i, destination, k-1);
			}
		}
		return count;
	}
}
