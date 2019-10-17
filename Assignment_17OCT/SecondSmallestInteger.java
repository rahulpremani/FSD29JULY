package assignments1;

import java.util.Arrays;

public class SecondSmallestInteger {

	static int findSecondSmallestInteger(int[] integerArray) {
		Arrays.sort(integerArray);
		return integerArray[1];
	}
	public static void main(String[] args) {
		
		int[] integerArray = {92,0,43,76,12};
		System.out.println(SecondSmallestInteger.findSecondSmallestInteger(integerArray));

	}

}
