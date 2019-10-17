package assignments1;

import java.util.Arrays;

public class StringsArrayInUppecaseAndLowerCase {

	static String[] stringArraySortingAndCasing(String[] stringArray) {
		
		Arrays.sort(stringArray);
		
		if((stringArray.length)%2 == 0) {
			for(int i = 0; i< (stringArray.length/2); i++) {
				stringArray[i] = stringArray[i].toUpperCase();
			}
		} else {
			for(int i = 0; i< (stringArray.length/2)+1; i++) {
				stringArray[i] = stringArray[i].toUpperCase();
			}
		}
		return stringArray;
	}
	public static void main(String[] args) {
		
		String[] stringArray = {"Rahul","Kashyap","Ankush","Ajay","Sagar","Manish","Aditya","Chirag","Bhushan"};
		
		for(String str : StringsArrayInUppecaseAndLowerCase.stringArraySortingAndCasing(stringArray)) {
			System.out.println(str);
		}

	}

}
