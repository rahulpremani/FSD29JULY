import java.util.*;

class SplitString {
	
	static String[] split(String str, String delimit) {

		int index = 0;
		int temp = 0;
		boolean flag = false;

		ArrayList<String> al = new ArrayList<String>();
		while(index < str.length() && index !=-1) {
			index = str.indexOf(delimit , temp);
			if(index != -1) {
				al.add(str.substring(temp,index));
				temp = index + delimit.length();
				flag = true;
			}
		}
		
		if(flag) {
			al.add(str.substring(temp,str.length()));
			return al.toArray(new String[al.size()]);
		}
		else {
			al.add("-1");
			return al.toArray(new String[al.size()]);
		}
}

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the String : ");
		String str = scan.nextLine();
		System.out.println("Enter the delimiter : ");
		String delimit = scan.nextLine();

		String[] result = SplitString.split(str,delimit);

		for(String k : result) {
			System.out.println(k);
		}
	}
}
