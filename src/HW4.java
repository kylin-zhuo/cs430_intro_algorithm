package HW;

public class HW4 {

	
	/**	Homework 4
	 * 
	 * 
	*/
	
	/* problem 3 KNAPSACK PROBLEM
	 * 
	 * Dynamic Programming
	 * s[i]: the sizes of n objects
	 * p[i]: the profits of n objects
	 * B: the size of the sack
	 * m[n+1][B+1]: the space to save the step result
	 * Rules:
	 * m[i][s] = m[i-1][s], if s[i] > s
	 * m[i][s] = max(m[i-1][s-s[i]]+p[i], m[i-1][s]), if s[i] <= s
	 * m[0][0] = 0
	 */
	
	public int knapsack(int[] s, int[] p, int B){
		int n = s.length;
		int[][] m = new int[n+1][B+1];
		// Initialization, the first column and the first row should be all 0
		for(int i = 0; i <= B; i++)
			m[0][i] = 0;
		for(int i = 0; i <= n; i++)
			m[i][0] = 0;
		// Start the recursive process
		for(int i = 1; i <= n; i++){
			for(int j = 1; j <= B; j++){
				if(s[i-1] > j)
					m[i][j] = m[i-1][j];
				else
					m[i][j] = Math.max(m[i-1][j-s[i-1]]+p[i-1], m[i-1][j]);
			}
		}
		mprint(m);
		return m[n][B];
	}

	public void mprint(int[][] m){
		for(int i = 0; i < m.length; i++){
			for(int j = 0; j < m[0].length; j++){
				System.out.print(m[i][j] + "\t");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		HW4 console = new HW4();
		int[] s = {1,3,2,4,5,1};
		int[] p = {2,3,4,4,3,5};
		int B = 10;
		int res = console.knapsack(s, p, B);
		System.err.println("Result: " + res);
 	}
	
}
