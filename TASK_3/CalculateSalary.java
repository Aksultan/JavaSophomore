import java.util.*;
import java.lang.*;
import java.io.*;
public class CalculateSalary {
	public static void main(String args[]){
		File file=new File("staff.txt");
		Scanner in=new Scanner(System.in);
		Scanner scanner=new Scanner(System.in);
		ArrayList<Staff> staff=new ArrayList<>();
		try{
			in=new Scanner(file);
			while(in.hasNext()){
				String line=in.nextLine();
				String[] parts=line.split(" ");
					Staff sff=new Staff();
					sff.Name=parts[1];
					sff.Surname=parts[2];
					sff.birth_year=Integer.parseInt(parts[3]);
					sff.startedWork=Integer.parseInt(parts[4]);
			}
		}catch(FileNotFoundException e){
				System.out.print("NO FILE!");
		}
	}
}
class Pedagogical extends Staff{
	int papers;
	String degree;
}
class Technical extends Staff{
	boolean managerial;
	 String department;
}
/*
Or Staff extends Technical and Pedagogical??
*/

class Staff{
		String Name, Surname;
		 int birth_year, startedWork;

		 /*abstract void Salarycalc();*/
}
/*class Salary extends Staff{

}*/
