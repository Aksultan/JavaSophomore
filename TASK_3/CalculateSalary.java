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
class Staff{
		String Name, department, Surname, degree;
		 int birth_year, startedWork, papers;
		 boolean managerial;
		 staff.add(this.Name);
		 /*abstract void Salarycalc();*/
		 public void Pedagogical(){
			 this.degree=degree;
			 this.papers=papers;
		 }
		 public void Technical(){
			 this.department=department;
			 this.managerial=managerial;
		 }
}
/*class Salary extends Staff{

}*/
