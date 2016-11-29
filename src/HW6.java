package HW;

public class HW6 {

	public static int[] findMaxCapacity(int[][] Graph){
		int V = Graph.length;
		int[] result = new int[V];
		// initialize the result
		for (int i = 0; i < V; i++) {
			result[i] = Graph[0][i];
		}
		int cap;
		for (int i = 1; i < V; i++) {
			for (int j = 1; j < V; j++) {
				if(j!=i){
					cap = Math.min(Graph[i][j], result[i]);
					if(cap > result[j])
						result[j] = cap;
				}

			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[][] graph = {{0,4,1,1},{2,0,7,2},{3,3,0,4},{5,5,8,0}};
		int[] res = HW6.findMaxCapacity(graph);
		for (int i = 0; i < res.length; i++) {
			System.out.print(res[i] + " ");
		}
	}
	
}
