import com.cg.eis.exception.EmployeeException;
import java.util.Scanner;

class SalaryChecker{

	public static void main(String[] args) throws EmployeeException{
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the employee's salary :");
		int salary = scan.nextInt();
		if(salary<3000) {
			throw new EmployeeException();
		}
		else {
			System.out.println("The salary is : " + salary);
		}
	}
}