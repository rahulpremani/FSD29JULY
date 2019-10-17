package assignments1;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
//import org.apache.commons.lang3.*;

public class ArrayReversingAndSorting {

	static int[] getSorted(int[] integerArray) {
		
		 List<Integer> list = Arrays.stream(integerArray).boxed().collect(Collectors.toList());
		 Collections.reverse(list);
		 Collections.sort(list);
		 return list.stream().mapToInt(i->i).toArray();
	}
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int[] integerArray = new int[6];
		System.out.println("Enter "+integerArray.length+" numbers :");
		for(int i = 0; i<integerArray.length; i++) {
			integerArray[i] = scan.nextInt();
		}
		
		for(int temp : ArrayReversingAndSorting.getSorted(integerArray)) {
			System.out.println(temp);
		}
		scan.close();
	}

}
