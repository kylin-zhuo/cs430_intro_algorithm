package HW;

public class HW5 {
	
	/*
	 * Problem 1
	 * Calculate the adjacency matrix of G^2 given that of G
	 */
	public static int[][] transferToG2(int[][] G1){
		int size = G1.length;
		int[][] G2 = new int[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if(G1[i][j] == 1){
					for (int k = 0; k < size; k++) {
						if(G1[j][k] == 1)
							G2[i][k] = 1;
					}
				}
			}
		}
		return G2;
	}
	
	public static void printMatrix(int[][] G){
		for (int i = 0; i < G.length; i++) {
			for (int j = 0; j < G.length; j++) {
				System.out.print(G[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		int[][] G1 = {{0,1,0,0},{0,0,1,0},{0,0,0,1},{1,0,0,0}};
		int[][] G2 = HW5.transferToG2(G1);
		printMatrix(G2);
	}
	
}
