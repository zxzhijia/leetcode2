import java.util.*;
public class Test {
	public static void main(String[] args) {
		Solution solver = new Solution();
		int[] nums = {1,2,3};

		boolean ret = solver.containsDuplicate( nums );

		System.out.println( ret );
	}
}
