package HW;

import java.util.ArrayList;
import java.util.List;

public class HW3 {

	/** -------------------------- Problem 1 --------------------------
	 * An O(n) time method for computing a sequence representing the set A\B 
	 * A and B are both sorted in increasing order
	 * 
	 * 
	 * @param s1
	 * @param s2
	 * @return 
	 */
	public List<Integer> difference(int[] A, int[] B){
		List<Integer> result = new ArrayList<Integer>();
		
		int len1 = A.length;
		int len2 = B.length;
		
		int i = 0;
		int j = 0;

		while (i < len1 && j < len2) {
			if(B[j] < A[i])
				j += 1;
			else if(B[j] == A[i]){
				i += 1;
				j += 1;
			}
			else {
				result.add(A[i]);
				i += 1;
			}
		}
		
		if(i<len1){
			for(int k = i; k < len1; k++)
				result.add(A[k]);
		}
		return result;
	}
	
	/** -------------------------- Problem 3 --------------------------
	 *  O(nlogn) method to determine if there is an a in array A and b in array B 
	 *  such that a+b = x
	 *  A and B are unsorted, length of n
	 * @param args 
	 */
	
	public boolean twoSum(int[] A, int[] B, int x){
		
		List<Integer> pre = new ArrayList<Integer>();
		List<Integer> pro = new ArrayList<Integer>();
		
		if(A.length == 0 || B.length == 0)
			return false;
		
		int pivot = A[0];
		int goal = x - pivot;
		
		for(int i=0; i<A.length; i++){
			if(A[i] < pivot)
				pre.add(A[i]);
			else if(A[i] > pivot)
				pro.add(A[i]);
		}
		int[] A1 = transform(new ArrayList<Integer>(pre));
		int[] A2 = transform(new ArrayList<Integer>(pro));
		pre.clear();
		pro.clear();
		
		for(int i=0; i<B.length; i++){
			if(B[i] < goal)
				pre.add(B[i]);
			else if(B[i] == goal)
				return true;
			else
				pro.add(B[i]);
		}
		
		int[] B1 = transform(new ArrayList<Integer>(pre));
		int[] B2 = transform(new ArrayList<Integer>(pro));
		pre.clear();
		pro.clear();
		
		return twoSum(A1, B2, x) || twoSum(A2, B1, x);
		
	}
	
	public int[] transform(List<Integer> list){
		int[] res = new int[list.size()];
		for(int i = 0; i<list.size(); i++)
			res[i] = list.get(i);
		return res;
	}
	
	
	
	public static void main(String[] args) {
		HW3 hw = new HW3();
		// Test problem 1
		int[] s1 = {1,3,5,7,9,10,11,23};
		int[] s2 = {};
		List<Integer> res = hw.difference(s1, s2);
		for (int i = 0; i < res.size(); i++) {
			System.out.print(res.get(i) + " ");
		}
		// test problem 3
		int[] A = {1,3,5,7,9};
		int[] B = {2,4,6,8,10};
		int x = 13;
		System.out.println(hw.twoSum(A, B, x));
		
		
	}
}
